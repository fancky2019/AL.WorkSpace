package com.onlyedu.ordermigratedbtool.model.entity;

public class ChannelType {
    private Integer ID;

    private Integer typeId;

    private String typeName;

    private Integer fid;

    private Integer sort;

    private Boolean isVaild;

    public ChannelType(Integer ID, Integer typeId, String typeName, Integer fid, Integer sort, Boolean isVaild) {
        this.ID = ID;
        this.typeId = typeId;
        this.typeName = typeName;
        this.fid = fid;
        this.sort = sort;
        this.isVaild = isVaild;
    }

    public ChannelType() {
        super();
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsVaild() {
        return isVaild;
    }

    public void setIsVaild(Boolean isVaild) {
        this.isVaild = isVaild;
    }
}