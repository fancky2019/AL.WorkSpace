package com.onlyedu.ordermigratedbtool.model.dto;

import lombok.Data;

@Data
public class UserInfoEosStudentRelativeDto {
    private Integer userInfoId;
    private Integer eosStudentId;
    private String phone;
    private String userInfoName;
    private String eosStudentName;
}
