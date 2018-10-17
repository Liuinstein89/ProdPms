package com.ccb.ProdPms.mapper;

import com.ccb.ProdPms.entity.DmdManageEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Component
//@Mapper
public interface DmdManageMapper {

    @Select("SELECT * FROM req where is_deleted = 0")
    @Results({
            //@Result(property = "userSex", column = "user_sex", javaType = UserSexType.class),
            @Result(property = "id", column = "id"),
            @Result(property = "reqNo", column = "req_no"),
            @Result(property = "reqName", column = "req_name"),
            @Result(property = "reqSource", column = "req_source"),
            @Result(property = "dept", column = "dept"),
            @Result(property = "execType", column = "exec_type"),
            @Result(property = "leadTeam", column = "lead_team"),
            @Result(property = "cooTeam", column = "coo_team"),
            @Result(property = "nowUser", column = "now_user"),
            @Result(property = "nextUser", column = "next_user"),
            @Result(property = "createUesr", column = "create_uesr"),
            @Result(property = "reqStatus", column = "req_status"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "modiDate", column = "modi_date")
    })
    List<DmdManageEntity> getAll();

    /*@Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "reqNo", column = "req_no"),
            @Result(property = "reqName", column = "req_name"),
            @Result(property = "reqSource", column = "req_source"),
            @Result(property = "dept", column = "dept"),
            @Result(property = "execType", column = "exec_type"),
            @Result(property = "leadTeam", column = "lead_team"),
            @Result(property = "cooTeam", column = "coo_team"),
            @Result(property = "nowUser", column = "now_user"),
            @Result(property = "nextUser", column = "next_user"),
            @Result(property = "createUesr", column = "create_uesr"),
            @Result(property = "reqStatus", column = "req_status"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "modiDate", column = "modi_date")
    })*/
    List<DmdManageEntity> getByParams(Long id);

   /* @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(UserEntity user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);*/

}
