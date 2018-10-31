package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

public class FunctionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String funcName, funcReformContent, desiPerson, devPerson, testPerson, createUser, funcStatus;
	private Date createDate, modiDate;
	private int isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuncReformContent() {
		return funcReformContent;
	}

	public void setFuncReformContent(String funcReformContent) {
		this.funcReformContent = funcReformContent;
	}

	public String getDesiPerson() {
		return desiPerson;
	}

	public void setDesiPerson(String desiPerson) {
		this.desiPerson = desiPerson;
	}

	public String getDevPerson() {
		return devPerson;
	}

	public void setDevPerson(String devPerson) {
		this.devPerson = devPerson;
	}

	public String getTestPerson() {
		return testPerson;
	}

	public void setTestPerson(String testPerson) {
		this.testPerson = testPerson;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getFuncStatus() {
		return funcStatus;
	}

	public void setFuncStatus(String funcStatus) {
		this.funcStatus = funcStatus;
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

	public FunctionEntity(String funcName, String funcReformContent, String desiPerson, String devPerson,
			String testPerson, String createUser, String funcStatus, Date createDate, Date modiDate) {
		this.funcName = funcName;
		this.funcReformContent = funcReformContent;
		this.desiPerson = desiPerson;
		this.devPerson = devPerson;
		this.testPerson = testPerson;
		this.createUser = createUser;
		this.funcStatus = funcStatus;
		this.createDate = createDate;
		this.modiDate = modiDate;
	}

	public FunctionEntity() {
	}

}
