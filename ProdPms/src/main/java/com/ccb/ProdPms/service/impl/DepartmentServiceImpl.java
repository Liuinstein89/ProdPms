package com.ccb.ProdPms.service.impl;

import com.ccb.ProdPms.entity.DepartmentEntity;
import com.ccb.ProdPms.exception.ResourceNotFoundException;
import com.ccb.ProdPms.mapper.DepartmentMapper;
import com.ccb.ProdPms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//@service 服务（注入dao）,用于标注服务层，主要用来进行业务的逻辑处理
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentEntity> getAll(){
        List<DepartmentEntity> deptList = new ArrayList<DepartmentEntity>();
        try {
            deptList = departmentMapper.getAll();
        } catch (Exception e) {
            e.getMessage();
        }
        return deptList;
    }

    @Override
    public List<DepartmentEntity> getByParams(DepartmentEntity departmentEntity){

        return null;
    }

    @Transactional
    public void updateDept(DepartmentEntity departmentEntity){
        departmentMapper.updateDept(departmentEntity);
    }

    @Transactional
    public void deleteDeptById(Integer id){
        DepartmentEntity departmentEntity = departmentMapper.findOne(id);
        if (departmentEntity == null) {
            throw new ResourceNotFoundException("找不到关键词，id：" + id);
        }
        try {
            departmentMapper.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Override
    public int findByName(String departmentName){
        int count = departmentMapper.findByName(departmentName);
        return count;
    }

    @Transactional
    public void insertDept(DepartmentEntity departmentEntity){
        departmentMapper.insertDept(departmentEntity);
    }


    @Transactional
    public void updateExcelDept(DepartmentEntity departmentEntity2){
        departmentMapper.updateExcelDept(departmentEntity2);
    }

}
