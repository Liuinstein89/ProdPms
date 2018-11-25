package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.StateEntity;
import com.ccb.ProdPms.entity.StateQueryEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface StateMapper {
    List<StateEntity> selectAllState();

    List<StateEntity> selectStateByParams(StateQueryEntity stateQueryEntity);

    void insertState(StateEntity stateEntity);

    void updateState(StateEntity stateEntity);

    void deletedState(Integer id);

}
