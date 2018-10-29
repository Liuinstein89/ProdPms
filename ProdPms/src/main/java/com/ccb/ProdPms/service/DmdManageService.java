package com.ccb.ProdPms.service;

import org.springframework.stereotype.Service;

import com.ccb.ProdPms.entity.DmdItemEntity;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.UploadFileEntity;

@Service
public interface DmdManageService {

	void addReq(DmdManageEntity dmdManageEntity);

	void insertUpload(UploadFileEntity uploadFileEntity);
	
	void insertDmdItem(DmdItemEntity dmdItemEntity);

}
