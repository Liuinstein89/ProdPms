package com.ccb.ProdPms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccb.ProdPms.entity.FunctionEntity;

@Service
public interface FuncService {

	void addFunc(FunctionEntity functionEntity);

	void insertFuncExcel(FunctionEntity functionEntity);

	List<FunctionEntity> getAll();

	List<FunctionEntity> getByParams(FunctionEntity functionEntity);

	void updateFunc(FunctionEntity functionEntity);

	void deleteFuncById(Integer id);

}
