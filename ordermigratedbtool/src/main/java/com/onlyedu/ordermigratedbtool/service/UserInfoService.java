package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.UserInfoMapper;
import com.onlyedu.ordermigratedbtool.model.dto.StudentOrderDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoDto;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.StudentOrderVO;
import com.onlyedu.ordermigratedbtool.model.vo.UserInfoVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {

    private final static Logger logger = LogManager.getLogger(UserInfoService.class);
    @Autowired
    private UserInfoMapper userInfoMapper;

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
            message.setSuccess(true);
            List<UserInfoVO> userInfoVOList = new ArrayList<>();
            userInfoDtoList.forEach(p ->
            {
                UserInfoVO userInfoVO = new UserInfoVO();
                BeanUtils.copyProperties(p, userInfoVO);
                userInfoVO.setRegTime(p.getRegTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
                userInfoVO.setRelativeState(p.getRelativeState() != null ? p.getRelativeState() ? "已关联" : "未关联" : "未关联");
                userInfoVOList.add(userInfoVO);
            });
            pageData.setData(userInfoVOList);
            message.setData(pageData);
        } catch (Exception ex) {
            message.setSuccess(false);
            message.setMessage(ex.getMessage());
            logger.error(ex.toString());
        }
        return message;
    }
   //endregion

    //region 获取有订单的学生列表
    /**
     * 获取学生的订单
     *
     * @param studentGuid
     * @return
     */
    public MessageResult<List<StudentOrderVO>> getOrderByStudentGuid(String studentGuid) {
        MessageResult<List<StudentOrderVO>> message = new MessageResult<>();
        try {
            List<StudentOrderDto> studentOrderDtoList = userInfoMapper.getOrderByStudentGuid(studentGuid);
            List<StudentOrderVO> studentOrderVOList = new ArrayList<>();
            studentOrderDtoList.forEach(p ->
            {
                StudentOrderVO studentOrderVO = new StudentOrderVO();
                BeanUtils.copyProperties(p, studentOrderVO);
                studentOrderVO.setAddedTime(p.getAddedTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
                studentOrderVO.setCourseStartTime(p.getCourseStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
                studentOrderVO.setCourseEndTime(p.getCourseEndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
                studentOrderVO.setRelativeState(p.getRelativeState() != null ? p.getRelativeState() ? "已关联" : "未关联" : "未关联");
                studentOrderVOList.add(studentOrderVO);
            });
            message.setSuccess(true);
            message.setData(studentOrderVOList);
        } catch (Exception ex) {
            message.setSuccess(false);
            message.setMessage(ex.getMessage());
            logger.error(ex.toString());
        }
        return message;
    }
    //endregion
}