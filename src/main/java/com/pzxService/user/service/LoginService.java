package com.pzxService.user.service;


import com.bootdo.user.domain.User;
import com.pzxService.user.Vo.LoginVo;

/**
 * Created by W-YiYan on 2018/12/9.
 */
public interface LoginService {

    User get(String id) throws  Exception;

    String registered(LoginVo loginVo)throws  Exception;

}
