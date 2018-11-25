package com.ccb.ProdPms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.entity.StateEntity;
import com.ccb.ProdPms.service.StateService;
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
public class StateController {
    private static String strSuc = "success";

    @Autowired
    StateService stateService;

    /**
     * 获取状态列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getAllState")
    @ResponseBody
    public String getStateList(@RequestParam(value = "page") Integer pageNum,
                               @RequestParam(value = "limit") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<StateEntity> stateEntityPageInfo = new PageInfo<>(stateService.getAllState());
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, stateEntityPageInfo);
        return JSONObject.toJSONString(restResp);
    }

    /**
     * 新增状态
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/addState")
    @ResponseBody
    public String addState(HttpServletRequest request){

        String stateType=request.getParameter("stateType");
        String stateName=request.getParameter("stateName");
        String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String changeTime = null;
        String opPerson = request.getParameter("opPerson");

        StateEntity stateEntity=new StateEntity(stateType,stateName,createTime,changeTime,opPerson);
        try {
            stateService.addState(stateEntity);
        } catch (Exception e) {
            e.getMessage();
            return "add state failed! ";
        }
        return JSONObject.toJSONString(strSuc);
    }

    /**
     * 修改状态信息
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/updateState", method = RequestMethod.POST)
    @ResponseBody
    public String editState(HttpServletRequest request) throws IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        String stateType=request.getParameter("stateType");
        String stateName=request.getParameter("stateName");
        String changeTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String opPerson=request.getParameter("opPerson");
        StateEntity stateEntity = new StateEntity(id, stateType, stateName, changeTime, opPerson);
        try {
            stateService.editState(stateEntity);
        } catch (Exception e) {
            e.getMessage();
            return "update state failed!";
        }
        return JSONObject.toJSONString(strSuc);
    }

    /**
     * 删除状态
     * @param id
     * @return
     */
    @GetMapping("/delStateById")
    @ResponseBody
    public String deletedStateById(@RequestParam(value = "id") Integer id){
        stateService.deletedState(id);
        return JSONObject.toJSONString(strSuc);
    }


}
