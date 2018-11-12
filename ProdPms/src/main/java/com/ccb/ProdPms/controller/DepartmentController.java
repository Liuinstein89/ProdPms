package com.ccb.ProdPms.controller;

import com.ccb.ProdPms.entity.DepartmentEntity;
import com.ccb.ProdPms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/query/{id}")
    public DepartmentEntity getDepartment(@PathVariable("id") Integer id){
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/queryAll")
    public List<DepartmentEntity> getAllDepartment(){
        return departmentService.getDepartmentList();
    }

    @GetMapping("/add")
    public DepartmentEntity insertDept(DepartmentEntity department){
        departmentService.addDepartment(department);
        return department;
    }

    @GetMapping("/modify")
    public DepartmentEntity updateDept(DepartmentEntity department){
        departmentService.modifyDepartment(department);
        return department;
    }

    @GetMapping("/delete/{id}")
    public void deleteDept(@PathVariable("id") Integer id){
        departmentService.deleteDepartment(id);
    }


}
