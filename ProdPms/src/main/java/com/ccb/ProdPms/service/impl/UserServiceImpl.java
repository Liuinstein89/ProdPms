package com.ccb.ProdPms.service.impl;

import com.ccb.ProdPms.entity.UserEntity;
import com.ccb.ProdPms.entity.UserQueryEntity;
import com.ccb.ProdPms.mapper.UserMapper;
import com.ccb.ProdPms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.HTMLDocument;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *     服务实现类
 * </p>
 */
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> getAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public List<UserEntity> getUserByParams(UserQueryEntity userQueryEntity) {
        return userMapper.selectUserByParams(userQueryEntity);

    }

    @Override
    @Transactional
    public void addUser(UserEntity userEntity) {
        if(userEntity.getUserName()!=null && !userEntity.getUserName().equals("")){
            try {
                userMapper.insertUser(userEntity);
            } catch (Exception e) {
                throw new RuntimeException("添加用户失败："+e.toString());
            }
        }else{
            throw new RuntimeException("用户姓名为空！");
        }

    }

    @Override
    @Transactional
    public void editUser(UserEntity userEntity) {
        if(userEntity.getUserName()!=null && !userEntity.getUserName().equals("")){
            try {
                userMapper.updateUser(userEntity);
            } catch (Exception e) {
                throw  new RuntimeException("修改用户信息失败："+e.toString());
            }
        }else{
            throw new RuntimeException("用户姓名为空！");
        }

    }

    @Override
    public void deletedUser(Integer id) {
        userMapper.deletedUser(id);
    }
}
