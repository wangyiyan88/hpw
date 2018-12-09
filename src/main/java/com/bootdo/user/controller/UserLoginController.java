package com.bootdo.user.controller;


import com.alibaba.fastjson.JSON;
import com.bootdo.user.dao.LoginUserDao;
import com.bootdo.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/smallprogram")
public class UserLoginController {

    @Autowired
    private LoginUserDao loginUserDao;


    @RequestMapping("/login")
    public  String  getLogin() {
        List<User> listuser = loginUserDao.selectByExample(null);
        String json = JSON.toJSONString(listuser);
        return json ;
    }



}
