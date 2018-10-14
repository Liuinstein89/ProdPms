package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class AuditResultEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id, reqId;
    private String reqResult, reqComment, reqPerson, desiResult, desiComment, desiPerson, devResult, devComment, devPerson, nextPerson;
    private Date reqTime, desiTime, devTime;
    private int isDeleted;

    @Override
    public String toString() {
        return "AuditResultEntity{" +
                "id=" + id +
                ", reqId=" + reqId +
                ", reqResult='" + reqResult + '\'' +
                ", reqComment='" + reqComment + '\'' +
                ", reqPerson='" + reqPerson + '\'' +
                ", desiResult='" + desiResult + '\'' +
                ", desiComment='" + desiComment + '\'' +
                ", desiPerson='" + desiPerson + '\'' +
                ", devResult='" + devResult + '\'' +
                ", devComment='" + devComment + '\'' +
                ", devPerson='" + devPerson + '\'' +
                ", nextPerson='" + nextPerson + '\'' +
                ", reqTime=" + reqTime +
                ", desiTime=" + desiTime +
                ", devTime=" + devTime +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public String getReqResult() {
        return reqResult;
    }

    public void setReqResult(String reqResult) {
        this.reqResult = reqResult;
    }

    public String getReqComment() {
        return reqComment;
    }

    public void setReqComment(String reqComment) {
        this.reqComment = reqComment;
    }

    public String getReqPerson() {
        return reqPerson;
    }

    public void setReqPerson(String reqPerson) {
        this.reqPerson = reqPerson;
    }

    public String getDesiResult() {
        return desiResult;
    }

    public void setDesiResult(String desiResult) {
        this.desiResult = desiResult;
    }

    public String getDesiComment() {
        return desiComment;
    }

    public void setDesiComment(String desiComment) {
        this.desiComment = desiComment;
    }

    public String getDesiPerson() {
        return desiPerson;
    }

    public void setDesiPerson(String desiPerson) {
        this.desiPerson = desiPerson;
    }

    public String getDevResult() {
        return devResult;
    }

    public void setDevResult(String devResult) {
        this.devResult = devResult;
    }

    public String getDevComment() {
        return devComment;
    }

    public void setDevComment(String devComment) {
        this.devComment = devComment;
    }

    public String getDevPerson() {
        return devPerson;
    }

    public void setDevPerson(String devPerson) {
        this.devPerson = devPerson;
    }

    public String getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(String nextPerson) {
        this.nextPerson = nextPerson;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public Date getDesiTime() {
        return desiTime;
    }

    public void setDesiTime(Date desiTime) {
        this.desiTime = desiTime;
    }

    public Date getDevTime() {
        return devTime;
    }

    public void setDevTime(Date devTime) {
        this.devTime = devTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
