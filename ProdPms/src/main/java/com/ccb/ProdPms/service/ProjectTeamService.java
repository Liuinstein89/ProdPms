package com.ccb.ProdPms.service;

import com.ccb.ProdPms.entity.ProjectTeamEntity;

import java.util.List;

public interface ProjectTeamService {

    /**
     * 获取项目组列表
     *
     * @return
     */
    List<ProjectTeamEntity> getProjectTeamList();

    /**
     * 通过Id获取项目组信息
     *
     * @param id
     * @return
     */
    ProjectTeamEntity getProjectTeamById(int id);

    /**
     * 增加项目组信息
     *
     * @param projectTeam
     * @return
     */
    boolean addProjectTeam(ProjectTeamEntity projectTeam);

    /**
     * 修改项目组信息
     *
     * @param projectTeam
     * @return
     */
    boolean modifyProjectTeam(ProjectTeamEntity projectTeam);

    /**
     * 删除项目组信息
     *
     * @param id
     * @return
     */
    boolean deleteProjectTeam(int id);

}
