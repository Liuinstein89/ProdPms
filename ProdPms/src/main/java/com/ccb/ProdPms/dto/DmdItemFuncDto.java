package com.ccb.ProdPms.dto;

import java.util.List;

import lombok.Data;

@Data
public class DmdItemFuncDto {
	private Long id;
	private String reqNo, reqItemDesc, opPerson, reqItemName, reqItemDev, reqItemStatus;
	private String onlineDatetime, createDate, modiDate;
	private int isDeleted;
	private List<Long> funcId;

	public DmdItemFuncDto(String reqNo, String reqItemDesc, String opPerson, String reqItemName, String reqItemDev,
			String reqItemStatus, String onlineDatetime, String createDate, int isDeleted, List<Long> funcId) {
		this.reqNo = reqNo;
		this.reqItemDesc = reqItemDesc;
		this.opPerson = opPerson;
		this.reqItemName = reqItemName;
		this.reqItemDev = reqItemDev;
		this.reqItemStatus = reqItemStatus;
		this.onlineDatetime = onlineDatetime;
		this.createDate = createDate;
		this.isDeleted = isDeleted;
		this.funcId = funcId;
	}

	public DmdItemFuncDto() {
	}

}
