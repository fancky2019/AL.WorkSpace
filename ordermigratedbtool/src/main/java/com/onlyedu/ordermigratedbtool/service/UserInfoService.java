package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.EosStudentMapper;
import com.onlyedu.ordermigratedbtool.dao.UserInfoMapper;
import com.onlyedu.ordermigratedbtool.model.dto.RelativeStateDto;
import com.onlyedu.ordermigratedbtool.model.dto.RelativeUserInfoEosStudentDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoStatisticsDto;
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
import java.util.List;

@Service
public class UserInfoService {

    private final static Logger logger = LogManager.getLogger(UserInfoService.class);
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private EosStudentMapper eosStudentMapper;
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
                userInfoVO.setRelativeState(p.getRelativeState() != null ? p.getRelativeState() ? "已关联" : "未关联" : "未关联");
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
            for (UserInfo p : relativeUserInfoEosStudentDto.getUserInfoList()) {
                Integer result = userInfoMapper.updateRelative(p);
                if (result <= 0) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    messageResult.setMessage("关联失败");
                    messageResult.setCode(500);
                    return messageResult;
                }
            }
            ;
            for (EosStudent p : relativeUserInfoEosStudentDto.getEosStudentList()) {
                Integer result = eosStudentMapper.updateRelative(p);
                if (result <= 0) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    messageResult.setMessage("关联失败");
                    messageResult.setCode(500);
                    return messageResult;
                }
            }
            ;
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
}
