package com.onlyedu.ordermigratedbtool.model.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EosOrder {
    private Integer id;

    private String orderNo;

    private Integer eosStudentID;

    private String feeContent;

    private LocalDateTime orderTime;

    private String courseProductName;

    /**
     * 订单金额
     */
    private BigDecimal orderBalance;

    /**
     * 剩余金额
     */
    private BigDecimal remainBalance;

    private Boolean relativeState;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;//地址相等
        }

        if (obj == null) {
            return false;//非空性：对于任意非空引用x，x.equals(null)应该返回false。
        }

        if (obj instanceof EosOrder) {
            EosOrder other = (EosOrder) obj;
            if (other.getOrderNo().equals(this.getOrderNo()) &&
                    other.getEosStudentID().equals(this.getEosStudentID()) &&
                    other.getFeeContent().equals(this.getFeeContent()) &&
                    other.getOrderTime().equals(this.getOrderTime()) &&
                    other.getCourseProductName().equals(this.getCourseProductName()) &&
                    other.getOrderBalance().equals(this.getOrderBalance()) &&
                    other.getRemainBalance().equals(this.getRemainBalance())) {
                return true;
            }
        }

        return false;
    }
}