package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class UserIntention {
    private String guid;

    private Integer userIntentionId;

    private String userIntention;

    private Integer intentionType;

    private String addBy;

    private LocalDateTime addedTime;

    private Boolean isDelete;

    private String deleteBy;

    private LocalDateTime deleteTime;

    private String modifyBy;

    private LocalDateTime modifyTime;

    public UserIntention(String guid, Integer userIntentionId, String userIntention, Integer intentionType, String addBy, LocalDateTime addedTime, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, String modifyBy, LocalDateTime modifyTime) {
        this.guid = guid;
        this.userIntentionId = userIntentionId;
        this.userIntention = userIntention;
        this.intentionType = intentionType;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
    }

    public UserIntention() {
        super();
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public Integer getUserIntentionId() {
        return userIntentionId;
    }

    public void setUserIntentionId(Integer userIntentionId) {
        this.userIntentionId = userIntentionId;
    }

    public String getUserIntention() {
        return userIntention;
    }

    public void setUserIntention(String userIntention) {
        this.userIntention = userIntention == null ? null : userIntention.trim();
    }

    public Integer getIntentionType() {
        return intentionType;
    }

    public void setIntentionType(Integer intentionType) {
        this.intentionType = intentionType;
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
}