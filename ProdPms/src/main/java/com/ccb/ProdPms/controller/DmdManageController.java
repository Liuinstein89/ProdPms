package com.ccb.ProdPms.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

	
	
	
	
	//查询
	@GetMapping
	//插入，H5调用跨域用Jsonp
	@PostMapping
	//更新
	@PutMapping
	//删除，注意逻辑删除和物理删除的区别
	@DeleteMapping
	//以上是很标准的REST风格的接口形式，源码只不过是封装了 @RequestMapping( method = {RequestMethod.POST} ) 
	
	//获取参数几种常用的注解
/*	@PathVariable：一般我们使用URI template样式映射使用，即url/{param}这种形式，也就是一般我们使用的GET，DELETE，PUT方法会使用到的，我们可以获取URL后所跟的参数。
	@RequestParam：一般我们使用该注解来获取多个参数，在（）内写入需要获取参数的参数名即可，一般在PUT，POST中比较常用。
	@RequestBody：该注解和@RequestParam殊途同归，我们使用该注解将所有参数转换，在代码部分在一个个取出来，也是目前我使用到最多的注解来获取参数。
	当然，我们获取参数不仅仅只有上面所提到的，还有@RequestHeader来获取头信息里的值，@CookieValue来获取Cookie值等等
	
	@PostMapping("/createUserByMap")
	public void createUserByMap(@RequestBody Map<String,Object> reqMap){
	    String tel = reqMap.get("tel").toString();
	    String pwd = reqMap.get("pwd").toString();
	    userService.createUser(tel,pwd);
	    
	   }
	   //我们也可以通过POJO来直接获取参数，之后通过GET方法直接把需要的参数取出就好
	  @PostMapping("/createUser2")
		public void createUser2(UserInfo userInfo){
    		userService.createUser(userInfo.getTel(),userInfo.getPassWord());
		}
	   */
	//在使用对象进行参数接收时，我们可以对参数进行校验
	/*@Max(value = 999999,message = "超过最大数值")
		@Min(value = 000000,message = "密码设定不正确")
		private String passWord;*/
	//在controller中，将返回值设为String，可以看到报错信息。 然后给对象加入@Valid注解，并在参数中加入BindingResult来获取错误信息。在逻辑处理中我们判断BindingResult知否含有错误信息，如果有，则直接返回错误信息
	/*@PostMapping("/createUser2")
	public String createUser2(@Valid UserInfo userInfo, BindingResult bindingResult){
	    if (bindingResult.hasErrors()){
	        return bindingResult.getFieldError().getDefaultMessage();
	    }
	    userService.createUser(userInfo.getTel(),userInfo.getPassWord());
	    return "OK";
	}*/

	//第4种指定前端url请求参数名称与方法名一致，见下图，这种方式简单来说就是url请求格式中的参数需要与方法的参数名称对应上，举个例子，这么一个url请求http://localhost:8080/0919/test1?name=xxx&pwd=yyy，
	//在指定的控制器类上加上Controller注解，同时指定RequestMapping注解即可，当请求路径参数与方法参数匹配上时会自动注入 ,这种方式一般是get请求
	/*@RequestMapping("/xxx")
	@ResponseBody
	public String xxx(String xxxx,String xxxxx) {
		String s1 = xxxx;
		String s2 = xxxxx;
	}*/
	//第5种通过HttpServletRequest，调用request的getParameter获取参数，如访问http://localhost:8080/0919/test2?firstName=zhang&lastName=san,也可获取表单参数，get和post请求都可以 
	/*@RequestMapping("/xxx")
	@ResponseBody
	public String xxx(HttpServletRequest request) {
		String s1 = request.getParameter("xxxx");
		String s2 = request.getParameter("xxxxx");
	}*/
	
	
	
	
	
	
	
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
