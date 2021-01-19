package com.onlyedu.ordermigratedbtool.model.entity;

import java.time.LocalDateTime;

public class UserInfo {
    private String studentId;

    private Integer id;

    private String studentno;

    private String userId;

    private String passWord;

    private String pwd;

    private String userName;

    private String sex;

    private String birthday;

    private String avatar;

    private String provinceId;

    private String districtId;

    private String schoolId;

    private String grade;

    private String educationLevel;

    private String tel;

    private String mobilePhone;

    private String address;

    private String postCode;

    private String email;

    private String MSN;

    private String QQ;

    private LocalDateTime lastLoginTime;

    private String lastLoginIp;

    private LocalDateTime regTime;

    private String regIP;

    private Integer status;

    private String userType;

    private String userSourceId;

    private Boolean errorAddress;

    private String otherCourse;

    private String isJoinRecruitment;

    private String nowAdmin;

    private LocalDateTime addAdminTime;

    private Integer isOnLine;

    private Integer lockType;

    private String regSourceID;

    private String regSourceIn;

    private String regSourcePage;

    private Boolean isListForCF;

    private String otherTel;

    private Integer isRanking;

    private Boolean isClear;

    private Integer BMlevel;

    private String userClassGuid;

    private String remark;

    private String addBy;

    private LocalDateTime addedTime;

    private Boolean isDelete;

    private String deleteBy;

    private LocalDateTime deleteTime;

    private Boolean isModify;

    private String modifyBy;

    private LocalDateTime modifyTime;

    private Boolean isExamine;

    private Integer studentType;

    private LocalDateTime studentTypeTime;

    private Integer validType;

    private Integer smallvalidType;

    private String boxId;

    private Boolean relativeState;

    private String eOSUserInfo;

    public UserInfo(String studentId, Integer id, String studentno, String userId, String passWord, String pwd, String userName, String sex, String birthday, String avatar, String provinceId, String districtId, String schoolId, String grade, String educationLevel, String tel, String mobilePhone, String address, String postCode, String email, String MSN, String QQ, LocalDateTime lastLoginTime, String lastLoginIp, LocalDateTime regTime, String regIP, Integer status, String userType, String userSourceId, Boolean errorAddress, String otherCourse, String isJoinRecruitment, String nowAdmin, LocalDateTime addAdminTime, Integer isOnLine, Integer lockType, String regSourceID, String regSourceIn, String regSourcePage, Boolean isListForCF, String otherTel, Integer isRanking, Boolean isClear, Integer BMlevel, String userClassGuid, String remark, String addBy, LocalDateTime addedTime, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, Boolean isModify, String modifyBy, LocalDateTime modifyTime, Boolean isExamine, Integer studentType, LocalDateTime studentTypeTime, Integer validType, Integer smallvalidType, String boxId, Boolean relativeState) {
        this.studentId = studentId;
        this.id = id;
        this.studentno = studentno;
        this.userId = userId;
        this.passWord = passWord;
        this.pwd = pwd;
        this.userName = userName;
        this.sex = sex;
        this.birthday = birthday;
        this.avatar = avatar;
        this.provinceId = provinceId;
        this.districtId = districtId;
        this.schoolId = schoolId;
        this.grade = grade;
        this.educationLevel = educationLevel;
        this.tel = tel;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.postCode = postCode;
        this.email = email;
        this.MSN = MSN;
        this.QQ = QQ;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.regTime = regTime;
        this.regIP = regIP;
        this.status = status;
        this.userType = userType;
        this.userSourceId = userSourceId;
        this.errorAddress = errorAddress;
        this.otherCourse = otherCourse;
        this.isJoinRecruitment = isJoinRecruitment;
        this.nowAdmin = nowAdmin;
        this.addAdminTime = addAdminTime;
        this.isOnLine = isOnLine;
        this.lockType = lockType;
        this.regSourceID = regSourceID;
        this.regSourceIn = regSourceIn;
        this.regSourcePage = regSourcePage;
        this.isListForCF = isListForCF;
        this.otherTel = otherTel;
        this.isRanking = isRanking;
        this.isClear = isClear;
        this.BMlevel = BMlevel;
        this.userClassGuid = userClassGuid;
        this.remark = remark;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.isModify = isModify;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
        this.isExamine = isExamine;
        this.studentType = studentType;
        this.studentTypeTime = studentTypeTime;
        this.validType = validType;
        this.smallvalidType = smallvalidType;
        this.boxId = boxId;
        this.relativeState = relativeState;
    }

