package com.ccb.ProdPms.mapper;

import java.util.List;

import com.ccb.ProdPms.entity.FunctionEntity;

public interface FuncMapper {

	List<FunctionEntity> getAll();

	void updateFunc(FunctionEntity functionEntity);

	FunctionEntity findOne(Integer id);

	void deleteById(Integer id);

	void insertFunc(FunctionEntity functionEntity);

	int findByName(String funcName);

	void updateExcelFunc(FunctionEntity functionEntity2);
}
