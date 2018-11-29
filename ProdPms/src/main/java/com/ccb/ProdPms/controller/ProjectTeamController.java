package com.ccb.ProdPms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.entity.ProjectTeamEntity;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.service.ProjectTeamService;
import com.ccb.ProdPms.util.ExcelUtil;
import com.ccb.ProdPms.util.RespCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@EnableAutoConfiguration
@Slf4j
public class ProjectTeamController {

    @Autowired
    ProjectTeamService projectTeamService;
    private static String strSuc = "success";

    @GetMapping("/listProTeam")
    public String getAll(@RequestParam(value = "page") Integer pageNum,
                         @RequestParam(value = "limit") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ProjectTeamEntity> proPageInfo = new PageInfo<>(projectTeamService.getAll());
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, proPageInfo);
        log.debug("");
        return JSONObject.toJSONString(restResp);
    }


 // 新增
    @PostMapping("/addProTeam")
    public String addProTeam(HttpServletRequest request) {
    	 // Form接参
        Long teammateNum = Long.parseLong(request.getParameter("teammateNum"));
        String teamName = request.getParameter("teamName");
        String belongDptCode = request.getParameter("belongDptCode");
        String teamLeader = request.getParameter("teamLeader");
        String teammate = request.getParameter("teammate");
        String opPerson = request.getParameter("opPerson");
        String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ProjectTeamEntity projectTeamEntity = new ProjectTeamEntity(teammateNum,teamName, belongDptCode,  teamLeader, teammate, opPerson, createTime);
       
 int count = projectTeamService.findByName(teamName);
        if (count > 0) {
            String changeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            ProjectTeamEntity projectTeamEntity2 = new  ProjectTeamEntity(teammateNum,teamName, belongDptCode, teamLeader, teammate, changeTime);
            projectTeamService.updateExcelProjectTeam( projectTeamEntity2);
        } else {
            projectTeamService.insertProjectTeam(projectTeamEntity);
       
        }
        return JSONObject.toJSONString(strSuc);
    }

 // 编辑
    @RequestMapping(value = "/updateProTeam", method = RequestMethod.POST)
    public String updateProTeam(HttpServletRequest request) throws IOException {
    	 // Form接参
        Long id = Long.parseLong(request.getParameter("id"));
        Long teammateNum = Long.parseLong(request.getParameter("teammateNum"));
        String teamName = request.getParameter("teamName");
        String belongDptCode = request.getParameter("belongDptCode");
        String teamLeader = request.getParameter("teamLeader");
        String teammate = request.getParameter("teammate");
        String changeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ProjectTeamEntity projectTeamEntity = new ProjectTeamEntity(id,teammateNum, teamName, belongDptCode, teamLeader, teammate,changeTime);

     // 修改需求主表项
        try {
            projectTeamService.updateProjectTeam(projectTeamEntity);
        } catch (Exception e) {
            e.getMessage();
            return "update ProTeam failed! ";
        }
        return JSONObject.toJSONString(strSuc);
    }

    // 删除
    @GetMapping("/delProTeamById")
    @ResponseBody
    public String deleteProTeamById(@RequestParam(value = "id") Integer id) {
        projectTeamService.deleteById(id);
        return JSONObject.toJSONString(strSuc);
    }



    // ���ݵ�����Ҫ�漰�������� 1.�ļ��ϴ���2.Excel������3.���ݲ��롣
    @RequestMapping(value = "/importProjectTeamExcel", method = RequestMethod.POST)
    public String importProjectTeamExcel(MultipartFile file, @RequestParam(value = "userName") String userName) {
        if (file == null)
            return "file不能为空";
        String fileName = file.getOriginalFilename();
        try {
            List<Object[]> projectTeamList = ExcelUtil.importExcel(fileName, file);
            ProjectTeamEntity projectTeamEntity = new  ProjectTeamEntity();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", "-1");
            if (projectTeamList.size() == 0)
                return JSONObject.toJSONString(map);
            for (int i = 0; i <projectTeamList.size(); i++) {
                String teamName = (String) projectTeamList.get(i)[0];
                String belongDptCode = (String) projectTeamList.get(i)[1];
                String teamLeader= (String) projectTeamList.get(i)[2];
                String teammate= (String) projectTeamList.get(i)[3];
                Long teammateNum = Long.parseLong ((String)projectTeamList.get(i)[4]);

                projectTeamEntity.setTeamName(teamName);
                projectTeamEntity.setBelongDptCode(belongDptCode);
                projectTeamEntity.setTeamLeader(teamLeader);
                projectTeamEntity.setTeammate(teammate);
                projectTeamEntity.setTeammateNum(teammateNum);
                projectTeamEntity.setOpPerson(userName);
                projectTeamEntity.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

                int count = projectTeamService.findByName(teamName);
                if (count > 0) {
                    String changeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    ProjectTeamEntity projectTeamEntity2 = new  ProjectTeamEntity(teammateNum,teamName, belongDptCode, teamLeader, teammate, changeTime);
                    projectTeamService.updateExcelProjectTeam( projectTeamEntity2);
                } else {
                    projectTeamService.insertProjectTeam(projectTeamEntity);
                }
            }
        }  catch (Exception e) {
            log.error(e.getMessage(), e);
            RestRespEntity restResp = new RestRespEntity(RespCode.WARN, null);
            return JSONObject.toJSONString(restResp);
        }
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, null);
        return JSONObject.toJSONString(restResp);
    }


}
