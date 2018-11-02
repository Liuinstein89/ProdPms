package com.ccb.ProdPms.dto;

import java.util.List;

import lombok.Data;

@Data
public class OnlinePlanFuncDto {
	private String opPerson, createTime, changeTime;
	private int isDeleted;
	private Long onlinePlanId;
	private List<Long> funcId;
}
