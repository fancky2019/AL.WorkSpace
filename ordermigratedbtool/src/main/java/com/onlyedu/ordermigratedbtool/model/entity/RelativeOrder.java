package com.onlyedu.ordermigratedbtool.model.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RelativeOrder {
    private Integer id;

    private Integer orderHeadId;

    private Integer orderProductId;

    private Integer eosOrderId;

    private Integer eosOrderProductId;

    private BigDecimal eosRemainBalance;

    private LocalDateTime createTime;

    private Boolean isDelete;
}