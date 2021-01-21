package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.EosStudentMapper;
import com.onlyedu.ordermigratedbtool.dao.RelativeStudentMapper;
import com.onlyedu.ordermigratedbtool.dao.UserInfoMapper;
import com.onlyedu.ordermigratedbtool.model.dto.*;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.UserInfoVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInfoService {

    private final static Logger logger = LogManager.getLogger(UserInfoService.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private EosStudentMapper eosStudentMapper;

    @Autowired
    private  RelativeStudentMapper relativeStudentMapper;
    //region 获取有订单的学生列表

    /**
     * 获取有订单的学生列表
     *
     * @param userInfoDto
     * @return
     */
    public MessageResult<PageData<UserInfoVO>> getUserWithOrderPage(UserInfoDto userInfoDto) {
        MessageResult<PageData<UserInfoVO>> message = new MessageResult<>();
        try {
            Integer count = userInfoMapper.getUserWithOrderCount(userInfoDto);
            List<UserInfoDto> userInfoDtoList = userInfoMapper.getUserWithOrder(userInfoDto);
            PageData<UserInfoVO> pageData = new PageData<>();
            pageData.setCount(count);
            message.setCode(0);
            List<UserInfoVO> userInfoVOList = new ArrayList<>();
            userInfoDtoList.forEach(p ->
            {
                UserInfoVO userInfoVO = new UserInfoVO();
                BeanUtils.copyProperties(p, userInfoVO);
                userInfoVO.setRegTime(p.getRegTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
                userInfoVO.setRelativeStateStr(p.getRelativeState() != null ? p.getRelativeState() ? "已关联" : "未关联" : "未关联");
                userInfoVOList.add(userInfoVO);
            });
            pageData.setRows(userInfoVOList);
            message.setData(pageData);
        } catch (Exception ex) {
            message.setCode(500);
            message.setMessage(ex.getMessage());
            logger.error(ex.toString());
        }
        return message;
    }
    //endregion

    //region 更新关联装填
    @Transactional(rollbackFor = Exception.class)
    public MessageResult<Void> updateRelative(RelativeUserInfoEosStudentDto relativeUserInfoEosStudentDto) throws Exception {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            String userInfoIds = "";
            for (Integer id : relativeUserInfoEosStudentDto.getUserInfoIds()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(id);

                userInfo.setRelativeState(true);
                Integer result = userInfoMapper.updateRelative(userInfo);
                if (result <= 0) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    messageResult.setMessage("关联失败");
                    messageResult.setCode(500);
                    return messageResult;
                }
                userInfoIds += id + ",";
            }
            userInfoIds = userInfoIds.substring(0, userInfoIds.length() - 1);
            EosStudent eosStudent = new EosStudent();
            eosStudent.setId(relativeUserInfoEosStudentDto.getEosStudentId());
            eosStudent.setRelativeState(true);
//            eosStudent.setRelativeStudentID(userInfoIds);
            //查询原有的Db信息
            EosStudent eosStudentDb = eosStudentMapper.getEosStudentById(relativeUserInfoEosStudentDto.getEosStudentId());

            //将新关联的信息追加到原关联
//            String newUserInfoIds = eosStudentDb.getRelativeStudentID() == null ? userInfoIds : eosStudentDb.getRelativeStudentID() + "," + userInfoIds;
//            eosStudent.setRelativeStudentID(newUserInfoIds);
            Integer result = eosStudentMapper.updateRelative(eosStudent);
            if (result <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                messageResult.setMessage("关联失败");
                messageResult.setCode(500);
                return messageResult;
            }
            messageResult.setCode(0);
        } catch (Exception e) {

            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
            // 手动回滚
            //  TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //如果不抛出异常，将不能自动回滚
            throw e;
        }
        return messageResult;
    }
    //endregion

    //region 解除关联
    @Transactional(rollbackFor = Exception.class)
    public MessageResult<Void> unRelative(UserInfoStudentUnRelativeDto userInfoStudentUnRelativeDto) {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            //UserInfo 解除关联
            if (userInfoStudentUnRelativeDto.getUnRelativeType() == 0) {
                //先更新EosStudent后更新UserInfo
                EosStudent eosStudent = userInfoMapper.getRelativeEosStudentByUserInfoId(userInfoStudentUnRelativeDto.getId());
                if (eosStudent != null) {

                    String[] userInfoIds =null;// eosStudent.getRelativeStudentID().split(",");
                    List<Integer> listIds = Arrays.stream(userInfoIds).map(p -> Integer.valueOf(p)).collect(Collectors.toList());
                    listIds.remove(userInfoStudentUnRelativeDto.getId());
                    List<String> newStringIds = listIds.stream().map(p -> p.toString()).collect(Collectors.toList());

                    String newUserInfoIds = String.join(",", newStringIds);

                    if (newUserInfoIds != null && !newUserInfoIds.equals("")) {
                       // eosStudent.setRelativeStudentID(newUserInfoIds);
                    }else {
                        eosStudent.setRelativeStudentID(null);
                        eosStudent.setRelativeState(null);
                    }
                    Integer res = eosStudentMapper.updateRelative(eosStudent);
                    if (res <= 0) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        messageResult.setMessage("解除关联失败");
                        messageResult.setCode(500);
                        return messageResult;
                    }
                } else {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    messageResult.setMessage("解除关联失败");
                    messageResult.setCode(500);
                    return messageResult;
                }
                //更新UserInfo
                UserInfo userInfo = new UserInfo();
                userInfo.setId(userInfoStudentUnRelativeDto.getId());
                Integer result = userInfoMapper.updateRelative(userInfo);
                if (result <= 0) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    messageResult.setMessage("解除关联失败");
                    messageResult.setCode(500);
                    return messageResult;
                }
            } else {
                //EosStudent解除关联
                EosStudent eosStudent = eosStudentMapper.getEosStudentById(userInfoStudentUnRelativeDto.getId());
                List<String> userinfoIds = null;//Arrays.asList(eosStudent.getRelativeStudentID().split(","));
                List<Integer> ids = userinfoIds.stream().map(p -> Integer.valueOf(p)).collect(Collectors.toList());
                Integer result = userInfoMapper.updateUnRelativeBatch(ids);
                if (result <= 0) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    messageResult.setMessage("解除关联失败");
                    messageResult.setCode(500);
                    return messageResult;
                }
                Integer res = eosStudentMapper.updateRelative(eosStudent);
                if (res <= 0) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    messageResult.setMessage("解除关联失败");
                    messageResult.setCode(500);
                    return messageResult;
                }
            }
            messageResult.setCode(0);
        } catch (Exception e) {

            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
            // 手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //如果不抛出异常，将不能自动回滚
//            throw e;
        }
        return messageResult;
    }
    //endregion

    public MessageResult<UserInfoStatisticsDto> getUserInfoStatistics() {
        MessageResult<UserInfoStatisticsDto> messageResult = new MessageResult<>();
        try {
            UserInfoStatisticsDto result = userInfoMapper.getUserInfoStatistics();
            messageResult.setData(result);
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

    public MessageResult<List<Integer>> getGrade() {
        MessageResult<List<Integer>> messageResult = new MessageResult<>();
        try {
            List<Integer> result = userInfoMapper.getGrade();
            messageResult.setData(result);
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

    public MessageResult<List<RelativeStateDto>> getRelativeState() {
        MessageResult<List<RelativeStateDto>> messageResult = new MessageResult<>();
        try {
            List<RelativeStateDto> result = userInfoMapper.getRelativeState();
            messageResult.setData(result);
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

    public MessageResult<UserInfoVO> getUserInfoByGuid(UserInfoDto userInfoDto) {
        MessageResult<UserInfoVO> messageResult = new MessageResult<>();
        try {
            UserInfoDto dto = userInfoMapper.getUserInfoByGuid(userInfoDto);
            UserInfoVO userInfoVO = new UserInfoVO();
            BeanUtils.copyProperties(dto, userInfoVO);
            userInfoVO.setRegTime(dto.getRegTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
            userInfoVO.setRelativeStateStr(dto.getRelativeState() != null ? dto.getRelativeState() ? "已关联" : "未关联" : "未关联");
            messageResult.setData(userInfoVO);
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }
}
