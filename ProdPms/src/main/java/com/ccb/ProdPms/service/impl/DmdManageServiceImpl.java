package com.ccb.ProdPms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ccb.ProdPms.dto.DmdItemFuncDto;
import com.ccb.ProdPms.entity.AuditResultEntity;
import com.ccb.ProdPms.entity.DmdItemEntity;
import com.ccb.ProdPms.entity.DmdItemFuncEntity;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.DmdQueryParamsEntity;
import com.ccb.ProdPms.entity.UploadFileEntity;
import com.ccb.ProdPms.entity.UserEntity;
import com.ccb.ProdPms.exception.ResourceNotFoundException;
import com.ccb.ProdPms.mapper.DmdManageMapper;
import com.ccb.ProdPms.mapper.UserMapper;
import com.ccb.ProdPms.service.DmdManageService;

import lombok.extern.slf4j.Slf4j;

/*因为一个Service完成一个服务，但是可能会调用很多个DAO层的功能，如果Transaction放在DAO层的话，做完一个DAO，就会提交一次事务，永久修改数据库，后面在调用另外一个DAO，
但是throws Exception，对于整个的Service来说，应该是要完全回滚的，但是只能回滚到当前的DAO所以这就破坏了事务的ＡＣＩＤ;有一些项目的事务是在Controller层。*/
//一般类上这么写: @Transactional(readOnly=true) 配置事务 查询使用 只读,查询相关的业务，尽量别加事物，影响效率，而只在事务内进行增、删、改、加锁查询等操作。
//方法的写法 (增删改要写 ReadOnly=false 为可写 针对增删改操作)@Transactional (propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false)
//Propagation.REQUIRED ：有事务就处于当前事务中，没事务就创建一个事务;isolation=Isolation.DEFAULT：事务数据库的默认隔离级别
@Service
@Slf4j
public class DmdManageServiceImpl implements DmdManageService {
	@Autowired
	private DmdManageMapper dmdManageMapper;
	@Autowired
	private UserMapper userMapper;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void addReq(DmdManageEntity dmdManageEntity) {
		dmdManageMapper.insert(dmdManageEntity);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void insertUpload(UploadFileEntity uploadFileEntity) {
		dmdManageMapper.insertUpload(uploadFileEntity);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void insertDmdItem(DmdItemFuncDto dmdItemFuncDto) {
		String reqNo = dmdItemFuncDto.getReqNo();
		String reqItemDesc = dmdItemFuncDto.getReqItemDesc();
		String opPerson = dmdItemFuncDto.getOpPerson();
		String modiDate = dmdItemFuncDto.getModiDate();
		String onlineDatetime = dmdItemFuncDto.getOnlineDatetime();
		String reqItemDev = dmdItemFuncDto.getReqItemDev();
		String reqItemName = dmdItemFuncDto.getReqItemName();
		String reqItemStatus = dmdItemFuncDto.getReqItemStatus();
		String createDate = dmdItemFuncDto.getCreateDate();
		int hasFunc = dmdItemFuncDto.getHasFunc();
		DmdItemEntity itemEntity = new DmdItemEntity(reqNo, reqItemDesc, opPerson, reqItemName, reqItemDev,
				reqItemStatus, onlineDatetime, createDate, modiDate, 0, hasFunc);
		// System.out.println(itemEntity.toString());
		if (hasFunc == 0) {
			try {
				dmdManageMapper.insertDmdItem(itemEntity);
			} catch (Exception e) {
				e.getMessage();
			}
		} else {
			try {
				dmdManageMapper.insertDmdItem(itemEntity);
				Long req_item_id = itemEntity.getId();
				List<Long> list = dmdItemFuncDto.getFuncId();
				// System.out.println(req_item_id + "^^^^^^^^^^^^^^^^^^^^^^^^^" +
				// list.toString());
				DmdItemFuncEntity dmdItemFuncEntity = new DmdItemFuncEntity();
				for (Long func_id : list) {
					dmdItemFuncEntity.setFuncId(func_id);
					dmdItemFuncEntity.setReqitemId(req_item_id);
					dmdItemFuncEntity.setOpPerson(opPerson);
					dmdItemFuncEntity.setCreateTime(createDate);
					dmdItemFuncEntity.setIsDeleted(0);
					dmdManageMapper.insertDmdItemFunc(dmdItemFuncEntity);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	public String getReqNo() {
		String reqNo = null;
		try {
			reqNo = String.valueOf(dmdManageMapper.getLastId());
			if (StringUtils.isEmpty(reqNo))
				return "0";
		} catch (Exception e) {
			e.getMessage();
			return "获取id出错";
		}
		return reqNo;
	}

	@Override
	public List<DmdManageEntity> getAll() {
		List<DmdManageEntity> dmdList = new ArrayList<DmdManageEntity>();
		try {
			dmdList = dmdManageMapper.getAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return dmdList;
	}

	@Override
	public List<DmdManageEntity> getByParams(DmdQueryParamsEntity queryParams) {
		List<DmdManageEntity> dsList = new ArrayList<DmdManageEntity>();
		try {
			dsList = dmdManageMapper.getByParams(queryParams);
		} catch (Exception e) {
			e.getMessage();
		}
		return dsList;
	}

	@Transactional
	public void updateReq(DmdManageEntity dmdManageEntity) {
		dmdManageMapper.updateReq(dmdManageEntity);

	}

	@Transactional
	public void deleteReqById(Integer id) {
		DmdManageEntity dmdManageEntity = dmdManageMapper.findOne(id);
		if (dmdManageEntity == null) {
			throw new ResourceNotFoundException("找不到关键词，id：" + id);
		}
		try {
			dmdManageMapper.deleteById(id);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public List<DmdItemEntity> getReqItem(String reqNo) {
		List<DmdItemEntity> dmdItemList = new ArrayList<DmdItemEntity>();
		try {
			dmdItemList = dmdManageMapper.getReqItem(reqNo);
		} catch (Exception e) {
			e.getMessage();
		}
		return dmdItemList;
	}

	@Override
	public List<UploadFileEntity> getRelateFile(String reqNo) {
		List<UploadFileEntity> upList = new ArrayList<UploadFileEntity>();
		try {
			upList = dmdManageMapper.getUploadFileOfReq(reqNo);
		} catch (Exception e) {
			e.getMessage();
		}
		return upList;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void detailInsertUpload(UploadFileEntity uploadFileEntity) {
		dmdManageMapper.detailInsertUpload(uploadFileEntity);
	}

	@Override
	public void deleteUploadById(Integer id) {
		UploadFileEntity UploadFileEntity = dmdManageMapper.findUpload(id);
		if (UploadFileEntity == null) {
			throw new ResourceNotFoundException("找不到关键词，id：" + id);
		}
		try {
			dmdManageMapper.deleteUpById(id);
		} catch (Exception e) {
			e.getMessage();
			log.info("fail to delete file by id:" + id);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void auditSubmitAdd(AuditResultEntity auditResultEntity, String nowUser) {
		String reqStatus = null;
		String comment = null;
		String result = null;
		Date time = null;
		AuditResultEntity ar = new AuditResultEntity();
		UserEntity user = userMapper.getByName(nowUser);
		if ("".equals(user.getUserType()) || user.getUserType() == null) {
			throw new ResourceNotFoundException("找不到该用户" + nowUser + "的类别");
		}
		if ("需求审核通过".equals(auditResultEntity.getResult())) {
			if ("req".equals(user.getUserType())) {
				reqStatus = "需求审核通过";
				comment = auditResultEntity.getComment();
				result = auditResultEntity.getResult();
				time = auditResultEntity.getAuditTime();
			} else if ("dev".equals(user.getUserType())) {
				reqStatus = "同意开发";
				comment = auditResultEntity.getComment();
				result = auditResultEntity.getResult();
				time = auditResultEntity.getAuditTime();
			} else if ("design".equals(user.getUserType())) {
				reqStatus = "设计审核通过";
				comment = auditResultEntity.getComment();
				result = auditResultEntity.getResult();
				time = auditResultEntity.getAuditTime();
			}
			ar.setComment(comment);
			ar.setAuditPerson(nowUser);
			ar.setResult(result);
			ar.setAuditTime(time);
			ar.setReqNo(auditResultEntity.getReqNo());
			ar.setNextUser(auditResultEntity.getNextUser());
			try {
				dmdManageMapper.insertAudit(ar);
				dmdManageMapper.updateReqStatus(reqStatus);
			} catch (Exception e) {
				e.getMessage();
			}
		} else if ("不实施".equals(auditResultEntity.getResult())) {

		} else if ("变更".equals(auditResultEntity.getResult())) {

		}
	}
	/*
	 * DmdManageEntity dmdManageEntity = new DmdManageEntity(reqNo, dept, leadTeam,
	 * reqStatus, nowUser, nextUser, createUser, createDate, "reqAddStatus", 0);
	 */

	/*
	 * @Transactional public KeywordReply updateKeywordRule(KeywordRuleDto rule) {
	 * KeywordReply keywordReply = keywordReplyRepo.findOne(rule.getId());
	 * keywordReply.setRuleName(rule.getRuleName());
	 * keywordReply.setKeywords(rule.getKeywords());
	 * keywordReply.setReplyAll(rule.isReplyAll()); mergeReplyMsgs(keywordReply,
	 * rule.getReplyMsgs()); return keywordReplyRepo.save(keywordReply); } private
	 * void mergeReplyMsgs(KeywordReply keywordReply, List<ReplyMsgDto>
	 * replyMsgDtos) { removeReplyMsgsIfHasRemovedFromDto(keywordReply,
	 * replyMsgDtos); addOrUpdateReplyMsgs(keywordReply, replyMsgDtos); }
	 */

	/*
	 * private void addOrUpdateReplyMsgs(KeywordReply keywordReply,
	 * List<ReplyMsgDto> replyMsgDtos) { Set<ReplyMsg> replyMsgs =
	 * keywordReply.getReplyMsgs(); for (ReplyMsgDto replyMsgDto : replyMsgDtos) {
	 * ReplyMsg msg = null; if (StringUtils.isEmpty(replyMsgDto.getId())) { msg =
	 * new ReplyMsg(); replyMsgs.add(msg); } else { msg =
	 * replyMsgs.stream().filter(m ->
	 * m.getId().equals(replyMsgDto.getId())).findFirst().orElse(msg); }
	 * 
	 * msg.setReplyType(ReplyType.KEYWORD_AUTO_REPLY);
	 * msg.setKeywordReplyId(keywordReply.getId());
	 * msg.setMsgtype(replyMsgDto.getMsgtype());
	 * msg.setContent(replyMsgDto.getContent());
	 * msg.setMediaId(replyMsgDto.getMediaId());
	 * msg.setTitle(replyMsgDto.getTitle());
	 * msg.setDescription(replyMsgDto.getDescription());
	 * msg.setUrl(replyMsgDto.getUrl()); msg.setPicurl(replyMsgDto.getPicurl()); } }
	 */

	/*
	 * private void removeReplyMsgsIfHasRemovedFromDto(KeywordReply keywordReply,
	 * List<ReplyMsgDto> replyMsgDtos) { Set<ReplyMsg> replyMsgs =
	 * keywordReply.getReplyMsgs(); if (!CollectionUtils.isEmpty(replyMsgs)) {
	 * replyMsgs.removeIf(replyMsg -> hasRemovedFromDto(replyMsg.getId(),
	 * replyMsgDtos)); } }
	 */
}
