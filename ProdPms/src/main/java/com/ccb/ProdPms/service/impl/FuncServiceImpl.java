package com.ccb.ProdPms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccb.ProdPms.entity.FunctionEntity;
import com.ccb.ProdPms.exception.ResourceNotFoundException;
import com.ccb.ProdPms.mapper.DmdManageMapper;
import com.ccb.ProdPms.mapper.FuncMapper;
import com.ccb.ProdPms.service.FuncService;

@Service
public class FuncServiceImpl implements FuncService {
	@Autowired
	FuncMapper funcMapper;

	@Autowired
	private DmdManageMapper dmdManageMapper;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
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

	@Override
	public List<FunctionEntity> getByParams(FunctionEntity functionEntity) {
		// TODO Auto-generated method stub
		return null;
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
	}

	@Override
	public int findByName(String funcName) {
		int count = funcMapper.findByName(funcName);
		return count;
	}

}
