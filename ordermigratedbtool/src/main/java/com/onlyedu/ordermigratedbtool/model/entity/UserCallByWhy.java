package com.onlyedu.ordermigratedbtool.model.entity;

public class UserCallByWhy {
    private Integer id;

    private String whyCallType;

    public UserCallByWhy(Integer id, String whyCallType) {
        this.id = id;
        this.whyCallType = whyCallType;
    }

    public UserCallByWhy() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhyCallType() {
        return whyCallType;
    }

    public void setWhyCallType(String whyCallType) {
        this.whyCallType = whyCallType == null ? null : whyCallType.trim();
    }
}