    public UserInfo(String studentId, Integer id, String studentno, String userId, String passWord, String pwd, String userName, String sex, String birthday, String avatar, String provinceId, String districtId, String schoolId, String grade, String educationLevel, String tel, String mobilePhone, String address, String postCode, String email, String MSN, String QQ, LocalDateTime lastLoginTime, String lastLoginIp, LocalDateTime regTime, String regIP, Integer status, String userType, String userSourceId, Boolean errorAddress, String otherCourse, String isJoinRecruitment, String nowAdmin, LocalDateTime addAdminTime, Integer isOnLine, Integer lockType, String regSourceID, String regSourceIn, String regSourcePage, Boolean isListForCF, String otherTel, Integer isRanking, Boolean isClear, Integer BMlevel, String userClassGuid, String remark, String addBy, LocalDateTime addedTime, Boolean isDelete, String deleteBy, LocalDateTime deleteTime, Boolean isModify, String modifyBy, LocalDateTime modifyTime, Boolean isExamine, Integer studentType, LocalDateTime studentTypeTime, Integer validType, Integer smallvalidType, String boxId, Boolean relativeState, String EOSUserInfo) {
        this.studentId = studentId;
        this.id = id;
        this.studentno = studentno;
        this.userId = userId;
        this.passWord = passWord;
        this.pwd = pwd;
        this.userName = userName;
        this.sex = sex;
        this.birthday = birthday;
        this.avatar = avatar;
        this.provinceId = provinceId;
        this.districtId = districtId;
        this.schoolId = schoolId;
        this.grade = grade;
        this.educationLevel = educationLevel;
        this.tel = tel;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.postCode = postCode;
        this.email = email;
        this.MSN = MSN;
        this.QQ = QQ;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.regTime = regTime;
        this.regIP = regIP;
        this.status = status;
        this.userType = userType;
        this.userSourceId = userSourceId;
        this.errorAddress = errorAddress;
        this.otherCourse = otherCourse;
        this.isJoinRecruitment = isJoinRecruitment;
        this.nowAdmin = nowAdmin;
        this.addAdminTime = addAdminTime;
        this.isOnLine = isOnLine;
        this.lockType = lockType;
        this.regSourceID = regSourceID;
        this.regSourceIn = regSourceIn;
        this.regSourcePage = regSourcePage;
        this.isListForCF = isListForCF;
        this.otherTel = otherTel;
        this.isRanking = isRanking;
        this.isClear = isClear;
        this.BMlevel = BMlevel;
        this.userClassGuid = userClassGuid;
        this.remark = remark;
        this.addBy = addBy;
        this.addedTime = addedTime;
        this.isDelete = isDelete;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.isModify = isModify;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
        this.isExamine = isExamine;
        this.studentType = studentType;
        this.studentTypeTime = studentTypeTime;
        this.validType = validType;
        this.smallvalidType = smallvalidType;
        this.boxId = boxId;
        this.relativeState = relativeState;
        this.eOSUserInfo = EOSUserInfo;
    }

