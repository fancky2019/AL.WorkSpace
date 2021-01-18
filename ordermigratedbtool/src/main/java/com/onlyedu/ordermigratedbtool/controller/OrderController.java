package com.onlyedu.ordermigratedbtool.controller;

import com.onlyedu.ordermigratedbtool.model.entity.OrderHead;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.vo.StudentOrderVO;
import com.onlyedu.ordermigratedbtool.service.OrderHeadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {
    private final static Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrderHeadService orderHeadService;

    @GetMapping("/getOrderByStudentGuid")
    public MessageResult<List<StudentOrderVO>> getOrderByStudentGuid(String studentGuid) {
        MessageResult<List<StudentOrderVO>> message = orderHeadService.getOrderByStudentGuid(studentGuid);
        return message;
    }

    @PostMapping("/updateRelative")
    public MessageResult<Integer> updateRelative(@RequestBody OrderHead orderHead) {
        return orderHeadService.updateRelative(orderHead);
    }
}
