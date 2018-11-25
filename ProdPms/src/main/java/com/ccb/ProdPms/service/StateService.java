package com.ccb.ProdPms.service;

import com.ccb.ProdPms.entity.StateEntity;
import com.ccb.ProdPms.entity.StateQueryEntity;

import java.util.Date;
import java.util.List;

public interface StateService {
    /**
     * 查找所有状态
     * @return
     */
    List<StateEntity> getAllState();

    /**
     * 按照条件查找状态
     * @return
     */
    List<StateEntity> getStateByParams(StateQueryEntity stateQueryEntity);

    /**
     * 增加新的状态
     * @param stateEntity
     */
    void addState(StateEntity stateEntity);

    /**
     * 修改状态
     * @param stateEntity
     */
    void editState(StateEntity stateEntity);
    /**
     * 删除状态
     * @param id
     */
    void deletedState(Integer id);


}
