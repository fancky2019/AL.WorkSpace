package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class UserRemarks {
    private Integer id;

    private String studentId;

    private LocalDateTime nextRemarksTime;

    private String userIntentionId;

    private Integer BMlevel;

    private Integer remarkType;

    private String recordId;

    private Boolean isNoticeCustomDirector;

    private String addBy;

    private LocalDateTime addedTime;

    private Boolean isDelete;

    private String deleteBy;

    private LocalDateTime deleteTime;

    private Boolean isModify;

    private String modifyBy;

    private LocalDateTime modifyTime;

    private Integer action;

    private String warinType;

    private Integer advise;

    private LocalDateTime actionTime;

    private Integer remarksType;

    private String remarks;

    public UserRemarks(Integer id, String studentId, LocalDateTime nextRemarksTime, String userIntentionId, Integer BMlevel, Integer remarkType, String recordId, Boolean isNoticeCustomDirector, String addBy, LocalDateTime addedTime, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, Boolean isModify, String modifyBy, LocalDateTime modifyTime, Integer action, String warinType, Integer advise, LocalDateTime actionTime, Integer remarksType) {
        this.id = id;
        this.studentId = studentId;
        this.nextRemarksTime = nextRemarksTime;
        this.userIntentionId = userIntentionId;
        this.BMlevel = BMlevel;
        this.remarkType = remarkType;
        this.recordId = recordId;
        this.isNoticeCustomDirector = isNoticeCustomDirector;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.isModify = isModify;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
        this.action = action;
        this.warinType = warinType;
        this.advise = advise;
        this.actionTime = actionTime;
        this.remarksType = remarksType;
    }

    public UserRemarks(Integer id, String studentId, LocalDateTime nextRemarksTime, String userIntentionId, Integer BMlevel, Integer remarkType, String recordId, Boolean isNoticeCustomDirector, String addBy, LocalDateTime addedTime, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, Boolean isModify, String modifyBy, LocalDateTime modifyTime, Integer action, String warinType, Integer advise, LocalDateTime actionTime, Integer remarksType, String remarks) {
        this.id = id;
        this.studentId = studentId;
        this.nextRemarksTime = nextRemarksTime;
        this.userIntentionId = userIntentionId;
        this.BMlevel = BMlevel;
        this.remarkType = remarkType;
        this.recordId = recordId;
        this.isNoticeCustomDirector = isNoticeCustomDirector;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.isModify = isModify;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
        this.action = action;
        this.warinType = warinType;
        this.advise = advise;
        this.actionTime = actionTime;
        this.remarksType = remarksType;
        this.remarks = remarks;
    }

    public UserRemarks() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public LocalDateTime getNextRemarksTime() {
        return nextRemarksTime;
    }

    public void setNextRemarksTime(LocalDateTime nextRemarksTime) {
        this.nextRemarksTime = nextRemarksTime;
    }

    public String getUserIntentionId() {
        return userIntentionId;
    }

    public void setUserIntentionId(String userIntentionId) {
        this.userIntentionId = userIntentionId == null ? null : userIntentionId.trim();
    }

    public Integer getBMlevel() {
        return BMlevel;
    }

    public void setBMlevel(Integer BMlevel) {
        this.BMlevel = BMlevel;
    }

    public Integer getRemarkType() {
        return remarkType;
    }

    public void setRemarkType(Integer remarkType) {
        this.remarkType = remarkType;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public Boolean getIsNoticeCustomDirector() {
        return isNoticeCustomDirector;
    }

    public void setIsNoticeCustomDirector(Boolean isNoticeCustomDirector) {
        this.isNoticeCustomDirector = isNoticeCustomDirector;
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

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getWarinType() {
        return warinType;
    }

    public void setWarinType(String warinType) {
        this.warinType = warinType == null ? null : warinType.trim();
    }

    public Integer getAdvise() {
        return advise;
    }

    public void setAdvise(Integer advise) {
        this.advise = advise;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }

    public Integer getRemarksType() {
        return remarksType;
    }

    public void setRemarksType(Integer remarksType) {
        this.remarksType = remarksType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}