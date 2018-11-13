package com.ccb.ProdPms.controller;

import com.ccb.ProdPms.entity.ProjectTeamEntity;
import com.ccb.ProdPms.service.ProjectTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projectTeam")
public class ProjectTeamController {

    @Autowired
    private ProjectTeamService projectTeamService;

    @GetMapping("/query/{id}")
    public ProjectTeamEntity getProjectTeam(@PathVariable("id") Integer id){
        return projectTeamService.getProjectTeamById(id);
    }

    @GetMapping("/queryAll")
    public List<ProjectTeamEntity> getAllProjectTeam(){
        return projectTeamService.getProjectTeamList();
    }

    @GetMapping("/add")
    public ProjectTeamEntity insertProjectTeam(ProjectTeamEntity projectTeam){
        projectTeamService.addProjectTeam(projectTeam);
        return projectTeam;
    }

    @GetMapping("/modify")
    public ProjectTeamEntity updateDept(ProjectTeamEntity projectTeam){
        projectTeamService.modifyProjectTeam(projectTeam);
        return projectTeam;
    }

    @GetMapping("/delete/{id}")
    public void deleteProjectTeam(@PathVariable("id") Integer id){
        projectTeamService.deleteProjectTeam(id);
    }


}