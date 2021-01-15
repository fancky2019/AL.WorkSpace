package com.onlyedu.ordermigratedbtool.model.entity;

import java.util.Date;

public class UserInfo {
    private String studentid;

    private Integer id;

    private String studentno;

    private String userid;

    private String password;

    private String pwd;

    private String username;

    private String sex;

    private String birthday;

    private String avatar;

    private String provinceid;

    private String districtid;

    private String schoolid;

    private String grade;

    private String educationlevel;

    private String tel;

    private String mobilephone;

    private String address;

    private String postcode;

    private String email;

    private String msn;

    private String qq;

    private Date lastlogintime;

    private String lastloginip;

    private Date regtime;

    private String regip;

    private Integer status;

    private String usertype;

    private String usersourceid;

    private Boolean erroraddress;

    private String othercourse;

    private String isjoinrecruitment;

    private String nowadmin;

    private Date addadmintime;

    private Integer isonline;

    private Integer locktype;

    private String regsourceid;

    private String regsourcein;

    private String regsourcepage;

    private Boolean islistforcf;

    private String othertel;

    private Integer isranking;

    private Boolean isclear;

    private Integer bmlevel;

    private String userclassguid;

    private String remark;

    private String addby;

    private Date addedtime;

    private Boolean isdelete;

    private String deleteby;

    private Date deletetime;

    private Boolean ismodify;

    private String modifyby;

    private Date modifytime;

    private Boolean isexamine;

    private Integer studenttype;

    private Date studenttypetime;

    private Integer validtype;

    private Integer smallvalidtype;

    private String boxid;

    private String eOSUserInfo;

    public UserInfo(String studentid, Integer id, String studentno, String userid, String password, String pwd, String username, String sex, String birthday, String avatar, String provinceid, String districtid, String schoolid, String grade, String educationlevel, String tel, String mobilephone, String address, String postcode, String email, String msn, String qq, Date lastlogintime, String lastloginip, Date regtime, String regip, Integer status, String usertype, String usersourceid, Boolean erroraddress, String othercourse, String isjoinrecruitment, String nowadmin, Date addadmintime, Integer isonline, Integer locktype, String regsourceid, String regsourcein, String regsourcepage, Boolean islistforcf, String othertel, Integer isranking, Boolean isclear, Integer bmlevel, String userclassguid, String remark, String addby, Date addedtime, Boolean isdelete, String deleteby, Date deletetime, Boolean ismodify, String modifyby, Date modifytime, Boolean isexamine, Integer studenttype, Date studenttypetime, Integer validtype, Integer smallvalidtype, String boxid) {
        this.studentid = studentid;
        this.id = id;
        this.studentno = studentno;
        this.userid = userid;
        this.password = password;
        this.pwd = pwd;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.avatar = avatar;
        this.provinceid = provinceid;
        this.districtid = districtid;
        this.schoolid = schoolid;
        this.grade = grade;
        this.educationlevel = educationlevel;
        this.tel = tel;
        this.mobilephone = mobilephone;
        this.address = address;
        this.postcode = postcode;
        this.email = email;
        this.msn = msn;
        this.qq = qq;
        this.lastlogintime = lastlogintime;
        this.lastloginip = lastloginip;
        this.regtime = regtime;
        this.regip = regip;
        this.status = status;
        this.usertype = usertype;
        this.usersourceid = usersourceid;
        this.erroraddress = erroraddress;
        this.othercourse = othercourse;
        this.isjoinrecruitment = isjoinrecruitment;
        this.nowadmin = nowadmin;
        this.addadmintime = addadmintime;
        this.isonline = isonline;
        this.locktype = locktype;
        this.regsourceid = regsourceid;
        this.regsourcein = regsourcein;
        this.regsourcepage = regsourcepage;
        this.islistforcf = islistforcf;
        this.othertel = othertel;
        this.isranking = isranking;
        this.isclear = isclear;
        this.bmlevel = bmlevel;
        this.userclassguid = userclassguid;
        this.remark = remark;
        this.addby = addby;
        this.addedtime = addedtime;
        this.isdelete = isdelete;
        this.deleteby = deleteby;
        this.deletetime = deletetime;
        this.ismodify = ismodify;
        this.modifyby = modifyby;
        this.modifytime = modifytime;
        this.isexamine = isexamine;
        this.studenttype = studenttype;
        this.studenttypetime = studenttypetime;
        this.validtype = validtype;
        this.smallvalidtype = smallvalidtype;
        this.boxid = boxid;
    }

    public UserInfo() {
        super();
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }

    public String getDistrictid() {
        return districtid;
    }

