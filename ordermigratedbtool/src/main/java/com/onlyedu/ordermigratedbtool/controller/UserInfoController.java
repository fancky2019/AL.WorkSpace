package com.onlyedu.ordermigratedbtool.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoDto;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.UserInfoVO;
import com.onlyedu.ordermigratedbtool.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    private final static Logger logger = LogManager.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    ObjectMapper mapper;

    @GetMapping("/getUserWithOrderPage")
    public MessageResult<PageData<UserInfoVO>> getUserWithOrderPage(UserInfoDto userInfoDto) {
        MessageResult<PageData<UserInfoVO>> message = userInfoService.getUserWithOrderPage(userInfoDto);
        return message;
    }

    @PostMapping("/updateRelative")
    public MessageResult<Integer> updateRelative(@RequestBody UserInfo userInfo) {
        MessageResult<Integer> messageResult = userInfoService.updateRelative(userInfo);
        return messageResult;
    }

    @PostMapping("/postTest")
    public MessageResult<Integer> postTest(@RequestParam Integer id,
                                           @RequestParam String EOSOrder,
                                           @RequestParam BigDecimal EOSBalance,
                                           @RequestParam Boolean relativeState) {
        UserInfo userInfo = new UserInfo();
        MessageResult<Integer> messageResult = userInfoService.updateRelative(userInfo);
        return messageResult;
    }

    @PostMapping("/subbmit")
    public void subbmit(String name) {
        ObjectMapper mapper = new ObjectMapper();
    }

    @GetMapping("/getJackSon")
    public String getJackSon() {
        String jsonStr = "";
        try {

            UserInfoDto userInfo = new UserInfoDto();
            userInfo.setRegTime(LocalDateTime.now());
            userInfo.setRelativeState(true);
            userInfo.setUserId("fancky");
            //序列化
            jsonStr = mapper.writeValueAsString(userInfo);
            //反序列化
            UserInfoDto pojo = mapper.readValue(jsonStr, UserInfoDto.class);
            int m = 0;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
