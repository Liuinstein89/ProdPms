package com.ccb.ProdPms.entity;

import javax.persistence.*;

/**
 *@Entity 注解用于声明这是一个实体Bean
 * @Table 注解用于声明Entity所要映射的数据库表
 *
 * 另外要注意，@Entity必须与@Id注解 结合使用
 */
@Entity
@Table(name="user")
public class User {
    /**
     * @Id 注解用于声明一个实体类的属性映射为数据库的主键列
     * @Column 注解用来标识实体类中属性与数据表中字段的对应关系
     * @GeneratedValue 在JPA中,@GeneratedValue注解存在的意义主要就是为一个实体生成一个唯一标识的主键
     * (JPA要求每一个实体Entity,必须有且只有一个主键),@GeneratedValue还提供了主键的生成策略
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_dep")
    private String userDep;

    @Column(name = "email")
    private String email;

    @Column(name = "call")
    private String call;

    @Column(name = "sex")
    private String sex;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "modi_time")
    private String modiTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserDep() {
        return userDep;
    }

    public void setUserDep(String userDep) {
        this.userDep = userDep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModiTime() {
        return modiTime;
    }

    public void setModiTime(String modiTime) {
        this.modiTime = modiTime;
    }
}
