package com.ccb.ProdPms.controller;

import com.ccb.ProdPms.config.WebSecurityConfig;
import com.ccb.ProdPms.entity.User;
import com.ccb.ProdPms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

//@controller 控制器（注入服务）,用于标注控制层
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY)String account, Model model){

        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //对登录请求到数据库中进行验证用户名和密码，验证通过以后设置session，否则跳转到登录页面
    @PostMapping("/loginVerify")
    @ResponseBody
    public String loginVerify(String username,String password,HttpSession session){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        boolean verify = loginService.verifyLogin(user);
        if (verify) {
            session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
            return "success";
        } else {
            return "login error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}

