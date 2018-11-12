package com.ccb.ProdPms.service.impl;

import com.ccb.ProdPms.entity.ProjectTeamEntity;
import com.ccb.ProdPms.mapper.ProjectTeamMapper;
import com.ccb.ProdPms.service.ProjectTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProjectTeamServiceImpl implements ProjectTeamService {

    @Autowired
    private ProjectTeamMapper projectTeamMapper;

    @Override
    public List<ProjectTeamEntity> getProjectTeamList() {
        // 返回所有的项目组信息
        return projectTeamMapper.queryProjectTeam();
    }

    @Override
    public ProjectTeamEntity getProjectTeamById(int id) {
        return projectTeamMapper.queryProjectTeamById(id);
    }

    @Transactional
    @Override
    public boolean addProjectTeam(ProjectTeamEntity projectTeam) {
        // 空值判断，主要是判断TeamName不为空
        if (projectTeam.getTeamName() != null && !"".equals(projectTeam.getTeamName())) {
            // 设置默认值
            projectTeam.setCreateTime(new Date());
            projectTeam.setChangeTime(new Date());
            try {
                int effectedNum = projectTeamMapper.insertProjectTeam(projectTeam);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加项目组信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加项目组信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("项目组信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyProjectTeam(ProjectTeamEntity projectTeam) {
        // 空值判断，主要是id不为空
        if (projectTeam.getId() != null && projectTeam.getId() > 0) {
            // 设置默认值
            projectTeam.setChangeTime(new Date());

            try {
                // 更新项目组信息
                int effectedNum = projectTeamMapper.updateProjectTeam(projectTeam);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新项目组信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新项目组信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("项目组信息不能为空！");
        }

    }

    @Transactional
    @Override
    public boolean deleteProjectTeam(int id) {
        if (id > 0) {
            try {
                // 删除项目组信息
                int effectedNum = projectTeamMapper.deleteProjectTeam(id);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除项目组信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除项目组信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("项目组Id不能为空！");
        }
    }
}