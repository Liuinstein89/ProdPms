package com.ccb.ProdPms.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class DmdItemFuncEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id, reqitemId, funcId;
	private String opPerson, createDate, modiDate;
	private int isDeleted;
	public DmdItemFuncEntity(Long reqitemId, Long funcId, String opPerson, String createDate, 
			int isDeleted) {
		this.reqitemId = reqitemId;
		this.funcId = funcId;
		this.opPerson = opPerson;
		this.createDate = createDate;
		this.isDeleted = isDeleted;
	}
	public DmdItemFuncEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
