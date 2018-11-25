package com.ccb.ProdPms.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;

public class StateEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String stateType, stateName, opPerson;
    private String createTime, changeTime;
    private int isDeleted;

    public StateEntity(){

    }

    public StateEntity(String stateType, String stateName, String createTime, String changeTime, String opPerson){
        this.stateType=stateType;
        this.stateName=stateName;
        this.opPerson=opPerson;
        this.createTime=createTime;
        this.changeTime=changeTime;
    }

    public StateEntity(Integer id, String stateType, String stateName, String changeTime,String opPerson){
        this.id=id;
        this.stateType=stateType;
        this.stateName=stateName;
        this.changeTime=changeTime;
        this.opPerson=opPerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String toString(){
    return "[The State is: Id="+this.getId()
            +",state_type="+this.getStateType()
            +",state_name="+this.getStateName()
            +",op_person="+this.getOpPerson()+"]";
    }
}
