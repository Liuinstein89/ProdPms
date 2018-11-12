package com.ccb.ProdPms.mapper;

import java.util.List;

import com.ccb.ProdPms.entity.DmdItemEntity;
import com.ccb.ProdPms.entity.DmdItemFuncEntity;
import com.ccb.ProdPms.entity.DmdManageEntity;
import com.ccb.ProdPms.entity.DmdQueryParamsEntity;
import com.ccb.ProdPms.entity.UploadFileEntity;

//@Component
//@Mapper
public interface DmdManageMapper {
	// 注解和xml两者能否共存？怎么共存？
	/*
	 * @Select("SELECT * FROM req where is_deleted = 0")
	 * 
	 * @Results(id="123",value = { //@Result(property = "userSex", column =
	 * "user_sex", javaType = UserSexType.class),
	 * 
	 * @Result(property = "id", column = "id"),
	 * 
	 * @Result(property = "reqNo", column = "req_no"),
	 * 
	 * @Result(property = "reqName", column = "req_name"),
	 * 
	 * @Result(property = "reqSource", column = "req_source"),
	 * 
	 * @Result(property = "dept", column = "dept"),
	 * 
	 * @Result(property = "execType", column = "exec_type"),
	 * 
	 * @Result(property = "leadTeam", column = "lead_team"),
	 * 
	 * @Result(property = "cooTeam", column = "coo_team"),
	 * 
	 * @Result(property = "nowUser", column = "now_user"),
	 * 
	 * @Result(property = "nextUser", column = "next_user"),
	 * 
	 * @Result(property = "createUesr", column = "create_uesr"),
	 * 
	 * @Result(property = "reqStatus", column = "req_status"),
	 * 
	 * @Result(property = "createDate", column = "create_date"),
	 * 
	 * @Result(property = "modiDate", column = "modi_date") })
	 */
	List<DmdManageEntity> getAll();

	/*
	 * @Select("SELECT * FROM users WHERE id = #{id}")
	 * 
	 * @ResultMap("123")
	 */
	List<DmdManageEntity> getByParams(DmdQueryParamsEntity dmdQueryParamsEntity);

	void insert(DmdManageEntity dmdManageEntity);

	void insertUpload(UploadFileEntity uploadFileEntity);

	void insertDmdItem(DmdItemEntity dmdItemEntity);
	
	void insertDmdItemFunc(DmdItemFuncEntity dmdItemFuncEntity);

	// There is no getter for property named 'tableName' in 'class
	// java.lang.String',Mybatis默认采用ONGL解析参数，所以会自动采用对象树的形式取 string.xxx
	// 值，如果没在在方法中定义,则会抛异常报错。如果用第二种，mapper.xml中参数改为#{_parameter}，第一种可以不用管，用#{tableName}
	// void methodName(@Param(value="tableName") String tableName );
	void alterTableAutoIncre(String tableName);

	int selectCount();

	int getLastId();

	// void update(UserEntity user);

	void deleteById(Integer id);

	void updateReq(DmdManageEntity dmdManageEntity);

	DmdManageEntity findOne(Integer id);

}
