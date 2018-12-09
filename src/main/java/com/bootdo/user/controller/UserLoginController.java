package com.bootdo.user.controller;


import com.alibaba.fastjson.JSON;

import com.bootdo.user.domain.User;
import com.bootdo.user.service.impl.SmallProgramLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/smallprogram")
public class UserLoginController {

 @Autowired
 private SmallProgramLogin smallProgramLogin;

    @RequestMapping("/login")
    public  String  getLogin() {
        String string = smallProgramLogin.gitLogin();
        return string ;
    }



}
