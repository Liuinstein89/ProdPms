package com.ccb.ProdPms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.dto.OnlinePlanFuncDto;
import com.ccb.ProdPms.entity.OnlinePlanEntity;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.service.OnlinePlanService;
import com.ccb.ProdPms.util.RespCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@EnableAutoConfiguration
@Slf4j
public class OnlinePlanController {

	@Autowired
	OnlinePlanService onlinePlanService;
	private static String strSuc = "success";
	Map<String, Object> map = new HashMap<String, Object>();

	@GetMapping("/lsitOnlinePlan")
	public String getAll(@RequestParam(value = "page") Integer pageNum,
			@RequestParam(value = "limit") Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<OnlinePlanEntity> opPageInfo = new PageInfo<>(onlinePlanService.getAll());
		RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, opPageInfo);
		log.debug("");
		return JSONObject.toJSONString(restResp);
	}

	// 检索
	@GetMapping("/opSearch")
	public String opSearch(@RequestParam(value = "reqName") String reqName,
			@RequestParam(value = "onlineDatetime") String onlineDatetime,
			@RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<OnlinePlanEntity> opPageInfo = new PageInfo<>(onlinePlanService.getByParams(reqName, onlineDatetime));
		map.put("code", 0);
		map.put("msg", "ok");
		map.put("data", opPageInfo);
		return JSONObject.toJSONString(map);
	}

	// 删除功能点

	@GetMapping("/deleteOnlinePlanById")
	public String deleteOnlinePlanById(@RequestParam(value = "id") Integer id) {
		onlinePlanService.deleteOnlinePlanById(id);
		return JSONObject.toJSONString(strSuc);
	}

	// 新增功能点

	@PostMapping("/addOnlinePlan")
	public String addOp(OnlinePlanFuncDto onlinePlanFuncDto) {
		try {
			onlinePlanService.insertOp(onlinePlanFuncDto);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return strSuc = "add onlinePlan failed! ";
		}
		return JSONObject.toJSONString(strSuc);
	}

	/*
	 * @GetMapping("/listReqFunc") public String getReqFunc(@RequestParam(value =
	 * "page") Integer pageNum,
	 * 
	 * @RequestParam(value = "limit") Integer pageSize) {
	 * PageHelper.startPage(pageNum, pageSize); PageInfo<FunctionEntity>
	 * funcPageInfo = new PageInfo<>(funcService.getAll()); RestRespEntity restResp
	 * = new RestRespEntity(RespCode.SUCCESS, funcPageInfo); log.debug(""); return
	 * JSONObject.toJSONString(restResp); }
	 * 
	 * // 编辑功能点
	 * 
	 * @RequestMapping(value = "/updateFunc", method = RequestMethod.POST) public
	 * String updateFunc(HttpServletRequest request) throws IOException { // Form接参
	 * Long id = Long.parseLong(request.getParameter("id")); String funcName =
	 * request.getParameter("funcName"); String funcReformContent =
	 * request.getParameter("funcReformContent"); String desiPerson =
	 * request.getParameter("desiPerson"); String devPerson =
	 * request.getParameter("devPerson"); String testPerson =
	 * request.getParameter("testPerson"); String onlineDate =
	 * request.getParameter("onlineDate"); String modiDate = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); FunctionEntity
	 * functionEntity = new FunctionEntity(id, funcName, funcReformContent,
	 * desiPerson, devPerson, testPerson, onlineDate, modiDate);
	 * 
	 * // 修改需求主表项 try { funcService.updateFunc(functionEntity); } catch (Exception
	 * e) { e.getMessage(); return "update Func failed! "; } return
	 * JSONObject.toJSONString(strSuc); }
	 * 
	 */
}
