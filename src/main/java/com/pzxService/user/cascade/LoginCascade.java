package com.pzxService.user.cascade;

import com.alibaba.fastjson.JSON;
import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.Vo.Result;
import com.bootdo.user.domain.User;
import com.pzxService.Util.ResultUtil;

import com.pzxService.user.Vo.LoginVo;
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



    @RequestMapping("/login")
    public String loginRe(@RequestBody LoginVo loginVo) {
        Result result = null;
        if(!StringUtils.isEmpty(loginVo.getOpenid())) {
            try {
                if("01".equals(loginVo.getChannelType())) { //denglu
                    User user = null;
                    user = loginService.get(loginVo.getOpenid());
                    if(!ObjectUtils.isEmpty(user)) {
                        result= ResultUtil.success(user);
                    }else {
                        result = ResultUtil.error("00001","用户没有注册");
                    }
                }else{  //注册
                    String s = loginService.registered(loginVo);
                    result= ResultUtil.success(s);
                }
            }catch (Exception e){
                result = ResultUtil.error("00007","系統異常");

            }
        }else{
            result = ResultUtil.error("00001","请输入合法的参数");
        }

        return  JSON.toJSONString(result);
    }



}
