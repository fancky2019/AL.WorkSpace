package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class CallInRecord {
    private Integer ID;

    private String studentId;

    private LocalDateTime comeTime;

    private String channelType;

    private String otherChannel;

    private Integer intentionType;

    private String otherIntention;

    private Integer vaildType;

    private String addBy;

    private LocalDateTime addTime;

    private String updateBy;

    private LocalDateTime updateTime;

    private Integer updateCount;

    public CallInRecord(Integer ID, String studentId, LocalDateTime comeTime, String channelType, String otherChannel, Integer intentionType, String otherIntention, Integer vaildType, String addBy, LocalDateTime addTime, String updateBy, LocalDateTime updateTime, Integer updateCount) {
        this.ID = ID;
        this.studentId = studentId;
        this.comeTime = comeTime;
        this.channelType = channelType;
        this.otherChannel = otherChannel;
        this.intentionType = intentionType;
        this.otherIntention = otherIntention;
        this.vaildType = vaildType;
        this.addBy = addBy;
        this.addTime = addTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.updateCount = updateCount;
    }

    public CallInRecord() {
        super();
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public LocalDateTime getComeTime() {
        return comeTime;
    }

    public void setComeTime(LocalDateTime comeTime) {
        this.comeTime = comeTime;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType == null ? null : channelType.trim();
    }

    public String getOtherChannel() {
        return otherChannel;
    }

    public void setOtherChannel(String otherChannel) {
        this.otherChannel = otherChannel == null ? null : otherChannel.trim();
    }

    public Integer getIntentionType() {
        return intentionType;
    }

    public void setIntentionType(Integer intentionType) {
        this.intentionType = intentionType;
    }

    public String getOtherIntention() {
        return otherIntention;
    }

    public void setOtherIntention(String otherIntention) {
        this.otherIntention = otherIntention == null ? null : otherIntention.trim();
    }

    public Integer getVaildType() {
        return vaildType;
    }

    public void setVaildType(Integer vaildType) {
        this.vaildType = vaildType;
    }

    public String getAddBy() {
        return addBy;
    }

    public void setAddBy(String addBy) {
        this.addBy = addBy == null ? null : addBy.trim();
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }
}