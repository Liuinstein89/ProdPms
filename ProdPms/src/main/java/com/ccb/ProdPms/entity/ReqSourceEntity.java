package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class ReqSourceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String souceName,opPerson;
    private Date createTime, changeTime;
    private int isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSouceName() {
        return souceName;
    }

    public void setSouceName(String souceName) {
        this.souceName = souceName;
    }

    public String getOpPerson() {
        return opPerson;
    }

    public void setOpPerson(String opPerson) {
        this.opPerson = opPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
