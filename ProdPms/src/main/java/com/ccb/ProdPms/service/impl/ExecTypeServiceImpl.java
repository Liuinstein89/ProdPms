package com.ccb.ProdPms.service.impl;

import com.ccb.ProdPms.entity.ExecTypeEntity;
import com.ccb.ProdPms.mapper.ExecTypeMapper;
import com.ccb.ProdPms.service.ExecTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExecTypeServiceImpl implements ExecTypeService {
    @Autowired
    private ExecTypeMapper execTypeMapper;

    @Override
    public List<ExecTypeEntity> getAllExec() {
        return execTypeMapper.selectAllExec();
    }

    @Override
    public List<ExecTypeMapper> getExecByParams() {
        return execTypeMapper.selectExecByParams();
    }

    @Override
    @Transactional
    public void addExec(ExecTypeEntity execTypeEntity) {
        if (execTypeEntity.getTypeName()!=null && execTypeEntity.getTypeName()!=null){
            try {
                execTypeMapper.insertExec(execTypeEntity);
            } catch (Exception e) {
                throw new RuntimeException("新增失败："+e.toString());
            }
        }else{
            throw new RuntimeException("实施方式名和id不能为空！");
        }

    }

    @Override
    @Transactional
    public void editExec(ExecTypeEntity execTypeEntity) {
        if(execTypeEntity.getTypeName()!=null && execTypeEntity.getTypeName()!=null){
            try {
                execTypeMapper.updateExec(execTypeEntity);
            } catch (Exception e) {
                throw  new RuntimeException("修改信息失败："+e.toString());
            }
        }else{
            throw new RuntimeException("实施方式名和id不能为空！");
        }

    }

    @Override
    public void deletedExec(Integer id) {
        execTypeMapper.deletedExec(id);

    }
}
