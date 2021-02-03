package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class SysUser {
    private Integer id;

    private String sysUserGuid;

    private String adminUserId;

    private String adminUserName;

    private String password;

    private String sex;

    private String email;

    private String tel;

    private String mobilePhone;

    private Integer allot;

    private String extension;

    private String avatar;

    private String queueName;

    private String addBy;

    private LocalDateTime addedTime;

    private Boolean isDelete;

    private String deleteBy;

    private LocalDateTime deleteTime;

    private String modifyBy;

    private LocalDateTime modifyTime;

    private Integer userLevel;

    private Integer allotNum;

    public SysUser(Integer id, String sysUserGuid, String adminUserId, String adminUserName, String password, String sex, String email, String tel, String mobilePhone, Integer allot, String extension, String avatar, String queueName, String addBy, LocalDateTime addedTime, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, String modifyBy, LocalDateTime modifyTime, Integer userLevel, Integer allotNum) {
        this.id = id;
        this.sysUserGuid = sysUserGuid;
        this.adminUserId = adminUserId;
        this.adminUserName = adminUserName;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.tel = tel;
        this.mobilePhone = mobilePhone;
        this.allot = allot;
        this.extension = extension;
        this.avatar = avatar;
        this.queueName = queueName;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
        this.userLevel = userLevel;
        this.allotNum = allotNum;
    }

    public SysUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysUserGuid() {
        return sysUserGuid;
    }

    public void setSysUserGuid(String sysUserGuid) {
        this.sysUserGuid = sysUserGuid == null ? null : sysUserGuid.trim();
    }

    public String getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(String adminUserId) {
        this.adminUserId = adminUserId == null ? null : adminUserId.trim();
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName == null ? null : adminUserName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public Integer getAllot() {
        return allot;
    }

    public void setAllot(Integer allot) {
        this.allot = allot;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName == null ? null : queueName.trim();
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

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getAllotNum() {
        return allotNum;
    }

    public void setAllotNum(Integer allotNum) {
        this.allotNum = allotNum;
    }
}