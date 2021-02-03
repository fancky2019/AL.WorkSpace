package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class ParaDistrict {
    private String guid;

    private Integer districtId;

    private String district;

    private String regionGuid;

    private String provinceGuid;

    private String addBy;

    private LocalDateTime addedTime;

    private Boolean isDelete;

    private String deleteBy;

    private LocalDateTime deleteTime;

    private String modifyBy;

    private LocalDateTime modifyTime;

    private Boolean isOnLine;

    public ParaDistrict(String guid, Integer districtId, String district, String regionGuid, String provinceGuid, String addBy, LocalDateTime addedTime, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, String modifyBy, LocalDateTime modifyTime, Boolean isOnLine) {
        this.guid = guid;
        this.districtId = districtId;
        this.district = district;
        this.regionGuid = regionGuid;
        this.provinceGuid = provinceGuid;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
        this.isOnLine = isOnLine;
    }

    public ParaDistrict() {
        super();
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getRegionGuid() {
        return regionGuid;
    }

    public void setRegionGuid(String regionGuid) {
        this.regionGuid = regionGuid == null ? null : regionGuid.trim();
    }

    public String getProvinceGuid() {
        return provinceGuid;
    }

    public void setProvinceGuid(String provinceGuid) {
        this.provinceGuid = provinceGuid == null ? null : provinceGuid.trim();
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

    public Boolean getIsOnLine() {
        return isOnLine;
    }

    public void setIsOnLine(Boolean isOnLine) {
        this.isOnLine = isOnLine;
    }
}