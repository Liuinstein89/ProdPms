package com.ccb.ProdPms.service.impl;

import com.ccb.ProdPms.entity.ReqSourceEntity;
import com.ccb.ProdPms.exception.ResourceNotFoundException;
import com.ccb.ProdPms.mapper.ReqSourceMapper;
import com.ccb.ProdPms.service.ReqSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReqSourceServiceImpl  implements ReqSourceService {


    @Autowired
    private ReqSourceMapper reqSourceMapper;

    public List<ReqSourceEntity> getAll(){
        List<ReqSourceEntity> reqtList = new ArrayList<ReqSourceEntity>();
        try {
            reqtList = reqSourceMapper.getAll();
        } catch (Exception e) {
            e.getMessage();
        }
        return reqtList;
    }

    public void updateReqSource(ReqSourceEntity reqSourceEntity){
        reqSourceMapper.updateReqSource(reqSourceEntity);
    }


    public void deleteById(Integer id){
        ReqSourceEntity reqSourceEntity = reqSourceMapper.findOne(id);
        if (reqSourceEntity == null) {
            throw new ResourceNotFoundException("找不到关键词，id：" + id);
        }
        try {
            reqSourceMapper.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void insertReqSource(ReqSourceEntity reqSourceEntity){
        reqSourceMapper.insertReqSource(reqSourceEntity);
    }

    public int findByName(String souceName){
        int count = reqSourceMapper.findByName(souceName);
        return count;
    }

    public void updateExcelReqSource(ReqSourceEntity reqSourceEntity2){
        reqSourceMapper.updateExcelReqSource(reqSourceEntity2);
    }
}
