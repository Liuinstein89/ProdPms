package com.ccb.ProdPms.service.impl;

import com.ccb.ProdPms.entity.DepartmentEntity;
import com.ccb.ProdPms.mapper.DepartmentMapper;
import com.ccb.ProdPms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public List<DepartmentEntity> getDepartmentList() {
        // 返回所有的部门信息
        return departmentMapper.queryDepartment();
    }

    @Override
    public DepartmentEntity getDepartmentById(int id) {
        return departmentMapper.queryDepartmentById(id);
    }

    @Transactional
    @Override
    public boolean addDepartment(DepartmentEntity department) {
        // 空值判断，主要是判断departmentName不为空
        if (department.getDptName() != null && !"".equals(department.getDptName())) {
            // 设置默认值
            department.setCreateTime(new Date());
            department.setChangeTime(new Date());
            try {
                int effectedNum = departmentMapper.insertDepartment(department);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加部门信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加部门信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("部门信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyDepartment(DepartmentEntity department) {
        // 空值判断，主要是id不为空
        if (department.getId() != null && department.getId() > 0) {
            // 设置默认值
            department.setChangeTime(new Date());

            try {
                // 更新部门信息
                int effectedNum = departmentMapper.updateDepartment(department);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新部门信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新部门信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("部门信息不能为空！");
        }

    }

    @Transactional
    @Override
    public boolean deleteDepartment(int id) {
        if (id > 0) {
            try {
                // 删除部门信息
                int effectedNum = departmentMapper.deleteDepartment(id);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除部门信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除部门信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("部门Id不能为空！");
        }
    }
}
