package com.onlyedu.ordermigratedbtool.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderHeaderEosOrderUnRelativeDto {
    /**
     * 0:UserInfo解除关联，1：EosStudent解除关联
     */
    private short unRelativeType;
    /**
     * UserInfo或EosStudent的id
     */
    private Integer id;
}
