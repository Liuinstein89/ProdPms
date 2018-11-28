package com.ccb.ProdPms.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccb.ProdPms.dto.OnlinePlanFuncDto;
import com.ccb.ProdPms.entity.OnlinePlanEntity;
import com.ccb.ProdPms.entity.OnlinePlanFuncEntity;
import com.ccb.ProdPms.exception.ResourceNotFoundException;
import com.ccb.ProdPms.mapper.DmdManageMapper;
import com.ccb.ProdPms.mapper.OnlinePlanMapper;
import com.ccb.ProdPms.service.OnlinePlanService;

@Service
public class OnlinePlanServiceImpl implements OnlinePlanService {
	@Autowired
	OnlinePlanMapper onlinePlanMapper;
	@Autowired
	DmdManageMapper dmdManageMapper;

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

	@Override
	public List<OnlinePlanEntity> getByParams(String reqName, String onlineDatetime) {
		List<OnlinePlanEntity> opList = new ArrayList<OnlinePlanEntity>();
		try {
			opList = onlinePlanMapper.getByParams(reqName, onlineDatetime);
		} catch (Exception e) {
			e.getMessage();
		}
		return opList;
	}

	@Override
	public void deleteOnlinePlanById(Integer id) {
		OnlinePlanEntity opEntity = onlinePlanMapper.findOne(id);
		if (opEntity == null) {
			throw new ResourceNotFoundException("找不到关键词，id：" + id);
		}
		try {
			onlinePlanMapper.deleteOpById(id);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void insertOp(OnlinePlanFuncDto opFuncDto) {
		String reqNo = opFuncDto.getReqNo();
		String reqName = opFuncDto.getReqName();
		String onlinePlanName = opFuncDto.getOnlinePlanName();
		String onlinePlanDesc = opFuncDto.getOnlinePlanDesc();
		String onlineDatetime = opFuncDto.getOnlineDatetime();
		String devNo = opFuncDto.getDevNo();
		String onlinePlanStatus = opFuncDto.getOnlinePlanStatus();
		String funcItem = opFuncDto.getFuncItem();
		String opPerson = opFuncDto.getOpPerson();
		//String modiDate = opFuncDto.getModiDate();
		String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		List<Long> lis = opFuncDto.getFuncId();
		OnlinePlanEntity op = onlinePlanMapper.hasOp(reqNo, onlinePlanName);
		OnlinePlanEntity opEntity = new OnlinePlanEntity(reqNo, onlinePlanDesc, opPerson, onlinePlanName, devNo,
				onlinePlanStatus, funcItem, onlineDatetime, createDate, reqName);
		opEntity.setReqName(reqName);
		if (op == null) {
			String tableName = "online_plan";
			dmdManageMapper.alterTableAutoIncre(tableName);
			onlinePlanMapper.insertOnlinePlan(opEntity);
			if (lis!=null) {
				Long online_plan_id = opEntity.getId();
				OnlinePlanFuncEntity opFuncEntity = new OnlinePlanFuncEntity();
				tableName = "online_func";
				dmdManageMapper.alterTableAutoIncre(tableName);
				for (Long func_id : lis) {
					opFuncEntity.setFuncId(func_id);
					opFuncEntity.setOlplanId(online_plan_id);
					opFuncEntity.setOpPerson(opPerson);
					opFuncEntity.setCreateDate(createDate);
					opFuncEntity.setIsDeleted(0);
					onlinePlanMapper.insertOpFunc(opFuncEntity);
				}
			}
		} else {
			Long id = op.getId();
			opEntity.setId(id);
			onlinePlanMapper.updateOnlinePlan(opEntity);
			if (lis!=null) {
				//Long id = op.getId();
				onlinePlanMapper.deleteOpFuncById(id.intValue());
				String tableName = "online_func";
				dmdManageMapper.alterTableAutoIncre(tableName);
				OnlinePlanFuncEntity opFuncEntity = new OnlinePlanFuncEntity();
				for (Long func_id : lis) {
					opFuncEntity.setFuncId(func_id);
					opFuncEntity.setOlplanId(id);
					opFuncEntity.setOpPerson(opPerson);
					opFuncEntity.setCreateDate(createDate);
					opFuncEntity.setIsDeleted(0);
					onlinePlanMapper.insertOpFunc(opFuncEntity);
				}
			}
		}
	}

	
	/*
	 * @Transactional(propagation = Propagation.REQUIRED, isolation =
	 * Isolation.DEFAULT, readOnly = false) public void insertFunc(FunctionEntity
	 * functionEntity) { String tableName = "func";
	 * dmdManageMapper.alterTableAutoIncre(tableName);
	 * funcMapper.insertFunc(functionEntity); }
	 * 
	 * @Transactional public void updateExcelFunc(FunctionEntity functionEntity2) {
	 * funcMapper.updateExcelFunc(functionEntity2); }
	 * 
	 * 
	 * @Transactional public void updateFunc(FunctionEntity functionEntity) {
	 * funcMapper.updateFunc(functionEntity); }
	 * 
	 * @Transactional public void deleteFuncById(Integer id) { FunctionEntity
	 * functionEntity = funcMapper.findOne(id); if (functionEntity == null) { throw
	 * new ResourceNotFoundException("找不到关键词，id：" + id); } try {
	 * funcMapper.deleteById(id); } catch (Exception e) { e.getMessage(); } }
	 */

}
