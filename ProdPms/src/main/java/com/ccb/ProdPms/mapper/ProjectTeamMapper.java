package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.ProjectTeamEntity;

import java.util.List;

public interface ProjectTeamMapper {

    /**
     * 列出项目组列表
     *
     * @return projectTeamList
     */
    List<ProjectTeamEntity> queryProjectTeam();

    /**
     * 根据Id列出具体项目组
     *
     * @return projectTeam
     */
    ProjectTeamEntity queryProjectTeamById(int id);

    /**
     * 插入项目组信息
     *
     * @param projectTeam
     * @return
     */
    int insertProjectTeam(ProjectTeamEntity projectTeam);

    /**
     * 更新项目组信息
     *
     * @param projectTeam
     * @return
     */
    int updateProjectTeam(ProjectTeamEntity projectTeam);

    /**
     * 删除项目组信息
     *
     * @param id
     * @return
     */
    int deleteProjectTeam(int id);
}