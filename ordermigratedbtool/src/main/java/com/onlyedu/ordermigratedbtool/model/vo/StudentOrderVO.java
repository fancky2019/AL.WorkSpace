package com.onlyedu.ordermigratedbtool.model.vo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class StudentOrderVO {
    private String userId;
    private String studentNo;
    private String studentGuid;
    private String userName;
    private String grade;
    private String mobilePhone;
    private String tel;
    private String school;
    private String orderNo;
    private String courseWareName;
    private String productName;
    private String addedTime;
    private String courseStartTime;
    private String courseEndTime;
    private String orderType;
    private String payType;
    private String shareUserId;
    private String payMoney;
    private String relativeState;
    private String eosOrderID;
    private String eosRemainBalance;

}