    public UserInfo() {
        super();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno == null ? null : studentno.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId == null ? null : districtId.trim();
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel == null ? null : educationLevel.trim();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMSN() {
        return MSN;
    }

    public void setMSN(String MSN) {
        this.MSN = MSN == null ? null : MSN.trim();
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ == null ? null : QQ.trim();
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }

    public String getRegIP() {
        return regIP;
    }

    public void setRegIP(String regIP) {
        this.regIP = regIP == null ? null : regIP.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserSourceId() {
        return userSourceId;
    }

    public void setUserSourceId(String userSourceId) {
        this.userSourceId = userSourceId == null ? null : userSourceId.trim();
    }

    public Boolean getErrorAddress() {
        return errorAddress;
    }

    public void setErrorAddress(Boolean errorAddress) {
        this.errorAddress = errorAddress;
    }

    public String getOtherCourse() {
        return otherCourse;
    }

    public void setOtherCourse(String otherCourse) {
        this.otherCourse = otherCourse == null ? null : otherCourse.trim();
    }

    public String getIsJoinRecruitment() {
        return isJoinRecruitment;
    }

    public void setIsJoinRecruitment(String isJoinRecruitment) {
        this.isJoinRecruitment = isJoinRecruitment == null ? null : isJoinRecruitment.trim();
    }

    public String getNowAdmin() {
        return nowAdmin;
    }

    public void setNowAdmin(String nowAdmin) {
        this.nowAdmin = nowAdmin == null ? null : nowAdmin.trim();
    }

    public LocalDateTime getAddAdminTime() {
        return addAdminTime;
    }

    public void setAddAdminTime(LocalDateTime addAdminTime) {
        this.addAdminTime = addAdminTime;
    }

    public Integer getIsOnLine() {
        return isOnLine;
    }

    public void setIsOnLine(Integer isOnLine) {
        this.isOnLine = isOnLine;
    }

    public Integer getLockType() {
        return lockType;
    }

    public void setLockType(Integer lockType) {
        this.lockType = lockType;
    }

    public String getRegSourceID() {
        return regSourceID;
    }

    public void setRegSourceID(String regSourceID) {
        this.regSourceID = regSourceID == null ? null : regSourceID.trim();
    }

    public String getRegSourceIn() {
        return regSourceIn;
    }

    public void setRegSourceIn(String regSourceIn) {
        this.regSourceIn = regSourceIn == null ? null : regSourceIn.trim();
    }

    public String getRegSourcePage() {
        return regSourcePage;
    }

    public void setRegSourcePage(String regSourcePage) {
        this.regSourcePage = regSourcePage == null ? null : regSourcePage.trim();
    }

    public Boolean getIsListForCF() {
        return isListForCF;
    }

    public void setIsListForCF(Boolean isListForCF) {
        this.isListForCF = isListForCF;
    }

    public String getOtherTel() {
        return otherTel;
    }

    public void setOtherTel(String otherTel) {
        this.otherTel = otherTel == null ? null : otherTel.trim();
    }

    public Integer getIsRanking() {
        return isRanking;
    }

    public void setIsRanking(Integer isRanking) {
        this.isRanking = isRanking;
    }

    public Boolean getIsClear() {
        return isClear;
    }

    public void setIsClear(Boolean isClear) {
        this.isClear = isClear;
    }

    public Integer getBMlevel() {
        return BMlevel;
    }

    public void setBMlevel(Integer BMlevel) {
        this.BMlevel = BMlevel;
    }

    public String getUserClassGuid() {
        return userClassGuid;
    }

    public void setUserClassGuid(String userClassGuid) {
        this.userClassGuid = userClassGuid == null ? null : userClassGuid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Boolean getIsExamine() {
        return isExamine;
    }

    public void setIsExamine(Boolean isExamine) {
        this.isExamine = isExamine;
    }

    public Integer getStudentType() {
        return studentType;
    }

    public void setStudentType(Integer studentType) {
        this.studentType = studentType;
    }

    public LocalDateTime getStudentTypeTime() {
        return studentTypeTime;
    }

    public void setStudentTypeTime(LocalDateTime studentTypeTime) {
        this.studentTypeTime = studentTypeTime;
    }

    public Integer getValidType() {
        return validType;
    }

    public void setValidType(Integer validType) {
        this.validType = validType;
    }

    public Integer getSmallvalidType() {
        return smallvalidType;
    }

    public void setSmallvalidType(Integer smallvalidType) {
        this.smallvalidType = smallvalidType;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId == null ? null : boxId.trim();
    }

    public Boolean getRelativeState() {
        return relativeState;
    }

    public void setRelativeState(Boolean relativeState) {
        this.relativeState = relativeState;
    }

    public String geteOSUserInfo() {
        return eOSUserInfo;
    }

    public void seteOSUserInfo(String eOSUserInfo) {
        this.eOSUserInfo = eOSUserInfo == null ? null : eOSUserInfo.trim();
    }
}