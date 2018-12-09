package com.pzxService.user.service.impl;

import com.bootdo.user.dao.LoginUserDao;
import com.bootdo.user.domain.User;
import com.pzxService.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by W-YiYan on 2018/12/9.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginUserDao  loginUserMapper;

    @Override
    public User get(String id) {
        User user = new User();
        user.setId("123456");
        user.setPhone("13510106021");
        user.setStatus(0);
        return user;
    }
}
