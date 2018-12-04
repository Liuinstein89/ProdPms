package com.ccb.ProdPms.controller;


import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.entity.ReqSourceEntity;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.service.ReqSourceService;
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
public class ReqSourceController {


    @Autowired
    private ReqSourceService reqSourceService;

    private static String strSuc = "success";

    @GetMapping("/listReqSource")
    public String getAll(@RequestParam(value = "page") Integer pageNum,
                         @RequestParam(value = "limit") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ReqSourceEntity> reqPageInfo = new PageInfo<>(reqSourceService.getAll());
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, reqPageInfo);
        log.debug("");
        return JSONObject.toJSONString(restResp);
    }


    
    @PostMapping("/addReqSource")
    public String addReqSource(HttpServletRequest request) throws Exception{
        
        String souceName = request.getParameter("souceName");
        String opPerson = request.getParameter("opPerson");
        String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ReqSourceEntity reqSourceEntity = new ReqSourceEntity( souceName , opPerson, createTime);
       
	   //判断数据库中是否有该记录，如有，就更新，如无，再新增
        int count =  reqSourceService.findByName(souceName);
        if (count > 0) {
            String changeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            ReqSourceEntity reqSourceEntity2 = new  ReqSourceEntity( souceName, changeTime);
            reqSourceService.updateExcelReqSource(reqSourceEntity2);
        } else {
            reqSourceService.insertReqSource(reqSourceEntity);
       
        }
        return JSONObject.toJSONString(strSuc);
    }

  
    @RequestMapping(value = "/updateReqSource", method = RequestMethod.POST)
    public String updateReqSource(HttpServletRequest request) throws IOException {
        
        Long id = Long.parseLong(request.getParameter("id"));
        String souceName = request.getParameter("souceName");
        String changeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ReqSourceEntity reqSourceEntity = new ReqSourceEntity(id,souceName, changeTime);

       
        try {
            reqSourceService.updateReqSource(reqSourceEntity);
        } catch (Exception e) {
            e.getMessage();
            return "update ReqSource failed! ";
        }
        return JSONObject.toJSONString(strSuc);
    }

    
    @GetMapping("/delReqSourceById")
    @ResponseBody
    public String deleteReqSourceById(@RequestParam(value = "id") Integer id) {
        reqSourceService.deleteById(id);
        return JSONObject.toJSONString(strSuc);
    }


    // 数据导入主要涉及三个步骤 1.文件上传；2.Excel解析；3.数据插入。    
    @RequestMapping(value = "/importReqSourceExcel", method = RequestMethod.POST)
    public String importReqSourceExcel(MultipartFile file, @RequestParam(value = "userName") String userName) {
        if (file == null)
            return "file不能为空";
        String fileName = file.getOriginalFilename();
        try {
            List<Object[]> reqSourceList = ExcelUtil.importExcel(fileName, file);
            ReqSourceEntity reqSourceEntity = new  ReqSourceEntity();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", "-1");
            if (reqSourceList.size() == 0)
                return JSONObject.toJSONString(map);
            for (int i = 0; i < reqSourceList.size(); i++) {
                String souceName = (String) reqSourceList.get(i)[0];

                reqSourceEntity.setSouceName(souceName);
                reqSourceEntity.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                reqSourceEntity.setOpPerson(userName);

                int count =  reqSourceService.findByName(souceName);
                if (count > 0) {
                    String changeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    ReqSourceEntity reqSourceEntity2 = new  ReqSourceEntity( souceName, changeTime);
                    reqSourceService.updateExcelReqSource(reqSourceEntity2);
                } else {
                    reqSourceService.insertReqSource(reqSourceEntity);
                }
            }
        }  catch (Exception e) {
            log.error(e.getMessage(), e);
            RestRespEntity restResp = new RestRespEntity(RespCode.WARN, null);
            return JSONObject.toJSONString(restResp);
        }
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, null);
        return JSONObject.toJSONString(restResp);
    }


}
