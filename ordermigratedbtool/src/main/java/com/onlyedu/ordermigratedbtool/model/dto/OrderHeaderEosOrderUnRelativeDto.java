package com.onlyedu.ordermigratedbtool.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderHeaderEosOrderUnRelativeDto {
    /**
     * 0:OrderHead解除关联，1：EosOrder解除关联
     */
    private short unRelativeType;
    /**
     * OrderHead或EosOrder的id
     */
    private Integer id;

    private Integer productId;

}
