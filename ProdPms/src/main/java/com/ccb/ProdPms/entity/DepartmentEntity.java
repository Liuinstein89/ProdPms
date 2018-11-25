package com.ccb.ProdPms.entity;

import java.io.Serializable;

public class DepartmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String dptName, dptCode, opPerson;
    private String createTime, changeTime;
    private int isDeleted;

    public DepartmentEntity() {
    }

    public DepartmentEntity(String dptName, String dptCode, String opPerson, String createTime) {

        this.dptName = dptName;
        this.dptCode = dptCode;
        this.opPerson = opPerson;
        this.createTime = createTime;
    }

    public DepartmentEntity(Long id, String dptName, String dptCode, String changeTime) {
        this.id = id;
        this.dptName = dptName;
        this.dptCode = dptCode;
//        this.opPerson = opPerson;
        this.changeTime = changeTime;
    }
    public DepartmentEntity(String dptName, String dptCode, String changeTime) {

        this.dptName = dptName;
        this.dptCode = dptCode;
        this.changeTime = changeTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDptName() {
        return dptName;
    }

    public void setDptName(String dptName) {
        this.dptName = dptName;
    }

    public String getDptCode() {
        return dptCode;
    }

    public void setDptCode(String dptCode) {
        this.dptCode = dptCode;
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
