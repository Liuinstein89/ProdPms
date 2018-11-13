package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentMapper {


    /**
     * 列出部门列表
     *
     * @return departmentList
     */
    List<DepartmentEntity> queryDepartment();

    /**
     * 根据Id列出具体部门
     *
     * @return department
     */
    DepartmentEntity queryDepartmentById(int id);

    /**
     * 插入部门信息
     *
     * @param department
     * @return
     */
    int insertDepartment(DepartmentEntity department);

    /**
     * 更新部门信息
     *
     * @param department
     * @return
     */
    int updateDepartment(DepartmentEntity department);

    /**
     * 删除部门信息
     *
     * @param id
     * @return
     */
    int deleteDepartment(int id);
}
