package com.pzxService.user.cascade;

import com.alibaba.fastjson.JSON;
import com.bootdo.user.domain.User;
import com.pzxService.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by W-YiYan on 2018/12/9.
 */
@RequestMapping("/hpService")
@RestController
public class LoginCascade {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public  String  getLogin() {
        User user = loginService.get("123456");
        return JSON.toJSONString(user);
    }
}
