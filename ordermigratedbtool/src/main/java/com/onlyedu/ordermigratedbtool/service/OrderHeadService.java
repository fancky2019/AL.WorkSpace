package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.OrderHeadMapper;
import com.onlyedu.ordermigratedbtool.model.dto.StudentOrderDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoStatisticsDto;
import com.onlyedu.ordermigratedbtool.model.entity.OrderHead;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.StudentOrderVO;
import com.onlyedu.ordermigratedbtool.model.vo.UserInfoVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderHeadService {

    private final static Logger logger = LogManager.getLogger(OrderHeadService.class);
    @Autowired
    private OrderHeadMapper orderHeadMapper;

    //region 获取有订单的学生列表

    public MessageResult<PageData<StudentOrderVO>> getOrderByStudentGuidPage(StudentOrderDto studentOrderDto) {
        MessageResult<PageData<StudentOrderVO>> message = new MessageResult<>();
        try {
            Integer count = orderHeadMapper.getOrderByStudentGuidCount(studentOrderDto);
            PageData<StudentOrderVO> pageData = new PageData<>();
            pageData.setCount(count);

            List<StudentOrderDto> studentOrderDtoList = orderHeadMapper.getOrderByStudentGuid(studentOrderDto);
            List<StudentOrderVO> studentOrderVOList = new ArrayList<>();
            studentOrderDtoList.forEach(p ->
            {
                StudentOrderVO studentOrderVO = new StudentOrderVO();
                BeanUtils.copyProperties(p, studentOrderVO);
                studentOrderVOList.add(studentOrderVO);
            });
            pageData.setRows(studentOrderVOList);
            message.setCode(0);
            message.setData(pageData);
        } catch (Exception ex) {
            message.setCode(500);
            message.setMessage(ex.getMessage());
            logger.error(ex.toString());
        }
        return message;
    }
    //endregion

    public MessageResult<UserInfoStatisticsDto> getStudentOrderStatistics(StudentOrderDto studentOrderDto) {
        MessageResult<UserInfoStatisticsDto> messageResult = new MessageResult<>();
        try {
            UserInfoStatisticsDto userInfoStatisticsDto = new UserInfoStatisticsDto();
            List<StudentOrderDto> studentOrderDtoList = orderHeadMapper.getOrderByStudentGuid(studentOrderDto);
            Integer totalCount = studentOrderDtoList.size();
            Integer relativeStateCount = studentOrderDtoList.stream().filter(p -> p.getRelativeState()).collect(Collectors.toList()).size();
            Integer unRelativeStateCount = totalCount - relativeStateCount;
            userInfoStatisticsDto.setTotalCount(totalCount);
            userInfoStatisticsDto.setRelativeStateCount(relativeStateCount);
            userInfoStatisticsDto.setUnRelativeStateCount(unRelativeStateCount);

            messageResult.setData(userInfoStatisticsDto);
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }


    //region 更新关联装填
    public MessageResult<Integer> updateRelative(OrderHead orderHead) {
        MessageResult<Integer> messageResult = new MessageResult<>();
        try {
            Integer result = orderHeadMapper.updateRelative(orderHead);
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }
    //endregion
}
