package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.OrderHeadMapper;
import com.onlyedu.ordermigratedbtool.model.dto.StudentOrderDto;
import com.onlyedu.ordermigratedbtool.model.entity.OrderHead;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.vo.StudentOrderVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderHeadService {

    private final static Logger logger = LogManager.getLogger(OrderHeadService.class);
    @Autowired
    private OrderHeadMapper orderHeadMapper;

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
            List<StudentOrderDto> studentOrderDtoList = orderHeadMapper.getOrderByStudentGuid(studentGuid);
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
            message.setCode(0);
            message.setData(studentOrderVOList);
        } catch (Exception ex) {
            message.setCode(500);
            message.setMessage(ex.getMessage());
            logger.error(ex.toString());
        }
        return message;
    }
    //endregion

    //region 更新关联装填
    public MessageResult<Integer> updateRelative(OrderHead orderHead) {
        MessageResult<Integer> messageResult = new MessageResult<>();
        try {
            Integer result = orderHeadMapper.updateRelative(orderHead);
            messageResult.setCode( 0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }
    //endregion
}
