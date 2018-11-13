package com.ccb.ProdPms.service;

import com.ccb.ProdPms.entity.User;

public interface LoginService {

    boolean verifyLogin(User user);
}
