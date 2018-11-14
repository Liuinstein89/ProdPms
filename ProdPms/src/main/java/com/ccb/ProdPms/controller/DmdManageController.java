package com.ccb.ProdPms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.dto.DmdItemFuncDto;
import com.ccb.ProdPms.dto.OnlinePlanFuncDto;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.DmdQueryParamsEntity;
import com.ccb.ProdPms.entity.OnlinePlanEntity;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.entity.UploadFileEntity;
import com.ccb.ProdPms.service.DmdManageService;
import com.ccb.ProdPms.service.DmdOnlinePlanService;
import com.ccb.ProdPms.util.RespCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

//@RestController
@Controller
@EnableAutoConfiguration
// @RequestMapping("/demandManage")
public class DmdManageController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	private static String strSuc = "success";
	private static String UPLOADED_FILEPATH = "E://temp//";
	// private int pageNum ;
	// private int pageSize = 10;
	@Autowired
	DmdManageService dmdManageService;
 
	@Autowired
	DmdOnlinePlanService dmdOnlinePlanService;

	// 查询: @GetMapping
	// 插入，H5调用跨域用Jsonp: @PostMapping
	// 更新 @PutMapping
	// 删除，注意逻辑删除和物理删除的区别: @DeleteMapping
	// 以上是标准的REST风格的接口，源码是封装了: @RequestMapping( method = {RequestMethod.POST} )

	@RequestMapping("/admin")
	public String helloHtml() {
		return "admin";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping("/admin/list")
	public String list() {
		return "demand-list";
	}

	@RequestMapping("/admin/add")
	public String add() {
		return "demand-add";
	}

	@RequestMapping("/admin/edit")
	public String edit() {
		return "demand-edit";
	}

	@RequestMapping("/admin/search")
	public String search() {
		return "demand-search";
	}


	// 初始化列表显示全部已创建需求项，注意分页显示
	@GetMapping("/demand")
	@ResponseBody
	// public List<DmdManageEntity> getAll(@RequestBody DmdManageEntity demand)
	// public PageInfo<DmdManageEntity> getAll(DmdManageEntity demand){
	public String getAll(@RequestParam(value = "page") Integer pageNum,
			@RequestParam(value = "limit") Integer pageSize) {
		// PageHelper.startPage下一行紧跟查询语句，不可以写其他的，否则没有效果;直接return
		// demandlist可以吧json格式数据返回前台，但是没有count，pages等数据
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<DmdManageEntity> dmdPageInfo = new PageInfo<>(dmdManageService.getAll());
		RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, dmdPageInfo);
		return JSONObject.toJSONString(restResp);
	}

	// 检索，普通检索和高级检索写一块，通过传参分辨，注意分页显示
	@GetMapping("/search")
	@ResponseBody
	public String search(@RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize,
			HttpServletRequest request) {

		// Form接参
		String reqNo = request.getParameter("reqNo");
		String reqName = request.getParameter("reqName");
		String reqSource = request.getParameter("reqSource");
		String dept = request.getParameter("dept");
		String execType = request.getParameter("execType");
		String leadTeam = request.getParameter("leadTeam");
		String nextUser = request.getParameter("nextUser");
		String reqStatus = request.getParameter("reqStatus");
		String beginDate = ("".equals(request.getParameter("beginDate"))) ? "1970-1-1"
				: request.getParameter("beginDate");
		String endDate = ("".equals(request.getParameter("endDate"))) ? "2099-12-31"
				: request.getParameter("endDate");
		// String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new
		// Date());
		DmdQueryParamsEntity queryParams = new DmdQueryParamsEntity(reqNo, reqName, reqSource, dept, execType, leadTeam,
				nextUser, reqStatus, beginDate, endDate);
		List<DmdManageEntity> dmdSearList = new ArrayList<DmdManageEntity>();
		PageHelper.startPage(pageNum, pageSize);
		dmdSearList = dmdManageService.getByParams(queryParams);
		PageInfo<DmdManageEntity> dsPageInfo = new PageInfo<>(dmdSearList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "ok");
		map.put("data", dsPageInfo);
		return JSONObject.toJSONString(map);
	}

	// 自动获取reqNo,规则是数据库当前需求PR(prod_req)-日期年月日(YYYYMMDD)-id++
	@GetMapping("/getReqNo")
	public String getReqNo() {
		String reqNo = dmdManageService.getReqNo();
		// reqNo ="PR" + sdf12.format(date) +reqNo;
		return "PR" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + reqNo;
	}

	// 创建需求项,提交多个文件,可以使office、pdf、图片等格式
	@RequestMapping(value = "/submitMultiUpload", method = RequestMethod.POST)
	@ResponseBody
	public String addReq(HttpServletRequest request) throws IOException {

		// Form接参
		String reqNo = request.getParameter("reqNo");
		String reqName = request.getParameter("reqName");
		String reqSource = request.getParameter("reqSource");
		String dept = request.getParameter("dept");
		String execType = request.getParameter("execType");
		String leadTeam = request.getParameter("leadTeam");
		String cooTeam = request.getParameter("cooTeam");
		String nowUser = request.getParameter("nowUser");
		String nextUser = request.getParameter("nextUser");
		String createUser = request.getParameter("createUser");
		String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		DmdManageEntity dmdManageEntity = new DmdManageEntity(reqNo, reqName, reqSource, dept, execType, leadTeam,
				cooTeam, nowUser, nextUser, createUser, createDate, "reqAddStatus", 0);

		// 多文件上传接参
		// MultipartHttpServletRequest rq = (MultipartHttpServletRequest) request;
		// System.out.println("@@@@@@@@@@@"+rq.toString());

		// 创建一个多分解的容器
		// CommonsMultipartResolver cmr = new
		// CommonsMultipartResolver(request.getSession().getServletContext());
		// 设置编码
		// cmr.setDefaultEncoding("utf-8");
		// 判断是否有文件上传
		// if(cmr.isMultipart(request)){
		// 将request转换成多分解请求
		// MultipartHttpServletRequest mhs = cmr.resolveMultipart(request);

		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
		List<MultipartFile> fileList = multipartRequest.getFiles("file");

		// List<MultipartFile> fileList = ((MultipartHttpServletRequest)
		// request).getFiles("file");
		System.out.println("111111" + fileList.size());
		// 新增需求主表项
		try {
			dmdManageService.addReq(dmdManageEntity);
		} catch (Exception e) {
			e.getMessage();
			return "create req failed! ";
		}

		// 循环插入上传文件到指定路径
		for (MultipartFile file : fileList) {
			System.out.println("2222" + file.getName());
			if (file.isEmpty()) {
				return "no upload file!";
			}
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				log.info(fileName);
				File dest = new File(UPLOADED_FILEPATH + fileName);
				UploadFileEntity uploadFileEntity = new UploadFileEntity(fileName, UPLOADED_FILEPATH,
						file.getContentType(), nowUser, reqNo, 0);
				// System.out.println(dest.getName() + "-->" + dest.getPath() + "-->" +
				// dest.getParentFile() + "-->" + dest);
				// test.sql-->E:\temp\test.sql-->E:\temp-->E:\temp\test.sql
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					file.transferTo(dest);
					try {
						System.out.println("333" + file.getName());
						dmdManageService.insertUpload(uploadFileEntity);
					} catch (Exception e) {
						e.getMessage();
						return "insert upload failed!";
					}
				} catch (Exception e) {
					e.printStackTrace();
					return "You failed to upload " + file.getName() + " => " + e.getMessage();
				}
			} /*
				 * else { return "You failed to upload " + file.getName() +
				 * " because the file was empty."; }
				 */
		}
		return "upload successful";
	}
	/*
	 * public @ResponseBody String
	 * multifileUpload(@RequestParam("fileName")List<MultipartFile> files)
	 * public @ResponseBody String multifileUpload(HttpServletRequest request)
	 */

	// 编辑需求项
	@RequestMapping(value = "/updateReq", method = RequestMethod.POST)
	// @PutMapping("/updateReq")
	@ResponseBody
	public String updateReq(HttpServletRequest request) throws IOException {
		// Form接参
		String reqNo = request.getParameter("reqNo");
		String reqName = request.getParameter("reqName");
		String reqSource = request.getParameter("reqSource");
		String dept = request.getParameter("dept");
		String execType = request.getParameter("execType");
		String leadTeam = request.getParameter("leadTeam");
		String cooTeam = request.getParameter("cooTeam");
		String nowUser = request.getParameter("nowUser");
		String nextUser = request.getParameter("nextUser");
		String modiDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		DmdManageEntity dmdManageEntity = new DmdManageEntity(reqNo, reqName, reqSource, dept, execType, leadTeam,
				cooTeam, nowUser, nextUser, "reqAddStatus", modiDate);

		// 修改需求主表项
		try {
			dmdManageService.updateReq(dmdManageEntity);
		} catch (Exception e) {
			e.getMessage();
			return "update req failed! ";
		}
		return JSONObject.toJSONString(strSuc);
	}

	// 新增需求对应的需求项，一对多的关系,如果第一次创建需求项时候录入了功能点，则一次性保存，如果没有录入，则单独保存
	@PostMapping("/addReqItem")
	public String addReqItem(DmdItemFuncDto dmdItemFuncDto) {
		dmdManageService.insertDmdItem(dmdItemFuncDto);
		return "详情列表";
	}

	// 新增需求对应的上线计划，和需求项相互独立，一个需求对应多个上线计划，当上线计划完成时，再录入该计划完成的功能点，此时可以和需求项对应的功能点作对比，看看是否完全完成
	@PostMapping("/addOnlinePlan")
	public String addOnlinePlan(OnlinePlanEntity olEntity) {
		dmdOnlinePlanService.insertOnlinePlan(olEntity);
		return "详情列表";
	}

	// 新增需求对应的上线计划，和需求项相互独立，一个需求对应多个上线计划，当上线计划完成时，再录入该计划完成的功能点，此时可以和需求项对应的功能点作对比，看看是否完全完成
	@PostMapping("/addOnlinePlanFunc")
	public String addOnlinePlanFunc(OnlinePlanFuncDto opfDto) {
		dmdOnlinePlanService.insertOnlinePlanFunc(opfDto);
		return "详情列表";
	}

	// 删除需求
	@GetMapping("/delReqById")
	@ResponseBody
	public String deleteReqById(@RequestParam(value = "id") Integer id) {
		dmdManageService.deleteReqById(id);

		return JSONObject.toJSONString(strSuc);
	}
	// 获取参数几种常用的注解
	/*
	 * @PathVariable：一般我们使用URI
	 * template样式映射使用，即url/{param}这种形式，也就是一般我们使用的GET，DELETE，PUT方法会使用到的，
	 * 我们可以获取URL后所跟的参数。
	 * 
	 * @RequestParam：一般我们使用该注解来获取多个参数，在（）内写入需要获取参数的参数名即可，一般在PUT，POST中比较常用。
	 * 
	 * @RequestBody：该注解和@RequestParam殊途同归，我们使用该注解将所有参数转换，在代码部分在一个个取出来，
	 * 也是目前我使用到最多的注解来获取参数。
	 * 当然，我们获取参数不仅仅只有上面所提到的，还有@RequestHeader来获取头信息里的值，@CookieValue来获取Cookie值等等
	 * 
	 * @PostMapping("/createUserByMap") public void createUserByMap(@RequestBody
	 * Map<String,Object> reqMap){ String tel = reqMap.get("tel").toString(); String
	 * pwd = reqMap.get("pwd").toString(); userService.createUser(tel,pwd);
	 * 
	 * } //我们也可以通过POJO来直接获取参数，之后通过GET方法直接把需要的参数取出就好
	 * 
	 * @PostMapping("/createUser2") public void createUser2(UserInfo userInfo){
	 * userService.createUser(userInfo.getTel(),userInfo.getPassWord()); }
	 */
	// 在使用对象进行参数接收时，我们可以对参数进行校验
	/*
	 * @Max(value = 999999,message = "超过最大数值")
	 * 
	 * @Min(value = 000000,message = "密码设定不正确") private String passWord;
	 */
	// 在controller中，将返回值设为String，可以看到报错信息。
	// 然后给对象加入@Valid注解，并在参数中加入BindingResult来获取错误信息。在逻辑处理中我们判断BindingResult知否含有错误信息，如果有，则直接返回错误信息
	/*
	 * @PostMapping("/createUser2") public String createUser2(@Valid UserInfo
	 * userInfo, BindingResult bindingResult){ if (bindingResult.hasErrors()){
	 * return bindingResult.getFieldError().getDefaultMessage(); }
	 * userService.createUser(userInfo.getTel(),userInfo.getPassWord()); return
	 * "OK"; }
	 */

	// 第4种指定前端url请求参数名称与方法名一致，见下图，这种方式简单来说就是url请求格式中的参数需要与方法的参数名称对应上，举个例子，这么一个url请求http://localhost:8080/0919/test1?name=xxx&pwd=yyy，
	// 在指定的控制器类上加上Controller注解，同时指定RequestMapping注解即可，当请求路径参数与方法参数匹配上时会自动注入
	// ,这种方式一般是get请求
	/*
	 * @RequestMapping("/xxx")
	 * 
	 * @ResponseBody public String xxx(String xxxx,String xxxxx) { String s1 = xxxx;
	 * String s2 = xxxxx; }
	 */
	// 第5种通过HttpServletRequest，调用request的getParameter获取参数，如访问http://localhost:8080/0919/test2?firstName=zhang&lastName=san,也可获取表单参数，get和post请求都可以
	/*
	 * @RequestMapping("/xxx")
	 * 
	 * @ResponseBody public String xxx(HttpServletRequest request) { String s1 =
	 * request.getParameter("xxxx"); String s2 = request.getParameter("xxxxx"); }
	 */

	/*
	 * 
	 * @RequestMapping("/get")
	 * 
	 * @ResponseBody public String get(User user) { User
	 * u=userService.getNameById(user);
	 * 
	 * return JSONObject.toJSONString(u); }
	 */

	/*
	 * @PostMapping("/autoreply/keyword/rule") public KeywordReply
	 * saveKeywordRule(@RequestBody KeywordRuleDto rule) { if
	 * (StringUtils.isEmpty(rule.getId())) { return
	 * replyService.addKeywordRule(rule); } else { return
	 * replyService.updateKeywordRule(rule); } }
	 */

}
