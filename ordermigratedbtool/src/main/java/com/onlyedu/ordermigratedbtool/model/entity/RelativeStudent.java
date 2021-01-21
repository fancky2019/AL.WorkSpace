package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class RelativeStudent {
    private Integer id;

    private Integer userInfoId;

    private Integer eosStudentId;

    private LocalDateTime createTime;

    private Boolean isDelete;

    public RelativeStudent(Integer id, Integer userInfoId, Integer eosStudentId, LocalDateTime createTime, Boolean isDelete) {
        this.id = id;
        this.userInfoId = userInfoId;
        this.eosStudentId = eosStudentId;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public RelativeStudent() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Integer getEosStudentId() {
        return eosStudentId;
    }

    public void setEosStudentId(Integer eosStudentId) {
        this.eosStudentId = eosStudentId;
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