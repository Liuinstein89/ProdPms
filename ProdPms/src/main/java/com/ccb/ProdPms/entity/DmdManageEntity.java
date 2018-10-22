package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class DmdManageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String reqNo;
    private String reqName, reqSource, dept, execType, leadTeam, cooTeam, nowUser, nextUser, createUser, reqStatus;
    private Date createDate, modiDate;
    private int isDeleted;

    public DmdManageEntity(String reqNo, String reqName, String reqSource, String dept, String execType, String leadTeam,
			String cooTeam, String nowUser, String nextUser, String createUser, String reqStatus, int isDeleted) {
		super();
		this.reqNo = reqNo;
		this.reqName = reqName;
		this.reqSource = reqSource;
		this.dept = dept;
		this.execType = execType;
		this.leadTeam = leadTeam;
		this.cooTeam = cooTeam;
		this.nowUser = nowUser;
		this.nextUser = nextUser;
		this.createUser = createUser;
		this.reqStatus = reqStatus;
		this.isDeleted = isDeleted;
	}

	@Override
    public String toString() {
        return "DmdManageEntity{" +
                "id=" + id +
                ", reqNo=" + reqNo +
                ", reqName='" + reqName + '\'' +
                ", reqSource='" + reqSource + '\'' +
                ", dept='" + dept + '\'' +
                ", execType='" + execType + '\'' +
                ", leadTeam='" + leadTeam + '\'' +
                ", cooTeam='" + cooTeam + '\'' +
                ", nowUser='" + nowUser + '\'' +
                ", nextUser='" + nextUser + '\'' +
                ", createUesr='" + createUser + '\'' +
                ", reqStatus='" + reqStatus + '\'' +
                ", createDate=" + createDate +
                ", modiDate=" + modiDate +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getReqNo() {
		return reqNo;
	}

	public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public String getReqSource() {
        return reqSource;
    }

    public void setReqSource(String reqSource) {
        this.reqSource = reqSource;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    public String getLeadTeam() {
        return leadTeam;
    }

    public void setLeadTeam(String leadTeam) {
        this.leadTeam = leadTeam;
    }

    public String getCooTeam() {
        return cooTeam;
    }

    public void setCooTeam(String cooTeam) {
        this.cooTeam = cooTeam;
    }

    public String getNowUser() {
        return nowUser;
    }

    public void setNowUser(String nowUser) {
        this.nowUser = nowUser;
    }

    public String getNextUser() {
        return nextUser;
    }

    public void setNextUser(String nextUser) {
        this.nextUser = nextUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
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

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}

