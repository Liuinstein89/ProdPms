package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class DmdQueryParamsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long reqNo;
	private String reqName, reqSource, dept, execType, leadTeam, nextUser, reqStatus;
	private Date beginDate, endDate;

	public Long getReqNo() {
		return reqNo;
	}

	public void setReqNo(Long reqNo) {
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

	public String getNextUser() {
		return nextUser;
	}

	public void setNextUser(String nextUser) {
		this.nextUser = nextUser;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
