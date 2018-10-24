package com.ccb.ProdPms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ccb.ProdPms.service.DmdManageService;

@Controller
// @EnableAutoConfiguration
// @RequestMapping("/demandManage")
public class DmdManageController {

	@Autowired
	DmdManageService dmdManageService;
	// @Autowired
	// private DmdService dmdService;

	/*
	 * @RequestMapping(value = "/demand") public List<DmdManageEntity>
	 * getAll(DmdManageEntity demand) { List<DmdManageEntity> demandList = new
	 * ArrayList(); return demandList; }
	 */

	/*
	 * @Autowired private UserService userService;
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
	@RequestMapping(value = "/submitMultiUpload", method = RequestMethod.POST)
	// @ResponseBody
	public String addReq(HttpServletRequest request) {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		/*
		 * for(MultipartFile filess:files){ String fileName =
		 * filess.getOriginalFilename(); int size = (int) filess.getSize();
		 * System.out.println(fileName + "-->" + size);}
		 */
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
					stream.write(bytes);
					stream.close();

				} catch (Exception e) {
					stream = null;
					return "You failed to upload " + i + " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + i + " because the file was empty.";
			}
		}
		return "upload successful";
	}

	/*
	 * @GetMapping("/autoreply/keywords") public List<KeywordReply>
	 * getAllKeywordRules() { return replyService.getAllKeywordRules(); }
	 */

	/*
	 * @PostMapping("/autoreply/keyword/rule") public KeywordReply
	 * saveKeywordRule(@RequestBody KeywordRuleDto rule) { if
	 * (StringUtils.isEmpty(rule.getId())) { return
	 * replyService.addKeywordRule(rule); } else { return
	 * replyService.updateKeywordRule(rule); } }
	 */

}
