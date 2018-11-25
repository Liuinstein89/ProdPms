package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.ReqSourceEntity;

import java.util.List;

public interface ReqSourceMapper {

    List<ReqSourceEntity> getAll();

    void updateReqSource(ReqSourceEntity reqSourceEntity);

    ReqSourceEntity findOne(Integer id);

    void deleteById(Integer id);

    void insertReqSource(ReqSourceEntity reqSourceEntity);

    int findByName(String reqSourceEntity);

    void updateExcelReqSource(ReqSourceEntity reqSourceEntity2);


}