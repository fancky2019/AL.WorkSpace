package com.onlyedu.ordermigratedbtool.model.dto;

import com.onlyedu.ordermigratedbtool.model.pojo.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentOrderDto extends Page {
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
    private LocalDateTime addedTime;
    private LocalDateTime courseStartTime;
    private LocalDateTime courseEndTime;
    private String orderType;
    private String payType;
    private String shareUserId;
    private String payMoney;
    private Boolean relativeState;
    private String eOSOrder;
    private String eOSBalance;
}
