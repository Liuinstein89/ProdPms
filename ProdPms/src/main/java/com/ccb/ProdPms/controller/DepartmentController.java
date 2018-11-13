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

    //@Autowired 注解，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。
    @Autowired
    private DepartmentService departmentService;

    //通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中：URL 中的 {xxx} 占位符可以通过@PathVariable(“xxx“) 绑定到操作方法的入参中。
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
