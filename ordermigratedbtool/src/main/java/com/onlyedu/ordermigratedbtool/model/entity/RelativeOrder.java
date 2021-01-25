package com.onlyedu.ordermigratedbtool.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelativeOrder {
    private Integer id;

    private Integer orderHeadId;

    private Integer eosOrderId;

    private BigDecimal eosRemainBalance;

    private LocalDateTime createTime;

    private Boolean isDelete;

    public RelativeOrder(Integer id, Integer orderHeadId, Integer eosOrderId, BigDecimal eosRemainBalance, LocalDateTime createTime, Boolean isDelete) {
        this.id = id;
        this.orderHeadId = orderHeadId;
        this.eosOrderId = eosOrderId;
        this.eosRemainBalance = eosRemainBalance;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public RelativeOrder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderHeadId() {
        return orderHeadId;
    }

    public void setOrderHeadId(Integer orderHeadId) {
        this.orderHeadId = orderHeadId;
    }

    public Integer getEosOrderId() {
        return eosOrderId;
    }

    public void setEosOrderId(Integer eosOrderId) {
        this.eosOrderId = eosOrderId;
    }

    public BigDecimal getEosRemainBalance() {
        return eosRemainBalance;
    }

    public void setEosRemainBalance(BigDecimal eosRemainBalance) {
        this.eosRemainBalance = eosRemainBalance;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}