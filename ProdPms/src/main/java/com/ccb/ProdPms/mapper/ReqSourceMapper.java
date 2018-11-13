package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.ReqSourceEntity;

import java.util.List;

public interface ReqSourceMapper {


    /**
     * 列出需求来源列表
     *
     * @return reqSourceList
     */
    List<ReqSourceEntity> queryReqSource();

    /**
     * 根据Id列出具体需求来源
     *
     * @return reqSource
     */
    ReqSourceEntity queryReqSourceById(int id);

    /**
     * 插入需求来源信息
     *
     * @param reqSource
     * @return
     */
    int insertReqSource(ReqSourceEntity reqSource);

    /**
     * 更新需求来源信息
     *
     * @param reqSource
     * @return
     */
    int updateReqSource(ReqSourceEntity reqSource);

    /**
     * 删除需求来源信息
     *
     * @param id
     * @return
     */
    int deleteReqSource(int id);
}