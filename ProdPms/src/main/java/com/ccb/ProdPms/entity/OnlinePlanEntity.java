package com.ccb.ProdPms.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class OnlinePlanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String reqNo, onlinePlanDesc, opPerson, onlinePlanName, DevNo, onlinePlanStatus,funcItem;
	private String onlineDatetime, createDate, changeDate;
	private int isDeleted, hasFunc;

}
