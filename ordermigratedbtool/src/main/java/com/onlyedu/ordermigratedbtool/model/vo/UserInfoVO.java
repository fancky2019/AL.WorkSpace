package com.onlyedu.ordermigratedbtool.model.vo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserInfoVO {
    private Integer id;
    private String userId;
    private String studentId;
    private String studentNo;
    private String userName;
    private String grade;
    private String mobilePhone ;
    private String tel;
    private String school;
    private String regTime;
    private Boolean relativeState;
    private String relativeStateStr;
    private Integer eosStudentID;
}
