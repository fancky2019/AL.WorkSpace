package com.onlyedu.ordermigratedbtool.model.entity;

import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

public class EosStudent {
    private Integer id;

    private Integer eosStudentID;

    private String studentName;

    private String grade;

    private String phone;

    private String schoolName;

    private Boolean relativeState;

    private Integer relativeStudentID;

    private LocalDateTime createTime;

    private Boolean isDelete;


    public EosStudent() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getRelativeStudentID() {
        return relativeStudentID;
    }

    public void setRelativeStudentID(Integer relativeStudentID) {
        this.relativeStudentID = relativeStudentID;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;//地址相等
        }

        if (obj == null) {
            return false;//非空性：对于任意非空引用x，x.equals(null)应该返回false。
        }

        if (obj instanceof EosStudent) {
            EosStudent other = (EosStudent) obj;
            if (other.getStudentName().equals(this.getStudentName()) &&
                    other.getPhone().equals(this.getPhone()) &&
                    other.getEosStudentID().equals(this.getEosStudentID()) &&
                    other.getGrade().equals(this.getGrade())) {
                return true;
            }
        }

        return false;
    }

//    private boolean equalsStr(String str1, String str2) {
//        if (StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)) {
//            return true;
//        }
//        if (!StringUtils.isEmpty(str1) && str1.equals(str2)) {
//            return true;
//        }
//        return false;
//    }
}