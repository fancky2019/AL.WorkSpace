package com.onlyedu.ordermigratedbtool.controller;

import com.onlyedu.ordermigratedbtool.model.dto.*;
import com.onlyedu.ordermigratedbtool.model.entity.OrderHead;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.StudentOrderVO;
import com.onlyedu.ordermigratedbtool.model.vo.UserInfoVO;
import com.onlyedu.ordermigratedbtool.service.OrderHeadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {
    private final static Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrderHeadService orderHeadService;


    @GetMapping("/getOrderByStudentGuidPage")
    public MessageResult<PageData<StudentOrderVO>> getOrderByStudentGuidPage(StudentOrderDto studentOrderDto) {
        MessageResult<PageData<StudentOrderVO>> message = orderHeadService.getOrderByStudentGuidPage(studentOrderDto);
        return message;
    }

    @GetMapping("/getStudentOrderStatistics")
    public MessageResult<UserInfoStatisticsDto> getStudentOrderStatistics(StudentOrderDto studentOrderDto) {
        MessageResult<UserInfoStatisticsDto> messageResult = new MessageResult<>();
        try {
            studentOrderDto.setPageSize(Integer.MAX_VALUE);
            studentOrderDto.setPageIndex(1);
            return orderHeadService.getStudentOrderStatistics(studentOrderDto);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

    @PostMapping("/updateRelative")
    public MessageResult<Void> updateRelative(@RequestBody RelativeOrderHeadEosOrderDto relativeOrderHeadEosOrderDto) {

        if (relativeOrderHeadEosOrderDto.getOrderHeads().size() > 1 && relativeOrderHeadEosOrderDto.getEosOrderIds().size() > 1) {
            return returnError("订单不存在多对多关联关系!",200);
        }
        if(relativeOrderHeadEosOrderDto.getOrderHeads().size() ==0|| relativeOrderHeadEosOrderDto.getEosOrderIds().size() ==0)
        {
            return returnError("存在空参数!",200);
        }
        return orderHeadService.updateRelative(relativeOrderHeadEosOrderDto);
    }

    private  MessageResult<Void> returnError(String errMessage,Integer code)
    {
        MessageResult<Void> result = new MessageResult<>();
        result.setCode(code);
        result.setMessage(errMessage);
        return result;
    }

    @PostMapping("/unRelative")
    public MessageResult<Void> unRelative(@RequestBody OrderHeaderEosOrderUnRelativeDto dto) {
        return orderHeadService.unRelative(dto);
    }


//    @PostMapping("/updateRelative")
//    public MessageResult<Integer> updateRelative(@RequestParam Integer id,
//                                                 @RequestParam String eOSOrder,
//                                                 @RequestParam BigDecimal eOSBalance,
//                                                 @RequestParam Boolean relativeState) {
//        OrderHead orderHead = new OrderHead();
//        orderHead.setId(id);
//        orderHead.setEosOrderID(eOSOrder);
//        orderHead.setEosRemainBalance(eOSBalance);
//        orderHead.setRelativeState(relativeState);
//        return orderHeadService.updateRelative(orderHead);
//    }
}
