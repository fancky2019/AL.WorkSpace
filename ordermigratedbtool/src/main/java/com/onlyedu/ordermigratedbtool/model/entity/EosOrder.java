package com.onlyedu.ordermigratedbtool.model.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class EosOrder {
    private Integer id;

    private String orderNo;

    private Integer eosStudentID;

    private String feeContent;

    private LocalDateTime orderTime;

    private Integer courseProductID;

    private String courseProductName;

    /**
     * 订单金额
     */
    private BigDecimal orderBalance;

    /**
     * 剩余金额
     */
    private BigDecimal remainBalance;


    //ALT+INSERT
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//地址相等
        if (o == null || getClass() != o.getClass()) return false;
        EosOrder eosOrder = (EosOrder) o;
        return orderNo.equals(eosOrder.orderNo) && eosStudentID.equals(eosOrder.eosStudentID) && feeContent.equals(eosOrder.feeContent) && orderTime.equals(eosOrder.orderTime) && courseProductID.equals(eosOrder.courseProductID) && courseProductName.equals(eosOrder.courseProductName) && orderBalance.equals(eosOrder.orderBalance) && remainBalance.equals(eosOrder.remainBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo, eosStudentID, feeContent, orderTime, courseProductID, courseProductName, orderBalance, remainBalance);
    }
}