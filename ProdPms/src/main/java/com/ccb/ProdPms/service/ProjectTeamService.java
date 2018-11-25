package com.ccb.ProdPms.service;

import com.ccb.ProdPms.entity.ProjectTeamEntity;

import java.util.List;

public interface ProjectTeamService {

    List<ProjectTeamEntity> getAll();

    void updateProjectTeam(ProjectTeamEntity projectTeamEntity);

    List<ProjectTeamEntity> getByParams(ProjectTeamEntity projectTeamEntity);

    void deleteById(Integer id);

    void insertProjectTeam(ProjectTeamEntity projectTeamEntity);

    int findByName(String teamName);

    void updateExcelProjectTeam(ProjectTeamEntity projectTeamEntity2);


}
