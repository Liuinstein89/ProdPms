package com.ccb.ProdPms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ccb.ProdPms.entity.DmdItemEntity;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.UploadFileEntity;
import com.ccb.ProdPms.mapper.DmdManageMapper;
import com.ccb.ProdPms.service.DmdManageService;

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

	@Transactional
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
		// BeanUtils.copyProperties(source, target);
		// return dmdManageEntity;
	}

	@Override
	public void insertUpload(UploadFileEntity uploadFileEntity) {
		dmdManageMapper.insertUpload(uploadFileEntity);
	}

	@Override
	public void insertDmdItem(DmdItemEntity dmdItemEntity) {
		String reqNo = dmdItemEntity.getReqNo();
		String reqitemDesc = dmdItemEntity.getReqitemDesc();
		String opPerson = dmdItemEntity.getOpPerson();
		Date modiDate = dmdItemEntity.getModiDate();
		Date onlineDatetime = dmdItemEntity.getOnlineDatetime();
		String reqItemDev = dmdItemEntity.getReqItemDev();
		String reqItemName = dmdItemEntity.getReqItemName();
		String reqItemStatus = dmdItemEntity.getReqItemStatus();
		Date createDate = dmdItemEntity.getCreateDate();
				//new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(createDate);
		DmdItemEntity itemEntity = new DmdItemEntity(reqNo, reqitemDesc, opPerson, reqItemName, reqItemDev,reqItemStatus,
				createDate, modiDate, onlineDatetime,0);
		System.out.println(itemEntity.toString());
		try {
			System.out.println("@@@@@@@@@@@@@");
			dmdManageMapper.insertDmdItem(itemEntity);
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
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
