package com.pzxService.user.cascade;

import com.alibaba.fastjson.JSON;
import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.Vo.Result;
import com.bootdo.user.domain.User;
import com.pzxService.Util.ResultUtil;

import com.pzxService.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


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
         if(!StringUtils.isEmpty(openId)) {
             user = loginService.get(openId);
             if(!ObjectUtils.isEmpty(user)) {
                 result= ResultUtil.success(user);
             }else {
                 result = ResultUtil.error("00001","用户没有注册");
             }
         }else{
             result = ResultUtil.error("00002","请传入参数");
         }
        }catch (Exception e){
            result = ResultUtil.error("00007","系統異常");
        }
        return JSON.toJSONString(result);
    }


    @PostMapping("/registered")
    public  String  registered(@RequestBody MemberVo memberVo)   {
        Result result = null;

        try{
            if(!ObjectUtils.isEmpty(memberVo) && !StringUtils.isEmpty(memberVo.getOpenid())) {
                String s = loginService.registered(memberVo);
                result= ResultUtil.success(s);
            }else {
                result=ResultUtil.error("00001","请输入正确的参数");
            }
        }catch(Exception e) {
            result = ResultUtil.error("00007","系統異常");
        }
        return JSON.toJSONString(result);
    }


}
