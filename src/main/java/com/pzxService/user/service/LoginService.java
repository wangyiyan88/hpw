package com.pzxService.user.service;

import com.bootdo.user.domain.User;

/**
 * Created by W-YiYan on 2018/12/9.
 */
public interface LoginService {

    User get(String id);

     String registered(User user);

}
