package com.ccb.ProdPms.service;

import com.ccb.ProdPms.entity.ReqSourceEntity;

import java.util.List;

public interface ReqSourceService {

    /**
     * 获取需求来源列表
     *
     * @return
     */
    List<ReqSourceEntity> getReqSourceList();

    /**
     * 通过Id获取需求来源信息
     *
     * @param id
     * @return
     */
    ReqSourceEntity getReqSourceById(int id);

    /**
     * 增加需求来源信息
     *
     * @param reqSource
     * @return
     */
    boolean addReqSource(ReqSourceEntity reqSource);

    /**
     * 修改需求来源信息
     *
     * @param reqSource
     * @return
     */
    boolean modifyReqSource(ReqSourceEntity reqSource);

    /**
     * 删除需求来源信息
     *
     * @param id
     * @return
     */
    boolean deleteReqSource(int id);

}
