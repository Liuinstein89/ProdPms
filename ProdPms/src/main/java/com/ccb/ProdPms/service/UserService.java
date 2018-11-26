package com.ccb.ProdPms.service;

import com.ccb.ProdPms.entity.User;
import com.ccb.ProdPms.entity.UserEntity;
import com.ccb.ProdPms.entity.UserQueryEntity;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *     服务类
 * </p>
 */

public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    List<UserEntity> getAllUser();

    /**
     * 按照条件查询用户
     * @return
     */
    List<UserEntity> getUserByParams(UserQueryEntity userQueryEntity);
    /**
     * 新增用户
     * @param userEntity
     */
    void addUser(UserEntity userEntity);

    /**
     * 修改用户信息
     * @param userEntity
     */
    void editUser(UserEntity userEntity);

    /**
     * 删除用户
     * @param id
     */
    void deletedUser(Integer id);

}
