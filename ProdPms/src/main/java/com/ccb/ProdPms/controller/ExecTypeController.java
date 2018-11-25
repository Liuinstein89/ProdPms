package com.ccb.ProdPms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.entity.ExecTypeEntity;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.service.ExecTypeService;
import com.ccb.ProdPms.util.RespCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@EnableAutoConfiguration
public class ExecTypeController {
    private static String strSuc = "success";

    @Autowired
    ExecTypeService execTypeService;

    /**
     * 获取实施方式列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getAllExecType")
    @ResponseBody
    public String getExecList(@RequestParam(value = "page") Integer pageNum,
                              @RequestParam(value = "limit") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ExecTypeEntity> execTypeEntityPageInfo = new PageInfo<>(execTypeService.getAllExec());
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, execTypeEntityPageInfo);
        return JSONObject.toJSONString(restResp);
    }

    /**
     * 新增实施方式
     * @param request
     * @return
     */
    @PostMapping("/addExec")
    @ResponseBody
    public String addExec(HttpServletRequest request){
        String typeName=request.getParameter("typeName");
        String createDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String modiDate=null;
        String opPerson=request.getParameter("opPerson");
        ExecTypeEntity execTypeEntity=new ExecTypeEntity(typeName, createDate, modiDate, opPerson);
        try {
            execTypeService.addExec(execTypeEntity);
        } catch (Exception e) {
            e.getMessage();
            return "add ExecType failed! ";
        }
        return JSONObject.toJSONString(strSuc);
    }

    /**
     * 修改实施方式
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/updateExec", method = RequestMethod.POST)
    @ResponseBody
    public String editExec(HttpServletRequest request) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String typeName=request.getParameter("typeName");
        String opPerson=request.getParameter("opPerson");
        String modiDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        ExecTypeEntity execTypeEntity = new ExecTypeEntity(id, typeName, modiDate, opPerson);
        try {
            execTypeService.editExec(execTypeEntity);
        } catch (Exception e) {
            e.getMessage();
            return "update user failed!";
        }
        return JSONObject.toJSONString(strSuc);
    }

    /**
     * 删除实施方式
     * @param id
     * @return
     */
    @GetMapping("/delExecById")
    @ResponseBody
    public String deletedExecById(@RequestParam(value = "id") Integer id){
        execTypeService.deletedExec(id);
        return JSONObject.toJSONString(strSuc);
    }
}
