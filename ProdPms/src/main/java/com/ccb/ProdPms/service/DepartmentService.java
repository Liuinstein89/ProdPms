package com.ccb.ProdPms.service;

import com.ccb.ProdPms.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {


    /**
     * 获取部门列表
     *
     * @return
     */
    List<DepartmentEntity> getDepartmentList();

    /**
     * 通过Id获取部门信息
     *
     * @param id
     * @return
     */
    DepartmentEntity getDepartmentById(int id);

    /**
     * 增加部门信息
     *
     * @param department
     * @return
     */
    boolean addDepartment(DepartmentEntity department);

    /**
     * 修改部门信息
     *
     * @param department
     * @return
     */
    boolean modifyDepartment(DepartmentEntity department);

    /**
     * 删除部门信息
     *
     * @param id
     * @return
     */
    boolean deleteDepartment(int id);

}
