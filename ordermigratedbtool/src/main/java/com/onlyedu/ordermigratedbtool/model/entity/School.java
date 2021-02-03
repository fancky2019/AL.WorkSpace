package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class School {
    private String guid;

    private Integer schoolId;

    private String school;

    private String shortName;

    private String districtGuid;

    private String address;

    private Boolean addressFlag;

    private String postCode;

    private Integer type;

    private Integer nature;

    private String BQPM;

    private String BKLQL;

    private String YBLQL;

    private String XSXX;

    private String BKXX;

    private String FJXX;

    private String QTXX;

    private String XZ;

    private String XZ_sjkm;

    private String XZ_Mobilephone;

    private String XZ_Tel;

    private String FXZ;

    private String FXZ_sjkm;

    private String FXZ_Mobilephone;

    private String FXZ_Tel;

    private String SJ;

    private String JWCZ;

    private String JDZR;

    private String JDZR_sjkm;

    private String JDZR_Mobilephone;

    private String JDZR_Tel;

    private String QTJXQK;

    private String addBy;

    private LocalDateTime addedTime;

    private Boolean isDelete;

    private String deleteBy;

    private LocalDateTime deleteTime;

    private Boolean isModify;

    private String modifyBy;

    private LocalDateTime modifyTime;

    private String schoolType;

    public School(String guid, Integer schoolId, String school, String shortName, String districtGuid, String address, Boolean addressFlag, String postCode, Integer type, Integer nature, String BQPM, String BKLQL, String YBLQL, String XSXX, String BKXX, String FJXX, String QTXX, String XZ, String XZ_sjkm, String XZ_Mobilephone, String XZ_Tel, String FXZ, String FXZ_sjkm, String FXZ_Mobilephone, String FXZ_Tel, String SJ, String JWCZ, String JDZR, String JDZR_sjkm, String JDZR_Mobilephone, String JDZR_Tel, String QTJXQK, String addBy, LocalDateTime addedTime, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, Boolean isModify, String modifyBy, LocalDateTime modifyTime, String schoolType) {
        this.guid = guid;
        this.schoolId = schoolId;
        this.school = school;
        this.shortName = shortName;
        this.districtGuid = districtGuid;
        this.address = address;
        this.addressFlag = addressFlag;
        this.postCode = postCode;
        this.type = type;
        this.nature = nature;
        this.BQPM = BQPM;
        this.BKLQL = BKLQL;
        this.YBLQL = YBLQL;
        this.XSXX = XSXX;
        this.BKXX = BKXX;
        this.FJXX = FJXX;
        this.QTXX = QTXX;
        this.XZ = XZ;
        this.XZ_sjkm = XZ_sjkm;
        this.XZ_Mobilephone = XZ_Mobilephone;
        this.XZ_Tel = XZ_Tel;
        this.FXZ = FXZ;
        this.FXZ_sjkm = FXZ_sjkm;
        this.FXZ_Mobilephone = FXZ_Mobilephone;
        this.FXZ_Tel = FXZ_Tel;
        this.SJ = SJ;
        this.JWCZ = JWCZ;
        this.JDZR = JDZR;
        this.JDZR_sjkm = JDZR_sjkm;
        this.JDZR_Mobilephone = JDZR_Mobilephone;
        this.JDZR_Tel = JDZR_Tel;
        this.QTJXQK = QTJXQK;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.isModify = isModify;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
        this.schoolType = schoolType;
    }

    public School() {
        super();
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getDistrictGuid() {
        return districtGuid;
    }

    public void setDistrictGuid(String districtGuid) {
        this.districtGuid = districtGuid == null ? null : districtGuid.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Boolean getAddressFlag() {
        return addressFlag;
    }

    public void setAddressFlag(Boolean addressFlag) {
        this.addressFlag = addressFlag;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public String getBQPM() {
        return BQPM;
    }

    public void setBQPM(String BQPM) {
        this.BQPM = BQPM == null ? null : BQPM.trim();
    }

    public String getBKLQL() {
        return BKLQL;
    }

    public void setBKLQL(String BKLQL) {
        this.BKLQL = BKLQL == null ? null : BKLQL.trim();
    }

    public String getYBLQL() {
        return YBLQL;
    }

    public void setYBLQL(String YBLQL) {
        this.YBLQL = YBLQL == null ? null : YBLQL.trim();
    }

    public String getXSXX() {
        return XSXX;
    }

    public void setXSXX(String XSXX) {
        this.XSXX = XSXX == null ? null : XSXX.trim();
    }

    public String getBKXX() {
        return BKXX;
    }

    public void setBKXX(String BKXX) {
        this.BKXX = BKXX == null ? null : BKXX.trim();
    }

    public String getFJXX() {
        return FJXX;
    }

    public void setFJXX(String FJXX) {
        this.FJXX = FJXX == null ? null : FJXX.trim();
    }

    public String getQTXX() {
        return QTXX;
    }

    public void setQTXX(String QTXX) {
        this.QTXX = QTXX == null ? null : QTXX.trim();
    }

    public String getXZ() {
        return XZ;
    }

    public void setXZ(String XZ) {
        this.XZ = XZ == null ? null : XZ.trim();
    }

    public String getXZ_sjkm() {
        return XZ_sjkm;
    }

    public void setXZ_sjkm(String XZ_sjkm) {
        this.XZ_sjkm = XZ_sjkm == null ? null : XZ_sjkm.trim();
    }

    public String getXZ_Mobilephone() {
        return XZ_Mobilephone;
    }

    public void setXZ_Mobilephone(String XZ_Mobilephone) {
        this.XZ_Mobilephone = XZ_Mobilephone == null ? null : XZ_Mobilephone.trim();
    }

    public String getXZ_Tel() {
        return XZ_Tel;
    }

    public void setXZ_Tel(String XZ_Tel) {
        this.XZ_Tel = XZ_Tel == null ? null : XZ_Tel.trim();
    }

    public String getFXZ() {
        return FXZ;
    }

    public void setFXZ(String FXZ) {
        this.FXZ = FXZ == null ? null : FXZ.trim();
    }

    public String getFXZ_sjkm() {
        return FXZ_sjkm;
    }

    public void setFXZ_sjkm(String FXZ_sjkm) {
        this.FXZ_sjkm = FXZ_sjkm == null ? null : FXZ_sjkm.trim();
    }

    public String getFXZ_Mobilephone() {
        return FXZ_Mobilephone;
    }

    public void setFXZ_Mobilephone(String FXZ_Mobilephone) {
        this.FXZ_Mobilephone = FXZ_Mobilephone == null ? null : FXZ_Mobilephone.trim();
    }

    public String getFXZ_Tel() {
        return FXZ_Tel;
    }

    public void setFXZ_Tel(String FXZ_Tel) {
        this.FXZ_Tel = FXZ_Tel == null ? null : FXZ_Tel.trim();
    }

    public String getSJ() {
        return SJ;
    }

    public void setSJ(String SJ) {
        this.SJ = SJ == null ? null : SJ.trim();
    }

    public String getJWCZ() {
        return JWCZ;
    }

    public void setJWCZ(String JWCZ) {
        this.JWCZ = JWCZ == null ? null : JWCZ.trim();
    }

    public String getJDZR() {
        return JDZR;
    }

    public void setJDZR(String JDZR) {
        this.JDZR = JDZR == null ? null : JDZR.trim();
    }

    public String getJDZR_sjkm() {
        return JDZR_sjkm;
    }

    public void setJDZR_sjkm(String JDZR_sjkm) {
        this.JDZR_sjkm = JDZR_sjkm == null ? null : JDZR_sjkm.trim();
    }

    public String getJDZR_Mobilephone() {
        return JDZR_Mobilephone;
    }

    public void setJDZR_Mobilephone(String JDZR_Mobilephone) {
        this.JDZR_Mobilephone = JDZR_Mobilephone == null ? null : JDZR_Mobilephone.trim();
    }

    public String getJDZR_Tel() {
        return JDZR_Tel;
    }

    public void setJDZR_Tel(String JDZR_Tel) {
        this.JDZR_Tel = JDZR_Tel == null ? null : JDZR_Tel.trim();
    }

    public String getQTJXQK() {
        return QTJXQK;
    }

    public void setQTJXQK(String QTJXQK) {
        this.QTJXQK = QTJXQK == null ? null : QTJXQK.trim();
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

    public Boolean getIsModify() {
        return isModify;
    }

    public void setIsModify(Boolean isModify) {
        this.isModify = isModify;
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

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType == null ? null : schoolType.trim();
    }
}