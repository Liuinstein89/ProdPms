package com.ccb.ProdPms.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class FunctionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String funcName, funcReformContent, desiPerson, devPerson, testPerson, createUser, funcStatus, createDate,
			modiDate, onlineDate;
	private int isDeleted;

	public FunctionEntity(String funcName, String funcReformContent, String desiPerson, String devPerson,
			String testPerson, String createUser, String funcStatus, String createDate, String modiDate) {
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
