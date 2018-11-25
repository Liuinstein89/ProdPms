package com.ccb.ProdPms.service.impl;

import com.ccb.ProdPms.entity.StateEntity;
import com.ccb.ProdPms.entity.StateQueryEntity;
import com.ccb.ProdPms.mapper.StateMapper;
import com.ccb.ProdPms.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StateServiceImpl implements StateService {
    @Autowired
    private StateMapper stateMapper;

    @Override
    public List<StateEntity> getAllState() {
        return stateMapper.selectAllState();
    }

    @Override
    public List<StateEntity> getStateByParams(StateQueryEntity stateQueryEntity) {
        return stateMapper.selectStateByParams(stateQueryEntity);
    }

    @Override
    @Transactional
    public void addState(StateEntity stateEntity) {
        if (stateEntity.getStateType()!=null && stateEntity.getStateName()!=null
                 && !stateEntity.getStateType().equals("") && !stateEntity.getStateName().equals("")){
            try {
                stateMapper.insertState(stateEntity);
            } catch (Exception e) {
                throw new RuntimeException("新增状态失败："+e.toString());
            }
        }else{
            throw new RuntimeException("状态类型与状态名称不能为空！");
        }
    }

    @Override
    @Transactional
    public void editState(StateEntity stateEntity) {
        if(stateEntity.getStateType()!=null && stateEntity.getStateName()!=null
                && !stateEntity.getStateType().equals("") && !stateEntity.getStateName().equals("")){
            try {
                stateMapper.updateState(stateEntity);
            } catch (Exception e) {
                throw  new RuntimeException("修改状态信息失败："+e.toString());
            }
        }else{
            throw new RuntimeException("状态类型与状态名称不能为空！");
        }
    }

    @Override
    public void deletedState(Integer id) {
        stateMapper.deletedState(id);

    }

}
