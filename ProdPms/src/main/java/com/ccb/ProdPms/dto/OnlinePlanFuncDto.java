package com.ccb.ProdPms.dto;

import java.util.List;

import com.ccb.ProdPms.entity.OnlinePlanEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OnlinePlanFuncDto extends OnlinePlanEntity {

	private static final long serialVersionUID = 1L;
	private List<Long> funcId;
}
