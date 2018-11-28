package com.ccb.ProdPms.dto;

import java.util.List;

import lombok.Data;

@Data
public class OnlinePlanFuncDto {
	private String reqNo, onlinePlanDesc, opPerson, onlinePlanName, devNo, onlinePlanStatus, funcItem, reqName;
	private String onlineDatetime, createDate, modiDate;
	private int isDeleted;
	private List<Long> funcId;

	public OnlinePlanFuncDto(String reqNo, String onlinePlanDesc, String opPerson, String onlinePlanName, String devNo,
			String onlinePlanStatus, String funcItem, String reqName, String onlineDatetime, String createDate,
			int isDeleted, List<Long> funcId) {
		this.reqNo = reqNo;
		this.onlinePlanDesc = onlinePlanDesc;
		this.opPerson = opPerson;
		this.onlinePlanName = onlinePlanName;
		this.devNo = devNo;
		this.onlinePlanStatus = onlinePlanStatus;
		this.funcItem = funcItem;
		this.reqName = reqName;
		this.onlineDatetime = onlineDatetime;
		this.createDate = createDate;
		this.isDeleted = isDeleted;
		this.funcId = funcId;
	}

	public OnlinePlanFuncDto() {
	}
}
