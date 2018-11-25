package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.ProjectTeamEntity;

import java.util.List;

public interface ProjectTeamMapper {

    List<ProjectTeamEntity> getAll();

    void updateProjectTeam(ProjectTeamEntity projectTeamEntity);

    ProjectTeamEntity findOne(Integer id);

    void deleteById(Integer id);

    void insertProjectTeam(ProjectTeamEntity projectTeamEntity);

    int findByName(String teamName);

    void updateExcelProjectTeam(ProjectTeamEntity projectTeamEntity2);


}