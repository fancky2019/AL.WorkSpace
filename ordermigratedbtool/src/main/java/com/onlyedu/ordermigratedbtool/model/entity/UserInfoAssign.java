package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class UserInfoAssign {
    private String studentId;

    private Integer id;

    private String ddlAdminCall;

    private LocalDateTime ddlCallTime;

    private String ddlAdmin;

    private LocalDateTime ddlAdminTime;

    private String ddlAdminInvite;

    private LocalDateTime ddlInviteTime;

    private String ddlAdminCenter;

    private LocalDateTime ddlCenterTime;

    private String userIntentionId;

    private String userInviteIntentionId;

    private String userCallIntentionId;

    private String userCenterIntentionId;

    private LocalDateTime lastRemarksTime;

    private String lastRemarks;

    private String lastRemarksAdminUserId;

    private LocalDateTime nextRemarks;

    private LocalDateTime lastInviteTime;

    private String lastInvite;

    private String lastInviteAdminUserId;

    private LocalDateTime nextInvite;

    private LocalDateTime lastCallTime;

    private String lastCall;

    private String lastCallAdminUserId;

    private LocalDateTime nextCall;

    private LocalDateTime lastCenterTime;

    private String lastCenter;

    private String lastCenterAdminUserId;

    private LocalDateTime nextCenter;

    private LocalDateTime lastreturntime;

    private String lastreturncontent;

    private String lastreturnAdminUserId;

    private LocalDateTime nextreturn;

    private LocalDateTime lastkktime;

    private LocalDateTime addedtime;

    private LocalDateTime actionTime;

    private Integer action;

    private String warinType;

    private String NAction;

    private String NWarinType;

    public UserInfoAssign(String studentId, Integer id, String ddlAdminCall, LocalDateTime ddlCallTime, String ddlAdmin, LocalDateTime ddlAdminTime, String ddlAdminInvite, LocalDateTime ddlInviteTime, String ddlAdminCenter, LocalDateTime ddlCenterTime, String userIntentionId, String userInviteIntentionId, String userCallIntentionId, String userCenterIntentionId, LocalDateTime lastRemarksTime, String lastRemarks, String lastRemarksAdminUserId, LocalDateTime nextRemarks, LocalDateTime lastInviteTime, String lastInvite, String lastInviteAdminUserId, LocalDateTime nextInvite, LocalDateTime lastCallTime, String lastCall, String lastCallAdminUserId, LocalDateTime nextCall, LocalDateTime lastCenterTime, String lastCenter, String lastCenterAdminUserId, LocalDateTime nextCenter, LocalDateTime lastreturntime, String lastreturncontent, String lastreturnAdminUserId, LocalDateTime nextreturn, LocalDateTime lastkktime, LocalDateTime addedtime, LocalDateTime actionTime, Integer action, String warinType, String NAction, String NWarinType) {
        this.studentId = studentId;
        this.id = id;
        this.ddlAdminCall = ddlAdminCall;
        this.ddlCallTime = ddlCallTime;
        this.ddlAdmin = ddlAdmin;
        this.ddlAdminTime = ddlAdminTime;
        this.ddlAdminInvite = ddlAdminInvite;
        this.ddlInviteTime = ddlInviteTime;
        this.ddlAdminCenter = ddlAdminCenter;
        this.ddlCenterTime = ddlCenterTime;
        this.userIntentionId = userIntentionId;
        this.userInviteIntentionId = userInviteIntentionId;
        this.userCallIntentionId = userCallIntentionId;
        this.userCenterIntentionId = userCenterIntentionId;
        this.lastRemarksTime = lastRemarksTime;
        this.lastRemarks = lastRemarks;
        this.lastRemarksAdminUserId = lastRemarksAdminUserId;
        this.nextRemarks = nextRemarks;
        this.lastInviteTime = lastInviteTime;
        this.lastInvite = lastInvite;
        this.lastInviteAdminUserId = lastInviteAdminUserId;
        this.nextInvite = nextInvite;
        this.lastCallTime = lastCallTime;
        this.lastCall = lastCall;
        this.lastCallAdminUserId = lastCallAdminUserId;
        this.nextCall = nextCall;
        this.lastCenterTime = lastCenterTime;
        this.lastCenter = lastCenter;
        this.lastCenterAdminUserId = lastCenterAdminUserId;
        this.nextCenter = nextCenter;
        this.lastreturntime = lastreturntime;
        this.lastreturncontent = lastreturncontent;
        this.lastreturnAdminUserId = lastreturnAdminUserId;
        this.nextreturn = nextreturn;
        this.lastkktime = lastkktime;
        this.addedtime = addedtime;
        this.actionTime = actionTime;
        this.action = action;
        this.warinType = warinType;
        this.NAction = NAction;
        this.NWarinType = NWarinType;
    }

    public UserInfoAssign() {
        super();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDdlAdminCall() {
        return ddlAdminCall;
    }

    public void setDdlAdminCall(String ddlAdminCall) {
        this.ddlAdminCall = ddlAdminCall == null ? null : ddlAdminCall.trim();
    }

    public LocalDateTime getDdlCallTime() {
        return ddlCallTime;
    }

    public void setDdlCallTime(LocalDateTime ddlCallTime) {
        this.ddlCallTime = ddlCallTime;
    }

    public String getDdlAdmin() {
        return ddlAdmin;
    }

    public void setDdlAdmin(String ddlAdmin) {
        this.ddlAdmin = ddlAdmin == null ? null : ddlAdmin.trim();
    }

    public LocalDateTime getDdlAdminTime() {
        return ddlAdminTime;
    }

    public void setDdlAdminTime(LocalDateTime ddlAdminTime) {
        this.ddlAdminTime = ddlAdminTime;
    }

    public String getDdlAdminInvite() {
        return ddlAdminInvite;
    }

    public void setDdlAdminInvite(String ddlAdminInvite) {
        this.ddlAdminInvite = ddlAdminInvite == null ? null : ddlAdminInvite.trim();
    }

    public LocalDateTime getDdlInviteTime() {
        return ddlInviteTime;
    }

    public void setDdlInviteTime(LocalDateTime ddlInviteTime) {
        this.ddlInviteTime = ddlInviteTime;
    }

    public String getDdlAdminCenter() {
        return ddlAdminCenter;
    }

    public void setDdlAdminCenter(String ddlAdminCenter) {
        this.ddlAdminCenter = ddlAdminCenter == null ? null : ddlAdminCenter.trim();
    }

    public LocalDateTime getDdlCenterTime() {
        return ddlCenterTime;
    }

    public void setDdlCenterTime(LocalDateTime ddlCenterTime) {
        this.ddlCenterTime = ddlCenterTime;
    }

    public String getUserIntentionId() {
        return userIntentionId;
    }

    public void setUserIntentionId(String userIntentionId) {
        this.userIntentionId = userIntentionId == null ? null : userIntentionId.trim();
    }

    public String getUserInviteIntentionId() {
        return userInviteIntentionId;
    }

    public void setUserInviteIntentionId(String userInviteIntentionId) {
        this.userInviteIntentionId = userInviteIntentionId == null ? null : userInviteIntentionId.trim();
    }

    public String getUserCallIntentionId() {
        return userCallIntentionId;
    }

    public void setUserCallIntentionId(String userCallIntentionId) {
        this.userCallIntentionId = userCallIntentionId == null ? null : userCallIntentionId.trim();
    }

    public String getUserCenterIntentionId() {
        return userCenterIntentionId;
    }

    public void setUserCenterIntentionId(String userCenterIntentionId) {
        this.userCenterIntentionId = userCenterIntentionId == null ? null : userCenterIntentionId.trim();
    }

    public LocalDateTime getLastRemarksTime() {
        return lastRemarksTime;
    }

    public void setLastRemarksTime(LocalDateTime lastRemarksTime) {
        this.lastRemarksTime = lastRemarksTime;
    }

    public String getLastRemarks() {
        return lastRemarks;
    }

    public void setLastRemarks(String lastRemarks) {
        this.lastRemarks = lastRemarks == null ? null : lastRemarks.trim();
    }

    public String getLastRemarksAdminUserId() {
        return lastRemarksAdminUserId;
    }

    public void setLastRemarksAdminUserId(String lastRemarksAdminUserId) {
        this.lastRemarksAdminUserId = lastRemarksAdminUserId == null ? null : lastRemarksAdminUserId.trim();
    }

    public LocalDateTime getNextRemarks() {
        return nextRemarks;
    }

    public void setNextRemarks(LocalDateTime nextRemarks) {
        this.nextRemarks = nextRemarks;
    }

    public LocalDateTime getLastInviteTime() {
        return lastInviteTime;
    }

    public void setLastInviteTime(LocalDateTime lastInviteTime) {
        this.lastInviteTime = lastInviteTime;
    }

    public String getLastInvite() {
        return lastInvite;
    }

    public void setLastInvite(String lastInvite) {
        this.lastInvite = lastInvite == null ? null : lastInvite.trim();
    }

    public String getLastInviteAdminUserId() {
        return lastInviteAdminUserId;
    }

    public void setLastInviteAdminUserId(String lastInviteAdminUserId) {
        this.lastInviteAdminUserId = lastInviteAdminUserId == null ? null : lastInviteAdminUserId.trim();
    }

    public LocalDateTime getNextInvite() {
        return nextInvite;
    }

    public void setNextInvite(LocalDateTime nextInvite) {
        this.nextInvite = nextInvite;
    }

    public LocalDateTime getLastCallTime() {
        return lastCallTime;
    }

    public void setLastCallTime(LocalDateTime lastCallTime) {
        this.lastCallTime = lastCallTime;
    }

    public String getLastCall() {
        return lastCall;
    }

    public void setLastCall(String lastCall) {
        this.lastCall = lastCall == null ? null : lastCall.trim();
    }

    public String getLastCallAdminUserId() {
        return lastCallAdminUserId;
    }

    public void setLastCallAdminUserId(String lastCallAdminUserId) {
        this.lastCallAdminUserId = lastCallAdminUserId == null ? null : lastCallAdminUserId.trim();
    }

    public LocalDateTime getNextCall() {
        return nextCall;
    }

    public void setNextCall(LocalDateTime nextCall) {
        this.nextCall = nextCall;
    }

    public LocalDateTime getLastCenterTime() {
        return lastCenterTime;
    }

    public void setLastCenterTime(LocalDateTime lastCenterTime) {
        this.lastCenterTime = lastCenterTime;
    }

    public String getLastCenter() {
        return lastCenter;
    }

    public void setLastCenter(String lastCenter) {
        this.lastCenter = lastCenter == null ? null : lastCenter.trim();
    }

    public String getLastCenterAdminUserId() {
        return lastCenterAdminUserId;
    }

    public void setLastCenterAdminUserId(String lastCenterAdminUserId) {
        this.lastCenterAdminUserId = lastCenterAdminUserId == null ? null : lastCenterAdminUserId.trim();
    }

    public LocalDateTime getNextCenter() {
        return nextCenter;
    }

    public void setNextCenter(LocalDateTime nextCenter) {
        this.nextCenter = nextCenter;
    }

    public LocalDateTime getLastreturntime() {
        return lastreturntime;
    }

    public void setLastreturntime(LocalDateTime lastreturntime) {
        this.lastreturntime = lastreturntime;
    }

    public String getLastreturncontent() {
        return lastreturncontent;
    }

    public void setLastreturncontent(String lastreturncontent) {
        this.lastreturncontent = lastreturncontent == null ? null : lastreturncontent.trim();
    }

    public String getLastreturnAdminUserId() {
        return lastreturnAdminUserId;
    }

    public void setLastreturnAdminUserId(String lastreturnAdminUserId) {
        this.lastreturnAdminUserId = lastreturnAdminUserId == null ? null : lastreturnAdminUserId.trim();
    }

    public LocalDateTime getNextreturn() {
        return nextreturn;
    }

    public void setNextreturn(LocalDateTime nextreturn) {
        this.nextreturn = nextreturn;
    }

    public LocalDateTime getLastkktime() {
        return lastkktime;
    }

    public void setLastkktime(LocalDateTime lastkktime) {
        this.lastkktime = lastkktime;
    }

    public LocalDateTime getAddedtime() {
        return addedtime;
    }

    public void setAddedtime(LocalDateTime addedtime) {
        this.addedtime = addedtime;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
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

    public String getNAction() {
        return NAction;
    }

    public void setNAction(String NAction) {
        this.NAction = NAction == null ? null : NAction.trim();
    }

    public String getNWarinType() {
        return NWarinType;
    }

    public void setNWarinType(String NWarinType) {
        this.NWarinType = NWarinType == null ? null : NWarinType.trim();
    }
}