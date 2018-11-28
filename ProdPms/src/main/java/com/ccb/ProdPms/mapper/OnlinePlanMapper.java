package com.ccb.ProdPms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccb.ProdPms.entity.OnlinePlanEntity;
import com.ccb.ProdPms.entity.OnlinePlanFuncEntity;

public interface OnlinePlanMapper {

	List<OnlinePlanEntity> getAll();

	List<OnlinePlanEntity> getByParams(@Param("reqName") String reqName,
			@Param("onlineDatetime") String onlineDatetime);

	OnlinePlanEntity findOne(Integer id);

	void deleteOpById(Integer id);

	OnlinePlanEntity hasOp(@Param("reqNo")String reqNo, @Param("onlinePlanName")String onlinePlanName);

	void insertOnlinePlan(OnlinePlanEntity opEntity);

	void insertOpFunc(OnlinePlanFuncEntity opFuncEntity);

	void updateOnlinePlan(OnlinePlanEntity opEntity);

	void deleteOpFuncById(int intValue);

}
