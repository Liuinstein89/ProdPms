package com.ccb.ProdPms.entity;

import java.io.Serializable;

import lombok.Data;

@Data

public class OnlinePlanEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String reqNo, onlinePlanDesc, opPerson, onlinePlanName, devNo, onlinePlanStatus, funcItem,reqName;
	private String onlineDatetime, createDate, modiDate;
	private int isDeleted;

	public OnlinePlanEntity(String reqNo, String onlinePlanDesc, String opPerson, String onlinePlanName, String devNo,
			String onlinePlanStatus, String funcItem, String onlineDatetime, String createDate, String modiDate) {
		this.reqNo = reqNo;
		this.onlinePlanDesc = onlinePlanDesc;
		this.opPerson = opPerson;
		this.onlinePlanName = onlinePlanName;
		this.devNo = devNo;
		this.onlinePlanStatus = onlinePlanStatus;
		this.funcItem = funcItem;
		this.onlineDatetime = onlineDatetime;
		this.createDate = createDate;
		this.modiDate = modiDate;
	}

	public OnlinePlanEntity() {
	}

}
