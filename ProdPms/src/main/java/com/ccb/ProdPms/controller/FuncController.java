package com.ccb.ProdPms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.entity.FunctionEntity;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.service.FuncService;
import com.ccb.ProdPms.util.RespCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FuncController {
	@Autowired
	FuncService funcService;

	@GetMapping("/listFunc")
	public String getAll(@RequestParam(value = "page") Integer pageNum,
			@RequestParam(value = "limit") Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<FunctionEntity> funcPageInfo = new PageInfo<>(funcService.getAll());
		RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, funcPageInfo);
		log.debug("");
		return JSONObject.toJSONString(restResp);
	}
}
