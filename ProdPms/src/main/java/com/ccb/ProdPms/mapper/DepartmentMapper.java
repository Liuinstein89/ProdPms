package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentMapper {
    List<DepartmentEntity> getAll();

    void updateDept(DepartmentEntity departmentEntity);

    DepartmentEntity findOne(Integer id);

    void deleteById(Integer id);

    void insertDept(DepartmentEntity departmentEntity);

    int findByName(String departmentName);

    void updateExcelDept(DepartmentEntity departmentEntity2);

}
