package com.ccb.ProdPms.entity;

public class ExecQueryEntity {
    private static final long serialVersionUID = 1L;

    private String id;
    private String typeName, beginTime, endTime, opPerson;

    public ExecQueryEntity(String id, String typeName, String beginTime, String endTime,String opPerson){
        this.beginTime=beginTime;
        this.endTime=endTime;
        this.id=id;
        this.typeName=typeName;
        this.opPerson=opPerson;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOpPerson() {
        return opPerson;
    }

    public void setOpPerson(String opPerson) {
        this.opPerson = opPerson;
    }
}

