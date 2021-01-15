package com.onlyedu.ordermigratedbtool.controller;

import com.onlyedu.ordermigratedbtool.model.dto.UserInfoDto;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;

import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.UserInfoVO;
import com.onlyedu.ordermigratedbtool.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    private final static Logger logger = LogManager.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;


    @GetMapping("/getUserWithOrderPage")
    public MessageResult<PageData<UserInfoVO>> getUserWithOrderPage(UserInfoDto userInfoDto) {
        MessageResult<PageData<UserInfoVO>> message = userInfoService.getUserWithOrderPage(userInfoDto);
        Integer m = 0;
        return message;
    }


    @PostMapping("/subbmit")
    public void subbmit(String name) {

    }
}
