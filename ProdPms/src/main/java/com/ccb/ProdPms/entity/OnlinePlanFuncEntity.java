package com.ccb.ProdPms.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class OnlinePlanFuncEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id, onlinePlanId, funcId;
	private String opPerson, createTime, changeTime;
	private int isDeleted;
	/*
	 * public OnlinePlanFuncEntity(Long onlinePlanId, Long funcId, String opPerson,
	 * String createTime, int isDeleted) { this.onlinePlanId = onlinePlanId;
	 * this.funcId = funcId; this.opPerson = opPerson; this.createTime = createTime;
	 * this.isDeleted = isDeleted; }
	 */
}
