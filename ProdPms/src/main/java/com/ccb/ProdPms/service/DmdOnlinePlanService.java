package com.ccb.ProdPms.service;

import org.springframework.stereotype.Service;

import com.ccb.ProdPms.dto.OnlinePlanFuncDto;
import com.ccb.ProdPms.entity.OnlinePlanEntity;

@Service
public interface DmdOnlinePlanService {

	void insertOnlinePlan(OnlinePlanEntity olEntity);

	void insertOnlinePlanFunc(OnlinePlanFuncDto opfDto);
}
