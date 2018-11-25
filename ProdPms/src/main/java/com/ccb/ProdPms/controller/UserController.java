package com.ccb.ProdPms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccb.ProdPms.entity.RestRespEntity;
import com.ccb.ProdPms.entity.UserEntity;
import com.ccb.ProdPms.service.UserService;
import com.ccb.ProdPms.util.RespCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//===========用户管理=================================================================

@Controller
@EnableAutoConfiguration
public class UserController {

    private static String strSuc = "success";

    @Autowired
    UserService userService;
    /**
     * 获取用户列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getAllUser")
    @ResponseBody
    public String getUserList(@RequestParam(value = "page") Integer pageNum,
                              @RequestParam(value = "limit") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<UserEntity> userEntityPageInfo = new PageInfo<>(userService.getAllUser());
        RestRespEntity restResp = new RestRespEntity(RespCode.SUCCESS, userEntityPageInfo);
        return JSONObject.toJSONString(restResp);
    }

    /**
     * 新增用户
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(HttpServletRequest request){

        String userName=request.getParameter("userName");
        String userPassword=request.getParameter("userPassword");
        String userDep=request.getParameter("userDep");
        String email=request.getParameter("email");
        String call=request.getParameter("call");
        String sex = request.getParameter("sex");
        String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String modiDate = null;
        UserEntity userEntity=new UserEntity(userName, userPassword, userDep, email, call, createDate, modiDate, sex);
        try {
            userService.addUser(userEntity);
        } catch (Exception e) {
            e.getMessage();
            return "add user failed! ";
        }
        return JSONObject.toJSONString(strSuc);
    }

    /**
     * 修改用户信息
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public String editUser(HttpServletRequest request) throws IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        String userName=request.getParameter("userName");
        String userPassword=request.getParameter("userPassword");
        String userDep=request.getParameter("userDep");
        String email=request.getParameter("email");
        String call=request.getParameter("call");
        String modiTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String sex=request.getParameter("sex");

        UserEntity userEntity = new UserEntity(id, userName, userPassword, userDep, email, call, modiTime, sex);
        try {
            userService.editUser(userEntity);
        } catch (Exception e) {
            e.getMessage();
            return "update user failed!";
        }
        return JSONObject.toJSONString(strSuc);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/delUserById")
    @ResponseBody
    public String deletedUserById(@RequestParam(value = "id") Integer id){
        userService.deletedUser(id);
        return JSONObject.toJSONString(strSuc);
    }

}
