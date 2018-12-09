package com.bootdo.user.service.impl;


import com.alibaba.fastjson.JSON;
import com.bootdo.user.dao.LoginUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootdo.user.domain.User;

import java.util.List;

@Service
public class SmallProgramLogin {

    @Autowired
    private LoginUserDao loginUserDao;

    public String gitLogin(){
        List<User> userList = loginUserDao.selectByExample(null);
        String json = JSON.toJSONString(userList);
        return json;

    };




}
