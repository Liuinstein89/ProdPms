package com.ccb.ProdPms.entity;

import com.ccb.ProdPms.util.UserSexType;

public class UserQueryEntity {
    private static final long serialVersionUID = 1L;

    private String id;
    private String userName, userPassword, userDep, email, cal;
    private String beginDate, endDate;
    private String sex;

    public UserQueryEntity(String id, String userName, String userPassword, String userDep,
                            String email, String call, String beginDate, String  endDate, String sex){
        this.id=id;
        this.userName=userName;
        this.userPassword=userPassword;
        this.userDep=userDep;
        this.email=email;
        this.cal=call;
        this.sex=sex;
        this.beginDate=beginDate;
        this.endDate=endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String  sex) {
        this.sex = sex;
    }
}
