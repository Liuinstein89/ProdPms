package com.ccb.ProdPms.service;

import com.ccb.ProdPms.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {

    List<DepartmentEntity> getAll();

    List<DepartmentEntity> getByParams(DepartmentEntity departmentEntity);

    void updateDept(DepartmentEntity departmentEntity);

    void deleteDeptById(Integer id);

    int findByName(String departmentName);

    void insertDept(DepartmentEntity departmentEntity);

    void updateExcelDept(DepartmentEntity departmentEntity2);


}
