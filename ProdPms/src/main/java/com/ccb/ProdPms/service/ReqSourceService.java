package com.ccb.ProdPms.service;

import com.ccb.ProdPms.entity.ReqSourceEntity;

import java.util.List;

public interface ReqSourceService {

    List<ReqSourceEntity> getAll();

    void updateReqSource(ReqSourceEntity reqSourceEntity);

    void deleteById(Integer id);

    void insertReqSource(ReqSourceEntity reqSourceEntity);

    int findByName(String sourceName);

    void updateExcelReqSource(ReqSourceEntity reqSourceEntity2);


}
