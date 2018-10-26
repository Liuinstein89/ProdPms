package com.ccb.ProdPms.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

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
 * @Description: 上传、下载和删除文件接口,文件类型多种，pdf、office、图片均可
 * @author lhy-pc
 * @date 2018年10月22日
 * 
 */
@Controller
//@Slf4j
// @RequestMapping("/addReq")
public class UploadFileController {
	// 用log4j还是slf4j是个问题，主要使用slf4j吧,class.getName()
	Logger log = LoggerFactory.getLogger(this.getClass());

	// 上传默认路径
	private static String UPLOADED_FILEPATH = "E://temp//";

	// 页面跳转，地址栏路径为addReq，跳转到静态页面upload
	@GetMapping("/addReq")
	public String index() {
		return "upload";
	}

	// 需求新建处文件上传
	/*
	 * 在controller上加注解@Controller和@RestController都可以在前端调通接口，但是二者的区别在于，当用前者的时候在方法上必须添加注解@ResponseBody，
	 * 如果不添加@ResponseBody，就会报错，因为当使用@Controller注解时，spring默认方法返回的是view对象（页面）。
	 * 而加上@ResponseBody，则方法返回的就是具体对象了。@RestController的作用就相当于@Controller+@ResponseBody的结合体
	 */
	// @RequestMapping(value="/uploadfile",method=RequestMethod.POST)，发送的请求路径为uploadfile，但是操作还是在upload页面
	@PostMapping("/uploadFile")
	@ResponseBody
	public String singleFileUpload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "no upload file!";
		}
		String fileName = file.getOriginalFilename();
		log.info(fileName);
		// 上传文件名
		//String fileName = new Date().getTime() + new Random().nextInt(100) + "." + fileSuffix;
		//File savefile = new File(uploadPath + fileName);
		File dest = new File(UPLOADED_FILEPATH + fileName);
		// System.out.println(dest.getName() + "-->" + dest.getPath() + "-->" +
		// dest.getParentFile() + "-->" + dest);
		// test.sql-->E:\temp\test.sql-->E:\temp-->E:\temp\test.sql
		// 判断文件父目录是否存在
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		try {
			file.transferTo(dest);
			return dest.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "upload file failed!";
		}
	}

	// 上传文件下载，主要是需求查看的时候,前端发请求的时候附带一个文件名参数
	@RequestMapping("/downloadFile")
	//@ResponseBody
	public String downloadFile(HttpServletResponse response, @RequestParam String filename) throws IOException{
		 if (filename != null) {
		// 文件名
			 log.info(filename);
		File file = new File("E:/temp/" ,filename);
		if (file.exists()) { // E:\temp\test.sql
			response.setContentType("application/force-download");
			//setHeader(name, value)：如果Header中没有定义则添加，如果已定义则用新的value覆盖; addHeader(name, value)：如果Header中没有定义则添加，如果已定义则保持原有value。
			response.setHeader("Content-Disposition", "attachment;fileName=" + new String(filename.getBytes("UTF-8"),"iso-8859-1"));// 修改下载文件的文件名,解决中文乱码
			
			byte[] buffer = new byte[1024];
			FileInputStream fis = null; // 文件输入流
			BufferedInputStream bis = null;

			try {
				OutputStream os = response.getOutputStream();// 输出流
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				int i = bis.read(buffer);
				while (i != -1) {
					//os.write(buffer);
					os.write(buffer,0,i);
					i = bis.read(buffer);
				}
				log.info("=========================文件下载" + filename);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(bis != null) {
					try {
						bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
			}
		}
	}
		return null;//"no file download!";???这里为什么这么处理就不会报错？
}
	
	// 上传文件删除,这里主要考虑直接删除服务器文件，在修改需求页面删除，则需要直接调用删库sql及删除服务器文件两个步骤
	@PostMapping("/deleteFile")
    public String delFile(String filename) {
    	String resultInfo = null;
		String filePath = "E:/temp/" + filename;
		File dest = new File(filePath);
		if (dest.exists()) {
			if (dest.delete()) {
				resultInfo =  "1-删除成功";
			} else {
				resultInfo =  "0-删除失败";
			}
		} else {
			resultInfo = "文件不存在！";
		}
		return resultInfo;
	}
	/*@PostMapping("del.json")
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
	}*/
}
