package com.ccb.ProdPms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.service.DmdManageService;
import com.ccb.ProdPms.service.FuncService;
import com.ccb.ProdPms.util.RespCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Slf4j
public class DesiController {
    @Autowired
    FuncService funcService;
    @Autowired
    DmdManageService dmdManageService;
    private static String strSuc = "success";

    /**
     * @Description: 需求设计列表，只不过默认展示状态为需求审核通过的需求列表
     * @Param: [pageNum, pageSize]
     * @return: java.lang.String
     * @Author: LHY
     * @Date: 2019/1/14
     */
    @GetMapping("/listReqDesign")
    public String getAll(@RequestParam(value = "page") Integer pageNum,
                         @RequestParam(value = "limit") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<DmdManageEntity> desiReqPageInfo = new PageInfo<>(dmdManageService.getAll());
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, desiReqPageInfo);
        log.info("列表详情, restResp={}", restResp.toString());
        return JSONObject.toJSONString(restResp);
    }
}
