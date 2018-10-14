package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class FunctionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id, reqNo;
    private String funcName, createUser, funcStatus;
    private Date createDate, modiDate, onlineDate;
    private int isDeleted;

    @Override
    public String toString() {
        return "FunctionEntity{" +
                "id=" + id +
                ", reqNo=" + reqNo +
                ", funcName='" + funcName + '\'' +
                ", createUser='" + createUser + '\'' +
                ", funcStatus='" + funcStatus + '\'' +
                ", createDate=" + createDate +
                ", modiDate=" + modiDate +
                ", onlineDate=" + onlineDate +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReqNo() {
        return reqNo;
    }

    public void setReqNo(Long reqNo) {
        this.reqNo = reqNo;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getFuncStatus() {
        return funcStatus;
    }

    public void setFuncStatus(String funcStatus) {
        this.funcStatus = funcStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModiDate() {
        return modiDate;
    }

    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
    }

    public Date getOnlineDate() {
        return onlineDate;
    }

    public void setOnlineDate(Date onlineDate) {
        this.onlineDate = onlineDate;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
