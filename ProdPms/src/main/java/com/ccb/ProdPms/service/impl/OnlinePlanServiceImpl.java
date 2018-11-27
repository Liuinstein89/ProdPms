package com.ccb.ProdPms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccb.ProdPms.entity.OnlinePlanEntity;
import com.ccb.ProdPms.mapper.OnlinePlanMapper;
import com.ccb.ProdPms.service.OnlinePlanService;

@Service
public class OnlinePlanServiceImpl implements OnlinePlanService{
	@Autowired
	OnlinePlanMapper onlinePlanMapper;


	@Override
	public List<OnlinePlanEntity> getAll() {
		List<OnlinePlanEntity> opList = new ArrayList<OnlinePlanEntity>();
		try {
			opList = onlinePlanMapper.getAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return opList;
	}

	/*@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void insertFunc(FunctionEntity functionEntity) {
		String tableName = "func";
		dmdManageMapper.alterTableAutoIncre(tableName);
		funcMapper.insertFunc(functionEntity);
	}

	@Transactional
	public void updateExcelFunc(FunctionEntity functionEntity2) {
		funcMapper.updateExcelFunc(functionEntity2);
	}

	@Override
	public List<FunctionEntity> getAll() {
		List<FunctionEntity> funcList = new ArrayList<FunctionEntity>();
		try {
			funcList = funcMapper.getAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return funcList;
	}

	@Transactional
	public void updateFunc(FunctionEntity functionEntity) {
		funcMapper.updateFunc(functionEntity);
	}

	@Transactional
	public void deleteFuncById(Integer id) {
		FunctionEntity functionEntity = funcMapper.findOne(id);
		if (functionEntity == null) {
			throw new ResourceNotFoundException("找不到关键词，id：" + id);
		}
		try {
			funcMapper.deleteById(id);
		} catch (Exception e) {
			e.getMessage();
		}
	}*/

}
