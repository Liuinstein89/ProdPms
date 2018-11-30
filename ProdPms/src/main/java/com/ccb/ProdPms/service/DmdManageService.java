package com.ccb.ProdPms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccb.ProdPms.dto.DmdItemFuncDto;
import com.ccb.ProdPms.entity.AuditResultEntity;
import com.ccb.ProdPms.entity.DmdItemEntity;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.DmdQueryParamsEntity;
import com.ccb.ProdPms.entity.FunctionEntity;
import com.ccb.ProdPms.entity.UploadFileEntity;

@Service
public interface DmdManageService {

	void addReq(DmdManageEntity dmdManageEntity);

	void insertUpload(UploadFileEntity uploadFileEntity);

	void insertDmdItem(DmdItemFuncDto dmdItemFuncDto);

	String getReqNo();

	List<DmdManageEntity> getAll();

	List<DmdManageEntity> getByParams(DmdQueryParamsEntity dmdQueryParamsEntity);

	void updateReq(DmdManageEntity dmdManageEntity);

	void deleteReqById(Integer id);

	List<DmdItemEntity> getReqItem(String reqNo);

	List<UploadFileEntity> getRelateFile(String reqNo);

	void detailInsertUpload(UploadFileEntity uploadFileEntity);

	void deleteUploadById(Integer id);

	void auditSubmitAdd(AuditResultEntity auditResultEntity, String nowUser);

	List<FunctionEntity> getReqItemFunc(Integer reqItemId);

	void delReqRalateItemById(Integer id);

	void updateDmdItem(DmdItemFuncDto dmdItemFuncDto);

	int findSameReq(String reqName);

	int findSame(DmdItemFuncDto dmdItemFuncDto);

	int findDupReq(String reqNo, String reqName);

	

}
