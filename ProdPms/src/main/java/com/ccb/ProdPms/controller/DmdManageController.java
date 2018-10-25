package com.ccb.ProdPms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.service.DmdManageService;

//@RestController
@Controller
// @EnableAutoConfiguration
// @RequestMapping("/demandManage")
public class DmdManageController {

	@Autowired
	DmdManageService dmdManageService;
	// @Autowired
	// private DmdService dmdService;

	// 创建需求项，提交n个文件，可以使office、pdf、图片等格式
	@RequestMapping(value = "/submitMultiUpload", method = RequestMethod.POST)
	@ResponseBody
	public String addReq(HttpServletRequest request) throws IOException {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		MultipartFile file = null;
		/*
		 * for(MultipartFile filess:files){ String fileName =
		 * filess.getOriginalFilename(); int size = (int) filess.getSize();
		 * System.out.println(fileName + "-->" + size);}
		 */
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			if (!file.isEmpty()) {
				String path = null;
				String fileName = null;
				File dest = new File(path + "/" + fileName);
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					file.transferTo(dest);
				} catch (Exception e) {
					e.printStackTrace();
					// return "false";
					return "You failed to upload " + i + " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + i + " because the file was empty.";
			}
		}
		return "upload successful";
	}
	/*public @ResponseBody String multifileUpload(@RequestParam("fileName")List<MultipartFile> files) 
    	  public @ResponseBody String multifileUpload(HttpServletRequest request)*/
	
	
/*	 @PostMapping("/dc/moreFileUpload")
	 	public String bacthFileUpload(MultipartFile[] file) throws MyException {
	 		StringBuffer buffer = new StringBuffer();
	 		for (MultipartFile multipartFile : file) {
	 			String str = fileUpload(multipartFile);
	 			buffer.append(str);
	 			buffer.append(",");
	 		}
	 		String all = buffer.substring(0, buffer.length() - 1);
	 		return all;
	 	}*/

	// 初始化列表显示全部已创建需求项，注意分页显示
	@RequestMapping(value = "/demand")
	public List<DmdManageEntity> getAll(DmdManageEntity demand) {
		List<DmdManageEntity> demandList = new ArrayList();
		return demandList;
	}

	/*
	 * 
	 * 
	 * @RequestMapping("/hello") public String index() { return"Hello World"; }
	 * 
	 * 
	 * @RequestMapping("/get")
	 * 
	 * @ResponseBody public String get(User user) { User
	 * u=userService.getNameById(user);
	 * 
	 * return JSONObject.toJSONString(u); }
	 */
	// 新增需求提交时，多上传文件插入数据库的操作

	/*
	 * @GetMapping("/autoreply/keywords") public
	 * List<KeywordReply>getAllKeywordRules() { return
	 * replyService.getAllKeywordRules(); }
	 */

	/*
	 * @PostMapping("/autoreply/keyword/rule") public KeywordReply
	 * saveKeywordRule(@RequestBody KeywordRuleDto rule) { if
	 * (StringUtils.isEmpty(rule.getId())) { return
	 * replyService.addKeywordRule(rule); } else { return
	 * replyService.updateKeywordRule(rule); } }
	 */

}
