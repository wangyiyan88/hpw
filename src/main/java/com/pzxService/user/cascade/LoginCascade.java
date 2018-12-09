package com.pzxService.user.cascade;

import com.alibaba.fastjson.JSON;
import com.bootdo.user.domain.User;
import com.pzxService.user.Response.BaseResponse;

import com.pzxService.user.Response.RegisteredResponse;
import com.pzxService.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by W-YiYan on 2018/12/9.
 */
@RequestMapping("/hpService")
@RestController
public class LoginCascade {

    private Logger logger = Logger.getLogger(LoginCascade.class.getSimpleName()) ;

    @Autowired
    private LoginService loginService;


    @GetMapping("/login")
     public  String  getLogin(String openId) {
        User user = null;
        BaseResponse baseResponse = new BaseResponse();
        try{
         user = loginService.get(openId);
         baseResponse.setData(user);
        }catch (Exception e){
            baseResponse.setResponsestatus("0002");
        }
        return JSON.toJSONString(baseResponse);
    }

    @PostMapping("/registered")
    public  String  registered(User user) {
        String s = loginService.registered(user);
        RegisteredResponse registeredResponse = new RegisteredResponse();
        registeredResponse.setS(s);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(registeredResponse );
        return JSON.toJSONString(baseResponse);
    }


}
