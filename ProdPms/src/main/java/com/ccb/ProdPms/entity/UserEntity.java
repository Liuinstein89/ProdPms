package com.ccb.ProdPms.entity;

import com.ccb.ProdPms.util.UserSexType;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String userName, userPassword, userDep, email, call;
    private Date createDate, modiDate;
    private UserSexType sex;

    public UserSexType getSex() {
        return sex;
    }

    public void setSex(UserSexType sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModiDate() {
        return modiDate;
    }

    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
    }
}
