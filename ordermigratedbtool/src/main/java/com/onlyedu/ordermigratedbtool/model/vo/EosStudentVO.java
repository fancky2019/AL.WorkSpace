package com.onlyedu.ordermigratedbtool.model.vo;

import lombok.Data;

@Data
public class EosStudentVO {
    private Integer id;

    private Integer eosStudentID;

    private String studentName;

    private String grade;

    private String phone;

    private String relativeStateStr;

    private Boolean relativeState;

    private String userInfoId;

    private String userInfoStudentIds;
}
