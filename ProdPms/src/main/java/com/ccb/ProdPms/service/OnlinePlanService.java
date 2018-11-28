package com.ccb.ProdPms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccb.ProdPms.dto.OnlinePlanFuncDto;
import com.ccb.ProdPms.entity.OnlinePlanEntity;

@Service
public interface OnlinePlanService {

	List<OnlinePlanEntity> getAll();

	List<OnlinePlanEntity> getByParams(String reqName, String onlineDatetime);

	void deleteOnlinePlanById(Integer id);

	void insertOp(OnlinePlanFuncDto onlinePlanFuncDto);


}
