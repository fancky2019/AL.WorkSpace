package com.onlyedu.ordermigratedbtool.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlyedu.ordermigratedbtool.model.dto.EosStudentDto;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.service.api.FeignClientTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    FeignClientTest feignClientTest;

    @GetMapping("/getUser")
    public String getUser(String name) throws JsonProcessingException {

        MessageResult<Void> result = new MessageResult<>();
        result.setCode(0);
        result.setMessage(name);
        String jsonStr = objectMapper.writeValueAsString(result);
        return jsonStr;
    }

     @PostMapping("/addUser")
     public  String addUser(@RequestBody UserInfo userInfo) throws JsonProcessingException {
        MessageResult<Void> result = new MessageResult<>();
        result.setCode(0);
        result.setMessage(objectMapper.writeValueAsString(userInfo));
        String jsonStr = objectMapper.writeValueAsString(result);
        return jsonStr;
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(String name) throws JsonProcessingException {

        String jsonStr = feignClientTest.getUserInfo(name);
        return jsonStr;
    }

}
