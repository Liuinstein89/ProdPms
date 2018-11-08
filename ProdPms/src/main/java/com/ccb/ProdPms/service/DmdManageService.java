package com.ccb.ProdPms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccb.ProdPms.dto.DmdItemFuncDto;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.UploadFileEntity;

@Service
public interface DmdManageService {

	void addReq(DmdManageEntity dmdManageEntity);

	void insertUpload(UploadFileEntity uploadFileEntity);

	void insertDmdItem(DmdItemFuncDto dmdItemFuncDto);

	String getReqNo();

	List<DmdManageEntity> getAll();

}
