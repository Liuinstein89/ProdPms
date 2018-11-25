package com.ccb.ProdPms.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ExecTypeEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String typeName, createDate, modiDate, opPerson;
    private int isDeleted;

    public ExecTypeEntity(){

    }

    public ExecTypeEntity(Integer id, String typeName, String modiDate, String opPerson){
        this.id=id;
        this.typeName=typeName;
        this.modiDate=modiDate;
        this.opPerson=opPerson;
    }

    public ExecTypeEntity(String typeName, String createDate, String modiDate, String opPerson){
        this.typeName=typeName;
        this.createDate=createDate;
        this.modiDate=modiDate;
        this.opPerson=opPerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModiDate() {
        return modiDate;
    }

    public void setModiDate(String modiDate) {
        this.modiDate = modiDate;
    }

    public String getOpPerson() {
        return opPerson;
    }

    public void setOpPerson(String opPerson) {
        this.opPerson = opPerson;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
