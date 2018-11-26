package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.UserEntity;
import com.ccb.ProdPms.entity.UserQueryEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface UserMapper {
    // 查询所有用户
    List<UserEntity> selectAllUser();

    // 按照条件查询用户
    List<UserEntity> selectUserByParams(UserQueryEntity userQueryEntity);

    // 添加用户
    void insertUser(UserEntity userEntity);

    // 修改用户
    void updateUser(UserEntity userEntity);

    // 删除用户
    void deletedUser(Integer id);

	UserEntity getByName(String nowUser);

}
