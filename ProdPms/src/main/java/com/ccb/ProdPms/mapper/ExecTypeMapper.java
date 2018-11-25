package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.ExecTypeEntity;

import java.util.List;

public interface ExecTypeMapper {
    List<ExecTypeEntity> selectAllExec();
    List<ExecTypeMapper> selectExecByParams();
    void insertExec(ExecTypeEntity execTypeEntity);
    void updateExec(ExecTypeEntity execTypeEntity);
    void deletedExec(Integer id);
}
