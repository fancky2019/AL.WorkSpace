package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class EosStudent {
    private Integer ID;

    private Integer eosStudentID;

    private String studentName;

    private String grade;

    private String phone;

    private String schoolName;

    private Boolean relativeState;

    private String relativeID;

    private LocalDateTime createTime;

    private Boolean isDelete;

    public EosStudent(Integer ID, Integer eosStudentID, String studentName, String grade, String phone, String schoolName, Boolean relativeState, String relativeID, LocalDateTime createTime, Boolean isDelete) {
        this.ID = ID;
        this.eosStudentID = eosStudentID;
        this.studentName = studentName;
        this.grade = grade;
        this.phone = phone;
        this.schoolName = schoolName;
        this.relativeState = relativeState;
        this.relativeID = relativeID;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public EosStudent() {
        super();
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getEosStudentID() {
        return eosStudentID;
    }

    public void setEosStudentID(Integer eosStudentID) {
        this.eosStudentID = eosStudentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public Boolean getRelativeState() {
        return relativeState;
    }

    public void setRelativeState(Boolean relativeState) {
        this.relativeState = relativeState;
    }

    public String getRelativeID() {
        return relativeID;
    }

    public void setRelativeID(String relativeID) {
        this.relativeID = relativeID == null ? null : relativeID.trim();
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