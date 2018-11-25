package com.ccb.ProdPms.entity;

public class StateQueryEntity {
    private static final long serialVersionUID = 1L;

    private String id;
    private String stateType, stateName, beginDate, endDate, opPerson;


    public StateQueryEntity(String id, String stateType, String stateName,
                            String beginDate, String  endDate, String opPerson){
        this.id=id;
        this.stateName=stateName;
        this.stateType=stateType;
        this.opPerson=opPerson;
        this.beginDate=beginDate;
        this.endDate=endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOpPerson() {
        return opPerson;
    }

    public void setOpPerson(String opPerson) {
        this.opPerson = opPerson;
    }
}
