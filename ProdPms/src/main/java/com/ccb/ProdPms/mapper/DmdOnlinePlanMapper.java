package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.OnlinePlanEntity;
import com.ccb.ProdPms.entity.OnlinePlanFuncEntity;

public interface DmdOnlinePlanMapper {
	void insertOnlinePlan(OnlinePlanEntity olEntity);

	void insertOlFunc(OnlinePlanFuncEntity opfEntity);
}
