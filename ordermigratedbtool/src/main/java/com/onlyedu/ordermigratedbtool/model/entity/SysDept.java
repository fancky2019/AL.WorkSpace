package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class SysDept {
    private Integer deptID;

    private String deptName;

    private Integer reportDeptId;

    private String remark;

    private Boolean isDoPerformance;

    private String addBy;

    private LocalDateTime addedTime;

    private Boolean isDelete;

    private String deleteBy;

    private LocalDateTime deleteTime;

    private String modifyBy;

    private LocalDateTime modifyTime;

    public SysDept(Integer deptID, String deptName, Integer reportDeptId, String remark, Boolean isDoPerformance, String addBy, LocalDateTime addedTime, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, String modifyBy, LocalDateTime modifyTime) {
        this.deptID = deptID;
        this.deptName = deptName;
        this.reportDeptId = reportDeptId;
        this.remark = remark;
        this.isDoPerformance = isDoPerformance;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
    }

    public SysDept() {
        super();
    }

    public Integer getDeptID() {
        return deptID;
    }

    public void setDeptID(Integer deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getReportDeptId() {
        return reportDeptId;
    }

    public void setReportDeptId(Integer reportDeptId) {
        this.reportDeptId = reportDeptId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIsDoPerformance() {
        return isDoPerformance;
    }

    public void setIsDoPerformance(Boolean isDoPerformance) {
        this.isDoPerformance = isDoPerformance;
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