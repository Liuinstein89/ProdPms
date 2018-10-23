package com.ccb.ProdPms.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: UploadFileController
 * @Description: 上传、下载和删除文件接口
 * @author lhy-pc
 * @date 2018年10月22日
 * 
 */
@Controller
// @RequestMapping("/addReq")
public class UploadFileController {
	// 用log4j还是slf4j是个问题，主要使用slf4j吧,class.getName()
	Logger log = LoggerFactory.getLogger(this.getClass());

	// 上传默认路径
	private static String UPLOADED_FILEPATH = "E://temp//";

	// 需求新建处文件上传
	// @RequestMapping(value="/upload",method=RequestMethod.POST)
	@PostMapping("/uploadfile")
	public String singleFileUpload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			log.info("no upload file!");
			return "redirect:/upload123";
		}
		// String uuidname = UUID.randomUUID().toString().replace("-",
		// "").toLowerCase();
		String fileName = file.getOriginalFilename();
		// idea快捷键.txt
		int size = (int) file.getSize();
		String type = file.getContentType();
		System.out.println("#####################" + type);
		// text/plain
		// application/octet-stream
		// #####################application/pdf
		// #####################application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
		log.info(fileName + "-->" + size);
		File dest = new File(UPLOADED_FILEPATH + fileName);
		System.out.println("@@@@@@" + dest.getName() + "-->" + dest.getPath() + "-->" + dest.getParent() + "-->"
				+ dest.getParentFile() + "-->" + dest + "-->" + dest.toString());
		// @@@@@@docker_practice.pdf-->E:\temp\docker_practice.pdf-->E:\temp-->E:\temp
		// @@@@@@交接文档_180927_lhy.xlsx-->E:\temp\交接文档_180927_lhy.xlsx-->E:\temp-->E:\temp
		// 判断文件父目录是否存在
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		try {
			file.transferTo(dest);
			String str = UPLOADED_FILEPATH + fileName;
			return str;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "upload";
	}

	@GetMapping("/upload123")
	public String index() {
		return "upload";
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// 上传文件下载，主要是需求查看的时候
	@RequestMapping("download.htm")
	public String downLoad(HttpServletResponse response, @RequestParam Integer id) {
		// TjrFile tjrFile = fileService.findOne(id);
		// UUID name
		String uuidname = null;// = tjrFile.getUuidname();
		// 文件名
		String filename = null;// = tjrFile.getFilename();
		File file = new File(UPLOADED_FILEPATH + uuidname);
		if (file.exists()) { // 判断文件父目录是否存在
			response.setContentType("application/force-download");
			// 修改下载文件的文件名
			response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

			byte[] buffer = new byte[1024];
			FileInputStream fis = null; // 文件输入流
			BufferedInputStream bis = null;

			OutputStream os = null; // 输出流
			try {
				os = response.getOutputStream();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				int i = bis.read(buffer);
				while (i != -1) {
					os.write(buffer);
					i = bis.read(buffer);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("=========================文件下载" + filename);
			try {
				bis.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
  
	// 上传文件删除
	@PostMapping("del.json")
	@ResponseBody
	public String delfile(@RequestParam Integer id) {
		// TjrFile tjrFile = fileService.findOne(id);
		try {
			// fileService.del(id);
			File file = new File(UPLOADED_FILEPATH);// + tjrFile.getUuidname());
			if (file.delete()) {
				log.info(file.getName() + "is deleted");
				return "true";
			} else {
				log.info("Delete failed.");
				return "false";
			}
		} catch (Exception e) {
			log.info("Exception occured");
			e.printStackTrace();
			return "false";
		}
	}
}
