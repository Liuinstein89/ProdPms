package com.ccb.ProdPms.service.impl;

import com.ccb.ProdPms.entity.ProjectTeamEntity;
import com.ccb.ProdPms.exception.ResourceNotFoundException;
import com.ccb.ProdPms.mapper.ProjectTeamMapper;
import com.ccb.ProdPms.service.ProjectTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectTeamServiceImpl implements ProjectTeamService {

    @Autowired
    private ProjectTeamMapper projectTeamMapper;

    @Override
    public List<ProjectTeamEntity> getAll(){
        List<ProjectTeamEntity> proList = new ArrayList<ProjectTeamEntity>();
        try {
            proList = projectTeamMapper.getAll();
        } catch (Exception e) {
            e.getMessage();
        }
        return proList;
    }

    @Transactional
    public void updateProjectTeam(ProjectTeamEntity projectTeamEntity){
        projectTeamMapper.updateProjectTeam(projectTeamEntity);
    }

    @Override
    public List<ProjectTeamEntity> getByParams(ProjectTeamEntity projectTeamEntity){
        return null;
    }

    @Transactional
    public void deleteById(Integer id){
        ProjectTeamEntity projectTeamEntity = projectTeamMapper.findOne(id);
        if (projectTeamEntity == null) {
            throw new ResourceNotFoundException("找不到关键词，id：" + id);
        }
        try {
            projectTeamMapper.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Transactional
    public void insertProjectTeam(ProjectTeamEntity projectTeamEntity){
        projectTeamMapper.insertProjectTeam(projectTeamEntity);
    }

    @Override
    public int findByName(String teamName){
        int count = projectTeamMapper.findByName(teamName);
        return count;
    }

    @Transactional
    public void updateExcelProjectTeam(ProjectTeamEntity projectTeamEntity2){
        projectTeamMapper.updateExcelProjectTeam(projectTeamEntity2);
    }

}
