package com.ccb.ProdPms.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// 数据导入主要涉及三个步骤 1.文件上传；2.Excel解析；3.数据插入。
	@RequestMapping(value = "/importFuncExcel", method = RequestMethod.POST)
	public String importFuncExcel(MultipartFile file) {
		if (file == null)
			return "file不能为空";
		String fileName = file.getName();
		String filePath = new File(fileName).getPath();
		try {
			List<Object[]> funcList = ExcelUtil.importExcel(fileName, filePath);
			FunctionEntity fe = new FunctionEntity();
			for (int i = 0; i < funcList.size(); i++) {
				String funcName = (String) funcList.get(i)[0];
				String funcReformContent = (String) funcList.get(i)[1];
				String desiPerson = (String) funcList.get(i)[2];
				String devPerson = (String) funcList.get(i)[3];
				String testPerson = (String) funcList.get(i)[4];
				fe.setDesiPerson(desiPerson);
				fe.setDevPerson(devPerson);
				fe.setFuncName(funcName);
				fe.setFuncReformContent(funcReformContent);
				fe.setTestPerson(testPerson);
				int count = funcService.findByName(funcName);
				if (count > 0) {
					funcService.updateFunc(fe);
				} else {
					funcService.insertFuncExcel(fe);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return e.getMessage();
		}
		return "success";
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
     * @throws IOException
     */
   /* @GetMapping("download")
    public void download() throws IOException{

        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个Excel表单,参数为sheet的名字
        HSSFSheet sheet = workbook.createSheet("课调答卷表");

        //创建表头
        setTitle(workbook, sheet);
        List<Answer> answers = answerService.findAll();

        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        for (Answer answer:answers) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(answer.getId());
            row.createCell(1).setCellValue(answer.getSelections());
            row.createCell(2).setCellValue(answer.getCheckes());
            row.createCell(3).setCellValue(answer.getContent());
            rowNum++;
        }
        String fileName = "survey-answer.xlsx";
        //清空response  
        HttpServletResponse response;
        response.reset();  
        //设置response的Header  
        response.addHeader("Content-Disposition", "attachment;filename="+ fileName);  
        OutputStream os = new BufferedOutputStream(response.getOutputStream());  
        response.setContentType("application/vnd.ms-excel;charset=gb2312"); 
        //将excel写入到输出流中
        workbook.write(os);
        os.flush();
        os.close();
    }*/

    /***
     * 设置表头
     * @param workbook
     * @param sheet
     */
    /*private void setTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(0, 10*256);
        sheet.setColumnWidth(1, 20*256);
        sheet.setColumnWidth(2, 20*256);
        sheet.setColumnWidth(3, 100*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("单选");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("多选");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("简答");
        cell.setCellStyle(style);
    }*/
}
