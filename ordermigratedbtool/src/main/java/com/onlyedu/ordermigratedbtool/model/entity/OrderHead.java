package com.onlyedu.ordermigratedbtool.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    private BigDecimal eOSBalance;

    private Boolean relativeState;

    private String eOSOrder;

    public OrderHead(Integer id, String orderNo, String userOrderNo, String bankNo, String receiptNo, String invoiceNo, String contractNo, String draftNo, String registrationNo, Integer orderType, String studentId, Integer orderStateId, String forRemarks, String errorStateRemarks, String backRemarks, String remark, BigDecimal returnPay, Short activeId, Short continued, Short continuous, LocalDateTime backPayTime, LocalDateTime approvedTime, String turnReceiptNo, String huanReceiptNo, String tempReceiptNo, String shareUserId, String shareUserId2, Short percents, String addBy, LocalDateTime addedTime, Boolean isMend, String creator, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, Boolean isModify, String modifyBy, LocalDateTime modifyTime, Integer isChange, String zeroReason, Integer isExpired, LocalDateTime changeTime, LocalDateTime returnTime, LocalDateTime BJtime, String returnReason, LocalDateTime expiredTime, BigDecimal eOSBalance, Boolean relativeState) {
        this.id = id;
        this.orderNo = orderNo;
        this.userOrderNo = userOrderNo;
        this.bankNo = bankNo;
        this.receiptNo = receiptNo;
        this.invoiceNo = invoiceNo;
        this.contractNo = contractNo;
        this.draftNo = draftNo;
        this.registrationNo = registrationNo;
        this.orderType = orderType;
        this.studentId = studentId;
        this.orderStateId = orderStateId;
        this.forRemarks = forRemarks;
        this.errorStateRemarks = errorStateRemarks;
        this.backRemarks = backRemarks;
        this.remark = remark;
        this.returnPay = returnPay;
        this.activeId = activeId;
        this.continued = continued;
        this.continuous = continuous;
        this.backPayTime = backPayTime;
        this.approvedTime = approvedTime;
        this.turnReceiptNo = turnReceiptNo;
        this.huanReceiptNo = huanReceiptNo;
        this.tempReceiptNo = tempReceiptNo;
        this.shareUserId = shareUserId;
        this.shareUserId2 = shareUserId2;
        this.percents = percents;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isMend = isMend;
        this.creator = creator;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.isModify = isModify;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
        this.isChange = isChange;
        this.zeroReason = zeroReason;
        this.isExpired = isExpired;
        this.changeTime = changeTime;
        this.returnTime = returnTime;
        this.BJtime = BJtime;
        this.returnReason = returnReason;
        this.expiredTime = expiredTime;
        this.eOSBalance = eOSBalance;
        this.relativeState = relativeState;
    }

    public OrderHead(Integer id, String orderNo, String userOrderNo, String bankNo, String receiptNo, String invoiceNo, String contractNo, String draftNo, String registrationNo, Integer orderType, String studentId, Integer orderStateId, String forRemarks, String errorStateRemarks, String backRemarks, String remark, BigDecimal returnPay, Short activeId, Short continued, Short continuous, LocalDateTime backPayTime, LocalDateTime approvedTime, String turnReceiptNo, String huanReceiptNo, String tempReceiptNo, String shareUserId, String shareUserId2, Short percents, String addBy, LocalDateTime addedTime, Boolean isMend, String creator, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, Boolean isModify, String modifyBy, LocalDateTime modifyTime, Integer isChange, String zeroReason, Integer isExpired, LocalDateTime changeTime, LocalDateTime returnTime, LocalDateTime BJtime, String returnReason, LocalDateTime expiredTime, BigDecimal eOSBalance, Boolean relativeState, String eOSOrder) {
        this.id = id;
        this.orderNo = orderNo;
        this.userOrderNo = userOrderNo;
        this.bankNo = bankNo;
        this.receiptNo = receiptNo;
        this.invoiceNo = invoiceNo;
        this.contractNo = contractNo;
        this.draftNo = draftNo;
        this.registrationNo = registrationNo;
        this.orderType = orderType;
        this.studentId = studentId;
        this.orderStateId = orderStateId;
        this.forRemarks = forRemarks;
        this.errorStateRemarks = errorStateRemarks;
        this.backRemarks = backRemarks;
        this.remark = remark;
        this.returnPay = returnPay;
        this.activeId = activeId;
        this.continued = continued;
        this.continuous = continuous;
        this.backPayTime = backPayTime;
        this.approvedTime = approvedTime;
        this.turnReceiptNo = turnReceiptNo;
        this.huanReceiptNo = huanReceiptNo;
        this.tempReceiptNo = tempReceiptNo;
        this.shareUserId = shareUserId;
        this.shareUserId2 = shareUserId2;
        this.percents = percents;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isMend = isMend;
        this.creator = creator;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.isModify = isModify;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
        this.isChange = isChange;
        this.zeroReason = zeroReason;
        this.isExpired = isExpired;
        this.changeTime = changeTime;
        this.returnTime = returnTime;
        this.BJtime = BJtime;
        this.returnReason = returnReason;
        this.expiredTime = expiredTime;
        this.eOSBalance = eOSBalance;
        this.relativeState = relativeState;
        this.eOSOrder = eOSOrder;
    }

    public OrderHead() {
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

    public String getUserOrderNo() {
        return userOrderNo;
    }

    public void setUserOrderNo(String userOrderNo) {
        this.userOrderNo = userOrderNo == null ? null : userOrderNo.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo == null ? null : receiptNo.trim();
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getDraftNo() {
        return draftNo;
    }

    public void setDraftNo(String draftNo) {
        this.draftNo = draftNo == null ? null : draftNo.trim();
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo == null ? null : registrationNo.trim();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public Integer getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(Integer orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getForRemarks() {
        return forRemarks;
    }

    public void setForRemarks(String forRemarks) {
        this.forRemarks = forRemarks == null ? null : forRemarks.trim();
    }

    public String getErrorStateRemarks() {
        return errorStateRemarks;
    }

    public void setErrorStateRemarks(String errorStateRemarks) {
        this.errorStateRemarks = errorStateRemarks == null ? null : errorStateRemarks.trim();
    }

    public String getBackRemarks() {
        return backRemarks;
    }

    public void setBackRemarks(String backRemarks) {
        this.backRemarks = backRemarks == null ? null : backRemarks.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getReturnPay() {
        return returnPay;
    }

    public void setReturnPay(BigDecimal returnPay) {
        this.returnPay = returnPay;
    }

    public Short getActiveId() {
        return activeId;
    }

    public void setActiveId(Short activeId) {
        this.activeId = activeId;
    }

    public Short getContinued() {
        return continued;
    }

    public void setContinued(Short continued) {
        this.continued = continued;
    }

    public Short getContinuous() {
        return continuous;
    }

    public void setContinuous(Short continuous) {
        this.continuous = continuous;
    }

    public LocalDateTime getBackPayTime() {
        return backPayTime;
    }

    public void setBackPayTime(LocalDateTime backPayTime) {
        this.backPayTime = backPayTime;
    }

    public LocalDateTime getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(LocalDateTime approvedTime) {
        this.approvedTime = approvedTime;
    }

    public String getTurnReceiptNo() {
        return turnReceiptNo;
    }

    public void setTurnReceiptNo(String turnReceiptNo) {
        this.turnReceiptNo = turnReceiptNo == null ? null : turnReceiptNo.trim();
    }

    public String getHuanReceiptNo() {
        return huanReceiptNo;
    }

    public void setHuanReceiptNo(String huanReceiptNo) {
        this.huanReceiptNo = huanReceiptNo == null ? null : huanReceiptNo.trim();
    }

    public String getTempReceiptNo() {
        return tempReceiptNo;
    }

    public void setTempReceiptNo(String tempReceiptNo) {
        this.tempReceiptNo = tempReceiptNo == null ? null : tempReceiptNo.trim();
    }

    public String getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(String shareUserId) {
        this.shareUserId = shareUserId == null ? null : shareUserId.trim();
    }

    public String getShareUserId2() {
        return shareUserId2;
    }

    public void setShareUserId2(String shareUserId2) {
        this.shareUserId2 = shareUserId2 == null ? null : shareUserId2.trim();
    }

    public Short getPercents() {
        return percents;
    }

    public void setPercents(Short percents) {
        this.percents = percents;
    }

    public String getAddBy() {
        return addBy;
    }

    public void setAddBy(String addBy) {
        this.addBy = addBy == null ? null : addBy.trim();
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
    }

    public Boolean getIsMend() {
        return isMend;
    }

    public void setIsMend(Boolean isMend) {
        this.isMend = isMend;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy == null ? null : deleteBy.trim();
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Boolean getIsModify() {
        return isModify;
    }

    public void setIsModify(Boolean isModify) {
        this.isModify = isModify;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsChange() {
        return isChange;
    }

    public void setIsChange(Integer isChange) {
        this.isChange = isChange;
    }

    public String getZeroReason() {
        return zeroReason;
    }

    public void setZeroReason(String zeroReason) {
        this.zeroReason = zeroReason == null ? null : zeroReason.trim();
    }

    public Integer getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Integer isExpired) {
        this.isExpired = isExpired;
    }

    public LocalDateTime getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(LocalDateTime changeTime) {
        this.changeTime = changeTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    public LocalDateTime getBJtime() {
        return BJtime;
    }

    public void setBJtime(LocalDateTime BJtime) {
        this.BJtime = BJtime;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason == null ? null : returnReason.trim();
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }

    public BigDecimal geteOSBalance() {
        return eOSBalance;
    }

    public void seteOSBalance(BigDecimal eOSBalance) {
        this.eOSBalance = eOSBalance;
    }

    public Boolean getRelativeState() {
        return relativeState;
    }

    public void setRelativeState(Boolean relativeState) {
        this.relativeState = relativeState;
    }

    public String geteOSOrder() {
        return eOSOrder;
    }

    public void seteOSOrder(String eOSOrder) {
        this.eOSOrder = eOSOrder == null ? null : eOSOrder.trim();
    }
}