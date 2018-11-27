package com.ccb.ProdPms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
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

		@GetMapping("/lsitOnlinePlan")
		public String getAll(@RequestParam(value = "page") Integer pageNum,
				@RequestParam(value = "limit") Integer pageSize) {
			PageHelper.startPage(pageNum, pageSize);
			PageInfo<OnlinePlanEntity> opPageInfo = new PageInfo<>(onlinePlanService.getAll());
			RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, opPageInfo);
			log.debug("");
			return JSONObject.toJSONString(restResp);
		}

		/*@GetMapping("/listReqFunc")
		public String getReqFunc(@RequestParam(value = "page") Integer pageNum,
				@RequestParam(value = "limit") Integer pageSize) {
			PageHelper.startPage(pageNum, pageSize);
			PageInfo<FunctionEntity> funcPageInfo = new PageInfo<>(funcService.getAll());
			RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, funcPageInfo);
			log.debug("");
			return JSONObject.toJSONString(restResp);
		}

		// 数据导入主要涉及三个步骤 1.文件上传；2.Excel解析；3.数据插入。
		@RequestMapping(value = "/importFuncExcel", method = RequestMethod.POST)
		public String importFuncExcel(MultipartFile file, @RequestParam(value = "userName") String userName) {
			if (file == null)
				return "file不能为空";
			String fileName = file.getOriginalFilename();
			// String filePath = new File(fileName).getPath();
			try {
				List<Object[]> funcList = ExcelUtil.importExcel(fileName, file);
				FunctionEntity functionEntity = new FunctionEntity();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("code", "-1");
				if (funcList.size() == 0)
					return JSONObject.toJSONString(map);

				for (int i = 0; i < funcList.size(); i++) {
					String funcName = (String) funcList.get(i)[0];
					String funcReformContent = (String) funcList.get(i)[1];
					String desiPerson = (String) funcList.get(i)[2];
					String devPerson = (String) funcList.get(i)[3];
					String testPerson = (String) funcList.get(i)[4];
					functionEntity.setDesiPerson(desiPerson);
					functionEntity.setDevPerson(devPerson);
					functionEntity.setFuncName(funcName);
					functionEntity.setFuncReformContent(funcReformContent);
					functionEntity.setTestPerson(testPerson);
					functionEntity.setCreateUser(userName);
					functionEntity.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					int count = funcService.findByName(funcName);// 这里功能点和改造内容的判断有些问题，有没有可能出现同一个功能点对应多个改造内容，如果这样的话，就需要都去判断，才能更新
					if (count > 0) {
						String modiDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
						FunctionEntity functionEntity2 = new FunctionEntity(funcName, funcReformContent, desiPerson,
								devPerson, testPerson, modiDate);
						funcService.updateExcelFunc(functionEntity2);
					} else {
						funcService.insertFunc(functionEntity);
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

		// 新增功能点
		@PostMapping("/addFunc")
		public String addFunc(HttpServletRequest request) {
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
		public String updateFunc(HttpServletRequest request) throws IOException {
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
		public String deleteFuncById(@RequestParam(value = "id") Integer id) {
			funcService.deleteFuncById(id);
			return JSONObject.toJSONString(strSuc);
		}*/
}
