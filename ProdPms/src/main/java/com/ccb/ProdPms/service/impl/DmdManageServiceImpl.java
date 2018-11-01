package com.ccb.ProdPms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ccb.ProdPms.dto.DmdItemFuncDto;
import com.ccb.ProdPms.dto.OnlinePlanFuncDto;
import com.ccb.ProdPms.entity.DmdItemEntity;
import com.ccb.ProdPms.entity.DmdItemFuncEntity;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.UploadFileEntity;
import com.ccb.ProdPms.mapper.DmdManageMapper;
import com.ccb.ProdPms.service.DmdManageService;

/*因为一个Service完成一个服务，但是可能会调用很多个DAO层的功能，如果Transaction放在DAO层的话，做完一个DAO，就会提交一次事务，永久修改数据库，后面在调用另外一个DAO，
但是throws Exception，对于整个的Service来说，应该是要完全回滚的，但是只能回滚到当前的DAO所以这就破坏了事务的ＡＣＩＤ;有一些项目的事务是在Controller层。*/
//一般类上这么写: @Transactional(readOnly=true) 配置事务 查询使用 只读
//方法的写法 (增删改要写 ReadOnly=false 为可写 针对增删改操作)@Transactional (propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false)
//Propagation.REQUIRED ：有事务就处于当前事务中，没事务就创建一个事务;isolation=Isolation.DEFAULT：事务数据库的默认隔离级别
@Service
public class DmdManageServiceImpl implements DmdManageService {
	@Autowired
	private DmdManageMapper dmdManageMapper;
	/*
	 * public List<KeywordReply> getAllKeywordRules() { return
	 * keywordReplyRepo.findAll(); }
	 */

	/*
	 * public void deleteKeywordRule(String keywordReplyId) { KeywordReply
	 * keywordReply = keywordReplyRepo.findOne(keywordReplyId); if (keywordReply ==
	 * null) { throw new ResourceNotFoundException("找不到关键词，id：" + keywordReplyId); }
	 * keywordReplyRepo.delete(keywordReplyId); }
	 */

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	// public void addKeywordRule(KeywordRuleDto rule)
	public void addReq(DmdManageEntity dmdManageEntity) {
		// DmdManageEntity dmdManageEntity = new DmdManageEntity();
		// dmdManageEntity.setRuleName(rule.getRuleName());
		// dmdManageEntity.setKeywords(rule.getKeywords());
		// dmdManageEntity.setReplyAll(rule.isReplyAll());
		// addOrUpdateReplyMsgs(keywordReply, rule.getReplyMsgs());
		// DmdManageEntity dmdManageEntity = new DmdManageEntity("", "", "", "", "", "",
		// "", "", "", "", "", 0);
		dmdManageMapper.insert(dmdManageEntity);
		//System.out.println("##########################");
		// BeanUtils.copyProperties(source, target);
		// return dmdManageEntity;
	}

	@Transactional
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
		//System.out.println(itemEntity.toString());
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
				//System.out.println(req_item_id + "^^^^^^^^^^^^^^^^^^^^^^^^^" + list.toString());
				DmdItemFuncEntity dmdItemFuncEntity = new DmdItemFuncEntity();
				for (Long func_id : list) {
					dmdItemFuncEntity.setFuncId(func_id);
					dmdItemFuncEntity.setReqitemId(req_item_id);
					dmdItemFuncEntity.setOpPerson(opPerson);
					dmdItemFuncEntity.setCreateTime(createDate);
					dmdItemFuncEntity.setIsDeleted(0);
					//System.out.println("%%%%%%%%%%%" + dmdItemFuncEntity.toString());
					dmdManageMapper.insertDmdItemFunc(dmdItemFuncEntity);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	@Transactional
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

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	public void insertOnlinePlan(OnlinePlanFuncDto onlinePlanFuncDto) {

	}

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
