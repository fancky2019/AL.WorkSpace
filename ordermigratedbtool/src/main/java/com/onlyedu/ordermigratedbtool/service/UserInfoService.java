package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.EosStudentMapper;
import com.onlyedu.ordermigratedbtool.dao.RelativeStudentMapper;
import com.onlyedu.ordermigratedbtool.dao.UserInfoMapper;
import com.onlyedu.ordermigratedbtool.model.dto.*;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.RelativeStudent;
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
    private RelativeStudentMapper relativeStudentMapper;
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

                //插入RelativeStudent关联记录
                RelativeStudent relativeStudent = new RelativeStudent();
                relativeStudent.setUserInfoId(id);
                relativeStudent.setEosStudentId(relativeUserInfoEosStudentDto.getEosStudentId());
                Integer ress = relativeStudentMapper.insert(relativeStudent);
                if (ress <= 0) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    messageResult.setMessage("关联失败");
                    messageResult.setCode(500);
                    return messageResult;
                }
                //更新UserInfo关联状态
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

            }
            //更新EosStudent关联状态
            EosStudent eosStudent = new EosStudent();
            eosStudent.setId(relativeUserInfoEosStudentDto.getEosStudentId());
            eosStudent.setRelativeState(true);
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

                //更新UserInfo
                UserInfo userInfo = new UserInfo();
                userInfo.setId(userInfoStudentUnRelativeDto.getId());
                Integer result = userInfoMapper.updateRelative(userInfo);
                if (result <= 0) {
                    return setRollBackReturn(messageResult);
                }
                //获取EosStudent关联UserInfo的个数
                List<RelativeStudent> relativeStudentList = relativeStudentMapper.getEosStudentRelative(userInfoStudentUnRelativeDto.getId());
                //删除RelativeStudent关联记录
                Integer delCount = relativeStudentMapper.deleteByUserInfoId(userInfoStudentUnRelativeDto.getId());
                if (delCount <= 0) {
                    return setRollBackReturn(messageResult);
                }
                if (relativeStudentList.size() == 1) {
                    //EosStudent关联记录删除完了，更新EosStudent关联状态
                    RelativeStudent relativeStudent = relativeStudentList.get(0);
                    EosStudent eosStudent = new EosStudent();
                    eosStudent.setId(relativeStudent.getEosStudentId());
                    Integer res = eosStudentMapper.updateRelative(eosStudent);
                    if (res <= 0) {
                        return setRollBackReturn(messageResult);
                    }
                }
            } else {
                //EosStudent解除关联
                EosStudent eosStudent = new EosStudent();
                eosStudent.setId(userInfoStudentUnRelativeDto.getId());
                Integer res = eosStudentMapper.updateRelative(eosStudent);
                if (res <= 0) {
                    return setRollBackReturn(messageResult);
                }
                //获取EosStudent关联的UserInfo
                List<RelativeStudent> relativeStudentList = relativeStudentMapper.getEosStudentRelativeUserInfo(userInfoStudentUnRelativeDto.getId());
                List<Integer> userInfoIds = relativeStudentList.stream().map(p -> p.getUserInfoId()).collect(Collectors.toList());
                //更新UserInfo未关联
                Integer re = userInfoMapper.updateUnRelativeBatch(userInfoIds);
                if (re <= 0) {
                    return setRollBackReturn(messageResult);
                }
                //删除RelativeStudent关联记录
                Integer delCount = relativeStudentMapper.deleteByEosStudentId(userInfoStudentUnRelativeDto.getId());
                if (delCount <= 0) {
                    return setRollBackReturn(messageResult);
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
            // throw e;
        }
        return messageResult;
    }

    private MessageResult<Void> setRollBackReturn(MessageResult<Void> messageResult) {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        messageResult.setMessage("解除关联失败");
        messageResult.setCode(500);
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
