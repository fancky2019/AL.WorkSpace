package com.onlyedu.ordermigratedbtool.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EosOrder {
    private Integer id;

    private String orderNo;

    private String eosStudentID;

    private String feeContent;

    private LocalDateTime orderTime;

    private String courseProductName;

    private BigDecimal orderBalance;

    private BigDecimal remainRemaining;

    private Boolean relativeState;

    private Integer orderHeadID;

    public EosOrder(Integer id, String orderNo, String eosStudentID, String feeContent, LocalDateTime orderTime, String courseProductName, BigDecimal orderBalance, BigDecimal remainRemaining, Boolean relativeState, Integer orderHeadID) {
        this.id = id;
        this.orderNo = orderNo;
        this.eosStudentID = eosStudentID;
        this.feeContent = feeContent;
        this.orderTime = orderTime;
        this.courseProductName = courseProductName;
        this.orderBalance = orderBalance;
        this.remainRemaining = remainRemaining;
        this.relativeState = relativeState;
        this.orderHeadID = orderHeadID;
    }

    public EosOrder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getEosStudentID() {
        return eosStudentID;
    }

    public void setEosStudentID(String eosStudentID) {
        this.eosStudentID = eosStudentID == null ? null : eosStudentID.trim();
    }

    public String getFeeContent() {
        return feeContent;
    }

    public void setFeeContent(String feeContent) {
        this.feeContent = feeContent == null ? null : feeContent.trim();
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getCourseProductName() {
        return courseProductName;
    }

    public void setCourseProductName(String courseProductName) {
        this.courseProductName = courseProductName == null ? null : courseProductName.trim();
    }

    public BigDecimal getOrderBalance() {
        return orderBalance;
    }

    public void setOrderBalance(BigDecimal orderBalance) {
        this.orderBalance = orderBalance;
    }

    public BigDecimal getRemainRemaining() {
        return remainRemaining;
    }

    public void setRemainRemaining(BigDecimal remainRemaining) {
        this.remainRemaining = remainRemaining;
    }

    public Boolean getRelativeState() {
        return relativeState;
    }

    public void setRelativeState(Boolean relativeState) {
        this.relativeState = relativeState;
    }

    public Integer getOrderHeadID() {
        return orderHeadID;
    }

    public void setOrderHeadID(Integer orderHeadID) {
        this.orderHeadID = orderHeadID;
    }
}