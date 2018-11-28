package com.ccb.ProdPms.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class OnlinePlanFuncEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id, olplanId, funcId;
	private String opPerson, createDate, modiDate;
	private int isDeleted;
	
}
