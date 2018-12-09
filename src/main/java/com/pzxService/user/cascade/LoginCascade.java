package com.pzxService.user.cascade;

import com.alibaba.fastjson.JSON;
import com.bootdo.user.Vo.Result;
import com.bootdo.user.domain.User;
import com.pzxService.Util.ResultUtil;

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
        Result result = null;
        try{
         user = loginService.get(openId);
         result= ResultUtil.success(user);
        }catch (Exception e){
            result = ResultUtil.error("00002","系統異常");
        }
        return JSON.toJSONString(result);
    }


    @PostMapping("/registered")
    public  String  registered(User user)   {
        Result result = null;
        try{
            String s = loginService.registered(user);
            result= ResultUtil.success(s);
        }catch(Exception e) {
            result = ResultUtil.error("00002","系統異常");
        }
        return JSON.toJSONString(result);
    }


}
