package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class UserValid {
    private Integer id;

    private String studentId;

    private Integer vaildType;

    private Integer smallVaildType;

    private LocalDateTime addtime;

    public UserValid(Integer id, String studentId, Integer vaildType, Integer smallVaildType, LocalDateTime addtime) {
        this.id = id;
        this.studentId = studentId;
        this.vaildType = vaildType;
        this.smallVaildType = smallVaildType;
        this.addtime = addtime;
    }

    public UserValid() {
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

    public Integer getVaildType() {
        return vaildType;
    }

    public void setVaildType(Integer vaildType) {
        this.vaildType = vaildType;
    }

    public Integer getSmallVaildType() {
        return smallVaildType;
    }

    public void setSmallVaildType(Integer smallVaildType) {
        this.smallVaildType = smallVaildType;
    }

    public LocalDateTime getAddtime() {
        return addtime;
    }

    public void setAddtime(LocalDateTime addtime) {
        this.addtime = addtime;
    }
}