    public void setDistrictid(String districtid) {
        this.districtid = districtid == null ? null : districtid.trim();
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid == null ? null : schoolid.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getEducationlevel() {
        return educationlevel;
    }

    public void setEducationlevel(String educationlevel) {
        this.educationlevel = educationlevel == null ? null : educationlevel.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getRegip() {
        return regip;
    }

    public void setRegip(String regip) {
        this.regip = regip == null ? null : regip.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public String getUsersourceid() {
        return usersourceid;
    }

    public void setUsersourceid(String usersourceid) {
        this.usersourceid = usersourceid == null ? null : usersourceid.trim();
    }

    public Boolean getErroraddress() {
        return erroraddress;
    }

    public void setErroraddress(Boolean erroraddress) {
        this.erroraddress = erroraddress;
    }

    public String getOthercourse() {
        return othercourse;
    }

    public void setOthercourse(String othercourse) {
        this.othercourse = othercourse == null ? null : othercourse.trim();
    }

    public String getIsjoinrecruitment() {
        return isjoinrecruitment;
    }

    public void setIsjoinrecruitment(String isjoinrecruitment) {
        this.isjoinrecruitment = isjoinrecruitment == null ? null : isjoinrecruitment.trim();
    }

    public String getNowadmin() {
        return nowadmin;
    }

    public void setNowadmin(String nowadmin) {
        this.nowadmin = nowadmin == null ? null : nowadmin.trim();
    }

    public Date getAddadmintime() {
        return addadmintime;
    }

    public void setAddadmintime(Date addadmintime) {
        this.addadmintime = addadmintime;
    }

    public Integer getIsonline() {
        return isonline;
    }

    public void setIsonline(Integer isonline) {
        this.isonline = isonline;
    }

    public Integer getLocktype() {
        return locktype;
    }

    public void setLocktype(Integer locktype) {
        this.locktype = locktype;
    }

    public String getRegsourceid() {
        return regsourceid;
    }

    public void setRegsourceid(String regsourceid) {
        this.regsourceid = regsourceid == null ? null : regsourceid.trim();
    }

    public String getRegsourcein() {
        return regsourcein;
    }

    public void setRegsourcein(String regsourcein) {
        this.regsourcein = regsourcein == null ? null : regsourcein.trim();
    }

    public String getRegsourcepage() {
        return regsourcepage;
    }

    public void setRegsourcepage(String regsourcepage) {
        this.regsourcepage = regsourcepage == null ? null : regsourcepage.trim();
    }

    public Boolean getIslistforcf() {
        return islistforcf;
    }

    public void setIslistforcf(Boolean islistforcf) {
        this.islistforcf = islistforcf;
    }

    public String getOthertel() {
        return othertel;
    }

    public void setOthertel(String othertel) {
        this.othertel = othertel == null ? null : othertel.trim();
    }

    public Integer getIsranking() {
        return isranking;
    }

    public void setIsranking(Integer isranking) {
        this.isranking = isranking;
    }

    public Boolean getIsclear() {
        return isclear;
    }

    public void setIsclear(Boolean isclear) {
        this.isclear = isclear;
    }

    public Integer getBmlevel() {
        return bmlevel;
    }

    public void setBmlevel(Integer bmlevel) {
        this.bmlevel = bmlevel;
    }

    public String getUserclassguid() {
        return userclassguid;
    }

    public void setUserclassguid(String userclassguid) {
        this.userclassguid = userclassguid == null ? null : userclassguid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAddby() {
        return addby;
    }

    public void setAddby(String addby) {
        this.addby = addby == null ? null : addby.trim();
    }

    public Date getAddedtime() {
        return addedtime;
    }

    public void setAddedtime(Date addedtime) {
        this.addedtime = addedtime;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public String getDeleteby() {
        return deleteby;
    }

    public void setDeleteby(String deleteby) {
        this.deleteby = deleteby == null ? null : deleteby.trim();
    }

    public Date getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    public Boolean getIsmodify() {
        return ismodify;
    }

    public void setIsmodify(Boolean ismodify) {
        this.ismodify = ismodify;
    }

    public String getModifyby() {
        return modifyby;
    }

    public void setModifyby(String modifyby) {
        this.modifyby = modifyby == null ? null : modifyby.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Boolean getIsexamine() {
        return isexamine;
    }

    public void setIsexamine(Boolean isexamine) {
        this.isexamine = isexamine;
    }

    public Integer getStudenttype() {
        return studenttype;
    }

    public void setStudenttype(Integer studenttype) {
        this.studenttype = studenttype;
    }

    public Date getStudenttypetime() {
        return studenttypetime;
    }

    public void setStudenttypetime(Date studenttypetime) {
        this.studenttypetime = studenttypetime;
    }

    public Integer getValidtype() {
        return validtype;
    }

    public void setValidtype(Integer validtype) {
        this.validtype = validtype;
    }

    public Integer getSmallvalidtype() {
        return smallvalidtype;
    }

    public void setSmallvalidtype(Integer smallvalidtype) {
        this.smallvalidtype = smallvalidtype;
    }

    public String getBoxid() {
        return boxid;
    }

    public void setBoxid(String boxid) {
        this.boxid = boxid == null ? null : boxid.trim();
    }

    public String geteOSUserInfo() {
        return eOSUserInfo;
    }

    public void seteOSUserInfo(String eOSUserInfo) {
        this.eOSUserInfo = eOSUserInfo;
    }
}