package com.ccb.ProdPms.service.impl;

import com.ccb.ProdPms.dao.LoginDao;
import com.ccb.ProdPms.entity.User;
import com.ccb.ProdPms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    public boolean verifyLogin(User user){

        List<User> userList = loginDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return userList.size()>0;
    }

}
