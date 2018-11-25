package com.ccb.ProdPms.entity;

import com.ccb.ProdPms.util.UserSexType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName, userPassword, userDep, email, call;
    private String createTime, modiTime;
    private String sex;
    private int isDeleted;

    public UserEntity(){

    }

    public UserEntity(String userName, String userPassword, String userDep,
                      String email, String call,  String createTime, String modiTime, String sex){
        this.userName=userName;
        this.userPassword=userPassword;
        this.userDep=userDep;
        this.email=email;
        this.call=call;
        this.createTime=createTime;
        this.modiTime=modiTime;
        this.sex= sex;
    }
    public UserEntity(Integer id, String userName, String userPassword, String userDep,String email, String call, String modiTime, String sex){
        this.id=id;
        this.userName=userName;
        this.userPassword=userPassword;
        this.userDep=userDep;
        this.email=email;
        this.call=call;
        this.modiTime=modiTime;
        this.sex=sex;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public String toString(){
        return "user[id="+id+",name="+userName+",dept="+userDep+"]";
    }
}
