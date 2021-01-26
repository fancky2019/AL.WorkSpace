package com.onlyedu.ordermigratedbtool.model.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RelativeStudent {
    private Integer id;

    private Integer userInfoId;

    private Integer eosStudentId;

    private LocalDateTime createTime;

    private Boolean isDelete;

}