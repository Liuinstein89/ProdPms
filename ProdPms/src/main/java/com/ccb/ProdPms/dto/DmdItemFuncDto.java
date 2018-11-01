package com.ccb.ProdPms.dto;

import java.util.List;

import lombok.Data;

@Data
public class DmdItemFuncDto {

	private String reqNo, reqItemDesc, opPerson, reqItemName, reqItemDev, reqItemStatus;
	private String onlineDatetime, createDate, modiDate;
	private int isDeleted, hasFunc;
	private List<Long> funcId;

	public DmdItemFuncDto(String reqNo, String reqItemDesc, String opPerson, String reqItemName, String reqItemDev,
			String reqItemStatus, String onlineDatetime, String createDate, int isDeleted, int hasFunc,
			List<Long> funcId) {
		this.reqNo = reqNo;
		this.reqItemDesc = reqItemDesc;
		this.opPerson = opPerson;
		this.reqItemName = reqItemName;
		this.reqItemDev = reqItemDev;
		this.reqItemStatus = reqItemStatus;
		this.onlineDatetime = onlineDatetime;
		this.createDate = createDate;
		this.isDeleted = isDeleted;
		this.hasFunc = hasFunc;
		this.funcId = funcId;
	}

}
