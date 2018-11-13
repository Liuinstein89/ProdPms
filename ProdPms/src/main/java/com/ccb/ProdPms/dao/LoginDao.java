package com.ccb.ProdPms.dao;

import com.ccb.ProdPms.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository注解可以标记在任何的类上，用来表明该类是用来执行与数据库相关的操作（即dao对象），并支持自动处理数据库操作产生的异常
//CrudRepository 接口继承于 Repository 接口，并新增了简单的增、删、查等方法
@Repository
public interface LoginDao extends CrudRepository<User , Long> {

  public List<User> findByUsernameAndPassword(String name, String password);
}
