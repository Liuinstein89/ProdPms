package com.ccb.ProdPms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.entity.DepartmentEntity;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.service.DepartmentService;
import com.ccb.ProdPms.util.ExcelUtil;
import com.ccb.ProdPms.util.RespCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@EnableAutoConfiguration
@Slf4j
public class DepartmentController {

    //@Autowired 注解，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。
    @Autowired
    DepartmentService departmentService;
    private static String strSuc = "success";

    @GetMapping("/listDept")
    public String getAll(@RequestParam(value = "page") Integer pageNum,
                         @RequestParam(value = "limit") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<DepartmentEntity> dptPageInfo = new PageInfo<>(departmentService.getAll());
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, dptPageInfo);
        log.debug("");
        return JSONObject.toJSONString(restResp);
    }


    // 新增
    @PostMapping("/addDpt")
    public String addDpt(HttpServletRequest request) {
        // Form接参
        String dptName = request.getParameter("dptName");
        String dptCode = request.getParameter("dptCode");
        String opPerson = request.getParameter("opPerson");
        String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        DepartmentEntity departmentEntity = new DepartmentEntity( dptName, dptCode , opPerson, createTime);
        try {
            departmentService.insertDept(departmentEntity);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return "update Dpt failed! ";
        }
        return JSONObject.toJSONString(strSuc);
    }

    // 编辑
    @RequestMapping(value = "/updateDpt", method = RequestMethod.POST)
    public String updateDpt(HttpServletRequest request) throws IOException {
        // Form接参
        Long id = Long.parseLong(request.getParameter("id"));
        String dptName = request.getParameter("dptName");
        String dptCode = request.getParameter("dptCode");
        String changeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        DepartmentEntity departmentEntity = new DepartmentEntity(id,dptName, dptCode , changeTime);

        try {
            departmentService.updateDept(departmentEntity);
        } catch (Exception e) {
            e.getMessage();
            return "update Dpt failed! ";
        }
        return JSONObject.toJSONString(strSuc);
    }

    // 删除
    @GetMapping("/delDptById")
    @ResponseBody
    public String deleteDptById(@RequestParam(value = "id") Integer id) {
        departmentService.deleteDeptById(id);
        return JSONObject.toJSONString(strSuc);
    }

    // 数据导入主要涉及三个步骤 1.文件上传；2.Excel解析；3.数据插入。
    @RequestMapping(value = "/importDptExcel", method = RequestMethod.POST)
    public String importDptExcel(MultipartFile file,@RequestParam(value = "userName") String userName) {
        if (file == null)
            return "file不能为空";
        String fileName = file.getOriginalFilename();
        try {
            List<Object[]> dptList = ExcelUtil.importExcel(fileName, file);
            DepartmentEntity departmentEntity = new DepartmentEntity();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", "-1");
            if (dptList.size() == 0)
                return JSONObject.toJSONString(map);

            for (int i = 0; i < dptList.size(); i++) {
                String dptName = (String) dptList.get(i)[0];
                String dptCode = (String) dptList.get(i)[1];

                departmentEntity.setDptName(dptName);
                departmentEntity.setDptCode(dptCode);
                departmentEntity.setOpPerson(userName);
                departmentEntity.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

                int count = departmentService.findByName(dptName);
                if (count > 0) {
                    String changeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    DepartmentEntity departmentEntity2 = new DepartmentEntity( dptName,dptCode, changeTime);
                    departmentService.updateExcelDept(departmentEntity2);
                } else {
                    departmentService.insertDept(departmentEntity);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            RestRespEntity restResp = new RestRespEntity(RespCode.WARN, null);
            return JSONObject.toJSONString(restResp);
        }
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, null);
        return JSONObject.toJSONString(restResp);
    }

}
