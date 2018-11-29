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

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
		String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		List<Long> lis = opFuncDto.getFuncId();
		OnlinePlanEntity op = onlinePlanMapper.hasOp(reqNo, onlinePlanName);
		OnlinePlanEntity opEntity = new OnlinePlanEntity(reqNo, onlinePlanDesc, opPerson, onlinePlanName, devNo,
				onlinePlanStatus, funcItem, onlineDatetime, createDate, reqName);
		opEntity.setReqName(reqName);
		log.info(lis + "---" + lis.size());
		if (op == null) {
			String tableName = "online_plan";
			dmdManageMapper.alterTableAutoIncre(tableName);
			onlinePlanMapper.insertOnlinePlan(opEntity);
			if (lis.size() != 0) {
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
			if (lis.size() != 0) {
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

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void updateOnlinePlan(OnlinePlanFuncDto onlinePlanFuncDto) {
		Long id = onlinePlanFuncDto.getId();
		String reqNo = onlinePlanFuncDto.getReqNo();
		String reqName = onlinePlanFuncDto.getReqName();
		String onlinePlanName = onlinePlanFuncDto.getOnlinePlanName();
		String onlinePlanDesc = onlinePlanFuncDto.getOnlinePlanDesc();
		String onlineDatetime = onlinePlanFuncDto.getOnlineDatetime();
		String devNo = onlinePlanFuncDto.getDevNo();
		String onlinePlanStatus = onlinePlanFuncDto.getOnlinePlanStatus();
		String funcItem = onlinePlanFuncDto.getFuncItem();
		String opPerson = onlinePlanFuncDto.getOpPerson();
		List<Long> lis = onlinePlanFuncDto.getFuncId();
		OnlinePlanEntity opEntity = new OnlinePlanEntity(id, reqNo, onlinePlanDesc, opPerson, onlinePlanName, devNo,
				onlinePlanStatus, funcItem, onlineDatetime, reqName);
		opEntity.setReqName(reqName);
		
		log.info(lis + "---" + lis.size());
		onlinePlanMapper.updateOnlinePlan(opEntity);
		if (lis.size() != 0) {
			onlinePlanMapper.deleteOpFuncById(id.intValue());
			String tableName = "online_func";
			dmdManageMapper.alterTableAutoIncre(tableName);
			OnlinePlanFuncEntity opFuncEntity = new OnlinePlanFuncEntity();
			for (Long func_id : lis) {
				opFuncEntity.setFuncId(func_id);
				opFuncEntity.setOlplanId(id);
				opFuncEntity.setOpPerson(opPerson);
				opFuncEntity.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				opFuncEntity.setIsDeleted(0);
				onlinePlanMapper.insertOpFunc(opFuncEntity);
			}
		}
	}

	@Override
	public int findSame(OnlinePlanFuncDto onlinePlanFuncDto) {
		Long id = onlinePlanFuncDto.getId();
		String reqNo = onlinePlanFuncDto.getReqNo();
		String onlinePlanName = onlinePlanFuncDto.getOnlinePlanName();
		int count = onlinePlanMapper.countOp(id.intValue(),reqNo, onlinePlanName);
		return count;
	}
}
