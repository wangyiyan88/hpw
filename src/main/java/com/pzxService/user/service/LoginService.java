package com.pzxService.user.service;


import com.bootdo.user.Vo.LoginVo;
import com.bootdo.user.Vo.Result;
import com.bootdo.user.domain.User;


/**
 * Created by W-YiYan on 2018/12/9.
 */
public interface LoginService {

    User get(String id) throws  Exception;

    Result registered(LoginVo loginVo)throws  Exception;

}
