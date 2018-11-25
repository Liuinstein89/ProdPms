package com.ccb.ProdPms.entity;

import java.io.Serializable;

public class ReqSourceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String souceName,opPerson;
    private String createTime, changeTime;
    private int isDeleted;

    public ReqSourceEntity() {
    }

    public ReqSourceEntity(String souceName, String opPerson, String createTime) {

        this.souceName = souceName;
        this.opPerson = opPerson;
        this.createTime = createTime;
    }

    public ReqSourceEntity(Long id, String souceName,String changeTime) {
        this.id = id;
        this.souceName = souceName;
//        this.opPerson = opPerson;
        this.changeTime = changeTime;
    }

    public ReqSourceEntity(String souceName,   String changeTime) {

        this.souceName = souceName;

        this.changeTime = changeTime;
    }

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
