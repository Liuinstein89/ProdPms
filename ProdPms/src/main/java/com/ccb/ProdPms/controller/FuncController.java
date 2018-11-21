package com.ccb.ProdPms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.entity.FunctionEntity;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.service.FuncService;
import com.ccb.ProdPms.util.ExcelUtil;
import com.ccb.ProdPms.util.RespCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@EnableAutoConfiguration
@Slf4j
public class FuncController {
	@Autowired
	FuncService funcService;
	private static String strSuc = "success";

	@GetMapping("/listFunc")
	public String getAll(@RequestParam(value = "page") Integer pageNum,
			@RequestParam(value = "limit") Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<FunctionEntity> funcPageInfo = new PageInfo<>(funcService.getAll());
		RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, funcPageInfo);
		log.debug("");
		return JSONObject.toJSONString(restResp);
	}

	@GetMapping("/listReqFunc")
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
	public String importFuncExcel(MultipartFile file,@RequestParam(value = "userName") String userName) {
		if (file == null)
			return "file不能为空";
		String fileName = file.getName();
		String filePath = new File(fileName).getPath();
		try {
			List<Object[]> funcList = ExcelUtil.importExcel(fileName, filePath);
			FunctionEntity functionEntity = new FunctionEntity();
			for (int i = 0; i < funcList.size(); i++) {
				String funcName = (String) funcList.get(i)[0];
				String funcReformContent = (String) funcList.get(i)[1];
				String onlineDate = (String) funcList.get(i)[2];
				String desiPerson = (String) funcList.get(i)[3];
				String devPerson = (String) funcList.get(i)[4];
				String testPerson = (String) funcList.get(i)[5];
				functionEntity.setDesiPerson(desiPerson);
				functionEntity.setDevPerson(devPerson);
				functionEntity.setFuncName(funcName);
				functionEntity.setOnlineDate(onlineDate);
				functionEntity.setFuncReformContent(funcReformContent);
				functionEntity.setTestPerson(testPerson);
				functionEntity.setCreateUser(userName);
				functionEntity.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				int count = funcService.findByName(funcName);//这里功能点和改造内容的判断有些问题，有没有可能出现同一个功能点对应多个改造内容，如果这样的话，就需要都去判断，才能更新
				if (count > 0) {
					String modiDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
					FunctionEntity functionEntity2 = new FunctionEntity(funcName, funcReformContent, desiPerson, devPerson,
							testPerson, onlineDate, modiDate);
					funcService.updateExcelFunc(functionEntity2);
				} else {
					funcService.insertFunc(functionEntity);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return e.getMessage();
		}
		return "success";
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
			FunctionEntity functionEntity = new FunctionEntity( funcName, funcReformContent, desiPerson, devPerson,createUser,
					testPerson, onlineDate, createDate);
			try {
				funcService.insertFunc(functionEntity);
			} catch (Exception e) {
				log.error(e.getMessage(),e);
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
		}
	/*
	 * 导出Excel常用的方法： HSSFWorkbook wb=new HSSFWorkbook(); //创建Excel工作簿对象 HSSFSheet
	 * sheet=wb.createSheet("newsheet"); //创建Excel工作表对象 HSSFRow
	 * row=sheet.createRow((short)0); //创建Excel工作表的行 cellStyle=wb.createCellStyle();
	 * //创建单元格样式 row.createCell((short)0).setCellStyle(cellStyle);
	 * //创建Excel工作表指定行的单元格 row.createCell((short)0).setCellValue(1); //设置Excel工作表的值
	 */
	/***
	 * 下载Excel
	 * 
	 * @throws IOException
	 */
	/*
	 * @GetMapping("download") public void download() throws IOException{
	 * 
	 * HSSFWorkbook workbook = new HSSFWorkbook(); //创建一个Excel表单,参数为sheet的名字
	 * HSSFSheet sheet = workbook.createSheet("课调答卷表");
	 * 
	 * //创建表头 setTitle(workbook, sheet); List<Answer> answers =
	 * answerService.findAll();
	 * 
	 * //新增数据行，并且设置单元格数据 int rowNum = 1; for (Answer answer:answers) { HSSFRow row =
	 * sheet.createRow(rowNum); row.createCell(0).setCellValue(answer.getId());
	 * row.createCell(1).setCellValue(answer.getSelections());
	 * row.createCell(2).setCellValue(answer.getCheckes());
	 * row.createCell(3).setCellValue(answer.getContent()); rowNum++; } String
	 * fileName = "survey-answer.xlsx"; //清空response HttpServletResponse response;
	 * response.reset(); //设置response的Header
	 * response.addHeader("Content-Disposition", "attachment;filename="+ fileName);
	 * OutputStream os = new BufferedOutputStream(response.getOutputStream());
	 * response.setContentType("application/vnd.ms-excel;charset=gb2312");
	 * //将excel写入到输出流中 workbook.write(os); os.flush(); os.close(); }
	 */

	/***
	 * 设置表头
	 * 
	 * @param workbook
	 * @param sheet
	 */
	/*
	 * private void setTitle(HSSFWorkbook workbook, HSSFSheet sheet){ HSSFRow row =
	 * sheet.createRow(0); //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
	 * sheet.setColumnWidth(0, 10*256); sheet.setColumnWidth(1, 20*256);
	 * sheet.setColumnWidth(2, 20*256); sheet.setColumnWidth(3, 100*256);
	 * 
	 * //设置为居中加粗 HSSFCellStyle style = workbook.createCellStyle(); HSSFFont font =
	 * workbook.createFont(); font.setBold(true); style.setFont(font);
	 * 
	 * HSSFCell cell; cell = row.createCell(0); cell.setCellValue("序号");
	 * cell.setCellStyle(style);
	 * 
	 * cell = row.createCell(1); cell.setCellValue("单选"); cell.setCellStyle(style);
	 * 
	 * cell = row.createCell(2); cell.setCellValue("多选"); cell.setCellStyle(style);
	 * 
	 * cell = row.createCell(3); cell.setCellValue("简答"); cell.setCellStyle(style);
	 * }
	 */
}
