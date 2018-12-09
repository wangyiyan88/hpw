package com.pzxService.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.bootdo.Utils.CommonUtil;
import com.bootdo.user.dao.LoginUserDao;
import com.bootdo.user.domain.User;
import com.bootdo.user.domain.UserExample;
import com.pzxService.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Created by W-YiYan on 2018/12/9.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginUserDao  loginUserMapper;

    @Override
    public User get(String id) {
        UserExample userExample = new UserExample();
       UserExample.Criteria criteria = userExample.createCriteria();
       criteria.andOpenidEqualTo(id);
       List<User> userlist  = loginUserMapper.selectByExample(userExample);
       User  user =null;
        if(!ObjectUtils.isEmpty(userlist))  {
            user =   userlist.get(0);
        }
        return user;
    }

    public String registered(User user) {
        if(user != null) {
            user.setId(CommonUtil.getUUID32());
        }
       int i =  loginUserMapper.insert(user);
       if(i==1) {
           return "01";
       }else{
           return "02";
       }
    }

}
