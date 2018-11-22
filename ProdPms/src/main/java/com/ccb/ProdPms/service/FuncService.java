package com.ccb.ProdPms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccb.ProdPms.entity.FunctionEntity;

@Service
public interface FuncService {

	List<FunctionEntity> getAll();

	void updateFunc(FunctionEntity functionEntity);

	void deleteFuncById(Integer id);

	int findByName(String funcName);

	void insertFunc(FunctionEntity functionEntity);

	void updateExcelFunc(FunctionEntity functionEntity2);

}
