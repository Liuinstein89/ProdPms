package com.ccb.ProdPms.controller;

import com.ccb.ProdPms.service.FuncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Slf4j
public class DevController {
    @Autowired
    FuncService funcService;
    private static String strSuc = "success";

   /* @GetMapping("/listReqDev")
    public String getAll(@RequestParam(value = "page") Integer pageNum,
                         @RequestParam(value = "limit") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<FunctionEntity> funcPageInfo = new PageInfo<>(funcService.getAll());
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, funcPageInfo);
        log.debug("");
        return JSONObject.toJSONString(restResp);
    }

    @GetMapping("/listReqFunc")
    public String get(@RequestParam(value = "page") Integer pageNum,
                      @RequestParam(value = "limit") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<FunctionEntity> funcPageInfo = new PageInfo<>(funcService.getAll());
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, funcPageInfo);
        log.debug("");
        return JSONObject.toJSONString(restResp);
    }


    // 新增功能点
    @PostMapping("/addFunc")
    public String add(HttpServletRequest request) {
        // Form接参
        String funcName = request.getParameter("funcName");
        String funcReformContent = request.getParameter("funcReformContent");
        String desiPerson = request.getParameter("desiPerson");
        String devPerson = request.getParameter("devPerson");
        String testPerson = request.getParameter("testPerson");
        String onlineDate = request.getParameter("onlineDate");
        String createUser = request.getParameter("userName");
        String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        FunctionEntity functionEntity = new FunctionEntity(funcName, funcReformContent, desiPerson, devPerson,
                createUser, testPerson, onlineDate, createDate);
        try {
            funcService.insertFunc(functionEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "update Func failed! ";
        }
        return JSONObject.toJSONString(strSuc);
    }

    // 编辑功能点
    @RequestMapping(value = "/updateFunc", method = RequestMethod.POST)
    public String update(HttpServletRequest request) throws IOException {
        // Form接参
        Long id = Long.parseLong(request.getParameter("id"));
        String funcName = request.getParameter("funcName");
        String funcReformContent = request.getParameter("funcReformContent");
        String desiPerson = request.getParameter("desiPerson");
        String devPerson = request.getParameter("devPerson");
        String testPerson = request.getParameter("testPerson");
        String onlineDate = request.getParameter("onlineDate");
        String modiDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        FunctionEntity functionEntity = new FunctionEntity(id, funcName, funcReformContent, desiPerson, devPerson,
                testPerson, onlineDate, modiDate);

        // 修改需求主表项
        try {
            funcService.updateFunc(functionEntity);
        } catch (Exception e) {
            e.getMessage();
            return "update Func failed! ";
        }
        return JSONObject.toJSONString(strSuc);
    }

    // 删除功能点
    @GetMapping("/delFuncById")
    @ResponseBody
    public String delById(@RequestParam(value = "id") Integer id) {
        funcService.deleteFuncById(id);
        return JSONObject.toJSONString(strSuc);
    }*/
}
