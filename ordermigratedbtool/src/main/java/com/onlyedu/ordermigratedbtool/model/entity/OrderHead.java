package com.onlyedu.ordermigratedbtool.model.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class OrderHead {
    private Integer id;

    private String orderNo;

    private String userOrderNo;

    private String bankNo;

    private String receiptNo;

    private String invoiceNo;

    private String contractNo;

    private String draftNo;

    private String registrationNo;

    private Integer orderType;

    private String studentId;

    private Integer orderStateId;

    private String forRemarks;

    private String errorStateRemarks;

    private String backRemarks;

    private String remark;

    private BigDecimal returnPay;

    private Short activeId;

    private Short continued;

    private Short continuous;

    private LocalDateTime backPayTime;

    private LocalDateTime approvedTime;

    private String turnReceiptNo;

    private String huanReceiptNo;

    private String tempReceiptNo;

    private String shareUserId;

    private String shareUserId2;

    private Short percents;

    private String addBy;

    private LocalDateTime addedTime;

    private Boolean isMend;

    private String creator;

    private Boolean isDelete;

    private String deleteBy;

    private LocalDateTime deleteTime;

    private Boolean isModify;

    private String modifyBy;

    private LocalDateTime modifyTime;

    private Integer isChange;

    private String zeroReason;

    private Integer isExpired;

    private LocalDateTime changeTime;

    private LocalDateTime returnTime;

    private LocalDateTime BJtime;

    private String returnReason;

    private LocalDateTime expiredTime;

    private BigDecimal eosRemainBalance;

    private String eosOrderID;

}