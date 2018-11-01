package com.ccb.ProdPms.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class DmdItemFuncEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id, reqitemId, funcId;
	private String opPerson, createTime, changeTime;
	private int isDeleted;
	public DmdItemFuncEntity(Long reqitemId, Long funcId, String opPerson, String createTime, 
			int isDeleted) {
		this.reqitemId = reqitemId;
		this.funcId = funcId;
		this.opPerson = opPerson;
		this.createTime = createTime;
		this.isDeleted = isDeleted;
	}
	public DmdItemFuncEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
