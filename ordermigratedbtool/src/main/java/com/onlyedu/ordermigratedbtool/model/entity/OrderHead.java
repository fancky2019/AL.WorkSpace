package com.onlyedu.ordermigratedbtool.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderHead {
    private Integer id;

    private String orderno;

    private String userorderno;

    private String bankno;

    private String receiptno;

    private String invoiceno;

    private String contractno;

    private String draftno;

    private String registrationno;

    private Integer ordertype;

    private String studentid;

    private Integer orderstateid;

    private String forremarks;

    private String errorstateremarks;

    private String backremarks;

    private String remark;

    private BigDecimal returnpay;

    private Short activeid;

    private Short continued;

    private Short continuous;

    private LocalDateTime backpaytime;

    private LocalDateTime approvedtime;

    private String turnreceiptno;

    private String huanreceiptno;

    private String tempreceiptno;

    private String shareuserid;

    private String shareuserid2;

    private Short percents;

    private String addby;

    private LocalDateTime addedtime;

    private Boolean ismend;

    private String creator;

    private Boolean isdelete;

    private String deleteby;

    private LocalDateTime deletetime;

    private Boolean ismodify;

    private String modifyby;

    private LocalDateTime modifytime;

    private Integer ischange;

    private String zeroreason;

    private Integer isexpired;

    private LocalDateTime changetime;

    private LocalDateTime returntime;

    private LocalDateTime bjtime;

    private String returnreason;

    private LocalDateTime expiredtime;

    private BigDecimal eosbalance;

    private Boolean relativestate;

    private String eosorder;

    public OrderHead(Integer id, String orderno, String userorderno, String bankno, String receiptno, String invoiceno, String contractno, String draftno, String registrationno, Integer ordertype, String studentid, Integer orderstateid, String forremarks, String errorstateremarks, String backremarks, String remark, BigDecimal returnpay, Short activeid, Short continued, Short continuous, LocalDateTime backpaytime, LocalDateTime approvedtime, String turnreceiptno, String huanreceiptno, String tempreceiptno, String shareuserid, String shareuserid2, Short percents, String addby, LocalDateTime addedtime, Boolean ismend, String creator, Boolean isdelete, String deleteby, LocalDateTime deletetime, Boolean ismodify, String modifyby, LocalDateTime modifytime, Integer ischange, String zeroreason, Integer isexpired, LocalDateTime changetime, LocalDateTime returntime, LocalDateTime bjtime, String returnreason, LocalDateTime expiredtime, BigDecimal eosbalance, Boolean relativestate) {
        this.id = id;
        this.orderno = orderno;
        this.userorderno = userorderno;
        this.bankno = bankno;
        this.receiptno = receiptno;
        this.invoiceno = invoiceno;
        this.contractno = contractno;
        this.draftno = draftno;
        this.registrationno = registrationno;
        this.ordertype = ordertype;
        this.studentid = studentid;
        this.orderstateid = orderstateid;
        this.forremarks = forremarks;
        this.errorstateremarks = errorstateremarks;
        this.backremarks = backremarks;
        this.remark = remark;
        this.returnpay = returnpay;
        this.activeid = activeid;
        this.continued = continued;
        this.continuous = continuous;
        this.backpaytime = backpaytime;
        this.approvedtime = approvedtime;
        this.turnreceiptno = turnreceiptno;
        this.huanreceiptno = huanreceiptno;
        this.tempreceiptno = tempreceiptno;
        this.shareuserid = shareuserid;
        this.shareuserid2 = shareuserid2;
        this.percents = percents;
        this.addby = addby;
        this.addedtime = addedtime;
        this.ismend = ismend;
        this.creator = creator;
        this.isdelete = isdelete;
        this.deleteby = deleteby;
        this.deletetime = deletetime;
        this.ismodify = ismodify;
        this.modifyby = modifyby;
        this.modifytime = modifytime;
        this.ischange = ischange;
        this.zeroreason = zeroreason;
        this.isexpired = isexpired;
        this.changetime = changetime;
        this.returntime = returntime;
        this.bjtime = bjtime;
        this.returnreason = returnreason;
        this.expiredtime = expiredtime;
        this.eosbalance = eosbalance;
        this.relativestate = relativestate;
    }

    public OrderHead(Integer id, String orderno, String userorderno, String bankno, String receiptno, String invoiceno, String contractno, String draftno, String registrationno, Integer ordertype, String studentid, Integer orderstateid, String forremarks, String errorstateremarks, String backremarks, String remark, BigDecimal returnpay, Short activeid, Short continued, Short continuous, LocalDateTime backpaytime, LocalDateTime approvedtime, String turnreceiptno, String huanreceiptno, String tempreceiptno, String shareuserid, String shareuserid2, Short percents, String addby, LocalDateTime addedtime, Boolean ismend, String creator, Boolean isdelete, String deleteby, LocalDateTime deletetime, Boolean ismodify, String modifyby, LocalDateTime modifytime, Integer ischange, String zeroreason, Integer isexpired, LocalDateTime changetime, LocalDateTime returntime, LocalDateTime bjtime, String returnreason, LocalDateTime expiredtime, BigDecimal eosbalance, Boolean relativestate, String eosorder) {
        this.id = id;
        this.orderno = orderno;
        this.userorderno = userorderno;
        this.bankno = bankno;
        this.receiptno = receiptno;
        this.invoiceno = invoiceno;
        this.contractno = contractno;
        this.draftno = draftno;
        this.registrationno = registrationno;
        this.ordertype = ordertype;
        this.studentid = studentid;
        this.orderstateid = orderstateid;
        this.forremarks = forremarks;
        this.errorstateremarks = errorstateremarks;
        this.backremarks = backremarks;
        this.remark = remark;
        this.returnpay = returnpay;
        this.activeid = activeid;
        this.continued = continued;
        this.continuous = continuous;
        this.backpaytime = backpaytime;
        this.approvedtime = approvedtime;
        this.turnreceiptno = turnreceiptno;
        this.huanreceiptno = huanreceiptno;
        this.tempreceiptno = tempreceiptno;
        this.shareuserid = shareuserid;
        this.shareuserid2 = shareuserid2;
        this.percents = percents;
        this.addby = addby;
        this.addedtime = addedtime;
        this.ismend = ismend;
        this.creator = creator;
        this.isdelete = isdelete;
        this.deleteby = deleteby;
        this.deletetime = deletetime;
        this.ismodify = ismodify;
        this.modifyby = modifyby;
        this.modifytime = modifytime;
        this.ischange = ischange;
        this.zeroreason = zeroreason;
        this.isexpired = isexpired;
        this.changetime = changetime;
        this.returntime = returntime;
        this.bjtime = bjtime;
        this.returnreason = returnreason;
        this.expiredtime = expiredtime;
        this.eosbalance = eosbalance;
        this.relativestate = relativestate;
        this.eosorder = eosorder;
    }

    public OrderHead() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getUserorderno() {
        return userorderno;
    }

    public void setUserorderno(String userorderno) {
        this.userorderno = userorderno == null ? null : userorderno.trim();
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno == null ? null : bankno.trim();
    }

    public String getReceiptno() {
        return receiptno;
    }

    public void setReceiptno(String receiptno) {
        this.receiptno = receiptno == null ? null : receiptno.trim();
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno == null ? null : invoiceno.trim();
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno == null ? null : contractno.trim();
    }

    public String getDraftno() {
        return draftno;
    }

    public void setDraftno(String draftno) {
        this.draftno = draftno == null ? null : draftno.trim();
    }

    public String getRegistrationno() {
        return registrationno;
    }

    public void setRegistrationno(String registrationno) {
        this.registrationno = registrationno == null ? null : registrationno.trim();
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public Integer getOrderstateid() {
        return orderstateid;
    }

    public void setOrderstateid(Integer orderstateid) {
        this.orderstateid = orderstateid;
    }

    public String getForremarks() {
        return forremarks;
    }

    public void setForremarks(String forremarks) {
        this.forremarks = forremarks == null ? null : forremarks.trim();
    }

    public String getErrorstateremarks() {
        return errorstateremarks;
    }

    public void setErrorstateremarks(String errorstateremarks) {
        this.errorstateremarks = errorstateremarks == null ? null : errorstateremarks.trim();
    }

    public String getBackremarks() {
        return backremarks;
    }

    public void setBackremarks(String backremarks) {
        this.backremarks = backremarks == null ? null : backremarks.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getReturnpay() {
        return returnpay;
    }

    public void setReturnpay(BigDecimal returnpay) {
        this.returnpay = returnpay;
    }

    public Short getActiveid() {
        return activeid;
    }

    public void setActiveid(Short activeid) {
        this.activeid = activeid;
    }

    public Short getContinued() {
        return continued;
    }

    public void setContinued(Short continued) {
        this.continued = continued;
    }

    public Short getContinuous() {
        return continuous;
    }

    public void setContinuous(Short continuous) {
        this.continuous = continuous;
    }

    public LocalDateTime getBackpaytime() {
        return backpaytime;
    }

    public void setBackpaytime(LocalDateTime backpaytime) {
        this.backpaytime = backpaytime;
    }

    public LocalDateTime getApprovedtime() {
        return approvedtime;
    }

    public void setApprovedtime(LocalDateTime approvedtime) {
        this.approvedtime = approvedtime;
    }

    public String getTurnreceiptno() {
        return turnreceiptno;
    }

    public void setTurnreceiptno(String turnreceiptno) {
        this.turnreceiptno = turnreceiptno == null ? null : turnreceiptno.trim();
    }

    public String getHuanreceiptno() {
        return huanreceiptno;
    }

    public void setHuanreceiptno(String huanreceiptno) {
        this.huanreceiptno = huanreceiptno == null ? null : huanreceiptno.trim();
    }

    public String getTempreceiptno() {
        return tempreceiptno;
    }

    public void setTempreceiptno(String tempreceiptno) {
        this.tempreceiptno = tempreceiptno == null ? null : tempreceiptno.trim();
    }

    public String getShareuserid() {
        return shareuserid;
    }

    public void setShareuserid(String shareuserid) {
        this.shareuserid = shareuserid == null ? null : shareuserid.trim();
    }

    public String getShareuserid2() {
        return shareuserid2;
    }

    public void setShareuserid2(String shareuserid2) {
        this.shareuserid2 = shareuserid2 == null ? null : shareuserid2.trim();
    }

    public Short getPercents() {
        return percents;
    }

    public void setPercents(Short percents) {
        this.percents = percents;
    }

    public String getAddby() {
        return addby;
    }

    public void setAddby(String addby) {
        this.addby = addby == null ? null : addby.trim();
    }

    public LocalDateTime getAddedtime() {
        return addedtime;
    }

    public void setAddedtime(LocalDateTime addedtime) {
        this.addedtime = addedtime;
    }

    public Boolean getIsmend() {
        return ismend;
    }

    public void setIsmend(Boolean ismend) {
        this.ismend = ismend;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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

    public LocalDateTime getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(LocalDateTime deletetime) {
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

    public LocalDateTime getModifytime() {
        return modifytime;
    }

    public void setModifytime(LocalDateTime modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getIschange() {
        return ischange;
    }

    public void setIschange(Integer ischange) {
        this.ischange = ischange;
    }

    public String getZeroreason() {
        return zeroreason;
    }

    public void setZeroreason(String zeroreason) {
        this.zeroreason = zeroreason == null ? null : zeroreason.trim();
    }

    public Integer getIsexpired() {
        return isexpired;
    }

    public void setIsexpired(Integer isexpired) {
        this.isexpired = isexpired;
    }

    public LocalDateTime getChangetime() {
        return changetime;
    }

    public void setChangetime(LocalDateTime changetime) {
        this.changetime = changetime;
    }

    public LocalDateTime getReturntime() {
        return returntime;
    }

    public void setReturntime(LocalDateTime returntime) {
        this.returntime = returntime;
    }

    public LocalDateTime getBjtime() {
        return bjtime;
    }

    public void setBjtime(LocalDateTime bjtime) {
        this.bjtime = bjtime;
    }

    public String getReturnreason() {
        return returnreason;
    }

    public void setReturnreason(String returnreason) {
        this.returnreason = returnreason == null ? null : returnreason.trim();
    }

    public LocalDateTime getExpiredtime() {
        return expiredtime;
    }

    public void setExpiredtime(LocalDateTime expiredtime) {
        this.expiredtime = expiredtime;
    }

    public BigDecimal getEosbalance() {
        return eosbalance;
    }

    public void setEosbalance(BigDecimal eosbalance) {
        this.eosbalance = eosbalance;
    }

    public Boolean getRelativestate() {
        return relativestate;
    }

    public void setRelativestate(Boolean relativestate) {
        this.relativestate = relativestate;
    }

    public String getEosorder() {
        return eosorder;
    }

    public void setEosorder(String eosorder) {
        this.eosorder = eosorder == null ? null : eosorder.trim();
    }
}