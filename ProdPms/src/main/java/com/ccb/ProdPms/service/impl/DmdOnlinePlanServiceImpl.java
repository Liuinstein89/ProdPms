package com.ccb.ProdPms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccb.ProdPms.dto.OnlinePlanFuncDto;
import com.ccb.ProdPms.entity.OnlinePlanEntity;
import com.ccb.ProdPms.entity.OnlinePlanFuncEntity;
import com.ccb.ProdPms.mapper.DmdOnlinePlanMapper;
import com.ccb.ProdPms.service.DmdOnlinePlanService;

@Service
public class DmdOnlinePlanServiceImpl implements DmdOnlinePlanService {
	@Autowired
	private DmdOnlinePlanMapper dmdOnlinePlanMapper;

	// 因为初次录入上线计划是没有包括功能点的，功能点在该上线计划时间完结的时候，根据实际情况录入，所以初始化的has_func=0
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void insertOnlinePlan(OnlinePlanEntity olanEntity) {
		String reqNo = olanEntity.getReqNo();
		String opPerson = olanEntity.getOpPerson();
		String onlinePlanStatus = olanEntity.getOnlinePlanStatus();
		String changeDate = olanEntity.getChangeDate();
		String createDate = olanEntity.getCreateDate();
		String devNo = olanEntity.getDevNo();
		String funcItem = olanEntity.getFuncItem();
		String onlineDatetime = olanEntity.getOnlineDatetime();
		String onlinePlanDesc = olanEntity.getOnlinePlanDesc();
		String onlinePlanName = olanEntity.getOnlinePlanName();
		OnlinePlanEntity olEntity = new OnlinePlanEntity(reqNo, onlinePlanDesc, opPerson, onlinePlanName, devNo,
				onlinePlanStatus, funcItem, onlineDatetime, createDate, changeDate);
		try {
			dmdOnlinePlanMapper.insertOnlinePlan(olEntity);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void insertOnlinePlanFunc(OnlinePlanFuncDto opfDto) {
		List<Long> list = opfDto.getFuncId();
		Long online_plan_id = opfDto.getOnlinePlanId();

		OnlinePlanFuncEntity olFEntity = new OnlinePlanFuncEntity();
		for (Long func_id : list) {
			olFEntity.setFuncId(func_id);
			olFEntity.setOnlinePlanId(online_plan_id);
			olFEntity.setOpPerson(opfDto.getOpPerson());
			olFEntity.setCreateTime(opfDto.getCreateTime());
			olFEntity.setChangeTime(opfDto.getChangeTime());
			olFEntity.setIsDeleted(0);
			try {
				dmdOnlinePlanMapper.insertOlFunc(olFEntity);
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}
