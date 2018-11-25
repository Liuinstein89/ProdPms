package com.ccb.ProdPms.service;

import com.ccb.ProdPms.entity.ExecTypeEntity;
import com.ccb.ProdPms.mapper.ExecTypeMapper;


import java.util.List;

public interface ExecTypeService {
    List<ExecTypeEntity> getAllExec();
    List<ExecTypeMapper> getExecByParams();
    void addExec(ExecTypeEntity execTypeEntity);
    void editExec(ExecTypeEntity execTypeEntity);
    void deletedExec(Integer id);
}
