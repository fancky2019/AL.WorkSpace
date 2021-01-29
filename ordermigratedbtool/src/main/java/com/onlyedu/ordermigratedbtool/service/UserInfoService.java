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

import java.text.MessageFormat;
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

    //region 更新关联
    @Transactional(rollbackFor = Exception.class)
    public MessageResult<Void> updateRelative(RelativeUserInfoEosStudentDto relativeUserInfoEosStudentDto) {
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
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //如果不抛出异常，将不能自动回滚
//            throw e;
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
                    return setRollBackReturn("解除关联失败", 200);
                }
                //获取EosStudent关联UserInfo的个数
                List<RelativeStudent> relativeStudentList = relativeStudentMapper.getEosStudentRelative(userInfoStudentUnRelativeDto.getId());
                //删除RelativeStudent关联记录
                Integer delCount = relativeStudentMapper.deleteByUserInfoId(userInfoStudentUnRelativeDto.getId());
                if (delCount <= 0) {
                    return setRollBackReturn("解除关联失败", 200);
                }
                if (relativeStudentList.size() == 1) {
                    //EosStudent关联记录删除完了，更新EosStudent关联状态
                    RelativeStudent relativeStudent = relativeStudentList.get(0);
                    EosStudent eosStudent = new EosStudent();
                    eosStudent.setId(relativeStudent.getEosStudentId());
                    Integer res = eosStudentMapper.updateRelative(eosStudent);
                    if (res <= 0) {
                        return setRollBackReturn("解除关联失败", 200);
                    }
                }
            } else {
                //EosStudent解除关联
                EosStudent eosStudent = new EosStudent();
                eosStudent.setId(userInfoStudentUnRelativeDto.getId());
                Integer res = eosStudentMapper.updateRelative(eosStudent);
                if (res <= 0) {
                    return setRollBackReturn("解除关联失败", 200);
                }
                //获取EosStudent关联的UserInfo
                List<RelativeStudent> relativeStudentList = relativeStudentMapper.getEosStudentRelativeUserInfo(userInfoStudentUnRelativeDto.getId());
                List<Integer> userInfoIds = relativeStudentList.stream().map(p -> p.getUserInfoId()).collect(Collectors.toList());
                //更新UserInfo未关联
                Integer re = userInfoMapper.updateUnRelativeBatch(userInfoIds);
                if (re <= 0) {
                    return setRollBackReturn("解除关联失败", 200);
                }
                //删除RelativeStudent关联记录
                Integer delCount = relativeStudentMapper.deleteByEosStudentId(userInfoStudentUnRelativeDto.getId());
                if (delCount <= 0) {
                    return setRollBackReturn("解除关联失败", 200);
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

    private MessageResult<Void> setRollBackReturn(String msg, Integer code) {
        MessageResult<Void> messageResult = new MessageResult<>();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        messageResult.setMessage(msg);
        messageResult.setCode(code);
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

    public MessageResult<List<UserInfoVO>> getUserInfoByGuid(UserInfoDto userInfoDto) {
        MessageResult<List<UserInfoVO>> messageResult = new MessageResult<>();
        try {
            List<UserInfoDto> dtos = userInfoMapper.getUserInfoByGuid(userInfoDto);

            List<UserInfoVO> userInfoVOList = new ArrayList<>();
            dtos.forEach(dto ->
            {
                UserInfoVO userInfoVO = new UserInfoVO();
                BeanUtils.copyProperties(dto, userInfoVO);
                userInfoVO.setRegTime(dto.getRegTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
                userInfoVO.setRelativeStateStr(dto.getRelativeState() != null ? dto.getRelativeState() ? "已关联" : "未关联" : "未关联");
                userInfoVOList.add(userInfoVO);
            });

            messageResult.setData(userInfoVOList);
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

    @Transactional(rollbackFor = Exception.class)
    public MessageResult<Void> autoRelative() {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            List<UserInfoEosStudentRelativeDto> userInfoList = this.userInfoMapper.getSamePhoneWithEosStudent();
            if (userInfoList.size() > 0) {
                Integer paramCount = 2;
                Integer maxInsertCount = 2000 / paramCount;
                Integer loopCount = userInfoList.size() / maxInsertCount + 1;
                Integer result = 0;
                for (int i = 0; i < loopCount; i++) {
                    //插入RelativeStudent
                    List<UserInfoEosStudentRelativeDto> subList = userInfoList.stream().skip(maxInsertCount * i).limit(maxInsertCount).collect(Collectors.toList());
                    if (subList.size() > 0) {
                        List<RelativeStudent> relativeStudents = subList.stream().map(e ->
                                {
                                    RelativeStudent relativeStudent = new RelativeStudent();
                                    relativeStudent.setUserInfoId(e.getUserInfoId());
                                    relativeStudent.setEosStudentId(e.getEosStudentId());
                                    return relativeStudent;
                                }
                        ).collect(Collectors.toList());
                        //Insert 最大插入1000行，更新最大2100个参数
                        result = this.relativeStudentMapper.batchInsert(relativeStudents);
                        if (result <= 0) {
                            return setRollBackReturn("批量关联失败", 200);
                        }
                    }

                    //更新UserInfo
                    List<Integer> userInfoIds = subList.stream().map(p -> p.getUserInfoId()).distinct().collect(Collectors.toList());
                    result = this.userInfoMapper.updateRelativeBatch(userInfoIds);
                    if (result <= 0) {
                        return setRollBackReturn("批量关联失败", 200);
                    }
                    //更新EosStudent
                    List<Integer> eosStudents = subList.stream().map(p -> p.getEosStudentId()).distinct().collect(Collectors.toList());
                    result = this.eosStudentMapper.updateRelativeBatch(eosStudents);
                    if (result <= 0) {
                        return setRollBackReturn("批量关联失败", 200);
                    }
                }
            }
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

}
