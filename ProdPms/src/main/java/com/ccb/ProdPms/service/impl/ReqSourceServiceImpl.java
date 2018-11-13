package com.ccb.ProdPms.service.impl;

import com.ccb.ProdPms.entity.ReqSourceEntity;
import com.ccb.ProdPms.mapper.ReqSourceMapper;
import com.ccb.ProdPms.service.ReqSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReqSourceServiceImpl  implements ReqSourceService {


    @Autowired
    private ReqSourceMapper reqSourceMapper;

    @Override
    public List<ReqSourceEntity> getReqSourceList() {
        // 返回所有的需求来源信息
        return reqSourceMapper.queryReqSource();
    }

    @Override
    public ReqSourceEntity getReqSourceById(int id) {
        return reqSourceMapper.queryReqSourceById(id);
    }

    @Transactional
    @Override
    public boolean addReqSource(ReqSourceEntity reqSource) {
        // 空值判断，主要是判断SouceName不为空
        if (reqSource.getSouceName() != null && !"".equals(reqSource.getSouceName())) {
            // 设置默认值
            reqSource.setCreateTime(new Date());
            reqSource.setChangeTime(new Date());
            try {
                int effectedNum = reqSourceMapper.insertReqSource(reqSource);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加需求来源信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加需求来源信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("需求来源信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyReqSource(ReqSourceEntity reqSource) {
        // 空值判断，主要是id不为空
        if (reqSource.getId() != null && reqSource.getId() > 0) {
            // 设置默认值
            reqSource.setChangeTime(new Date());

            try {
                // 更新需求来源信息
                int effectedNum = reqSourceMapper.updateReqSource(reqSource);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新需求来源信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新需求来源信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("需求来源信息不能为空！");
        }

    }

    @Transactional
    @Override
    public boolean deleteReqSource(int id) {
        if (id > 0) {
            try {
                // 删除需求来源信息
                int effectedNum = reqSourceMapper.deleteReqSource(id);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除需求来源信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除需求来源信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("需求来源Id不能为空！");
        }
    }
}