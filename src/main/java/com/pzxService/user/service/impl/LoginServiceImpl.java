package com.pzxService.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.bootdo.Utils.CommonUtil;
import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.dao.LoginUserDao;
import com.bootdo.user.dao.UserInfoDao;
import com.bootdo.user.domain.User;
import com.bootdo.user.domain.UserExample;
import com.bootdo.user.domain.UserInfo;
import com.pzxService.user.Vo.LoginVo;
import com.pzxService.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by W-YiYan on 2018/12/9.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginUserDao  loginUserMapper;
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public User get(String id) throws  Exception{
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

    public String registered(LoginVo loginVo)  throws Exception {
        if(!ObjectUtils.isEmpty(get(loginVo.getOpenid()))) {
            return "0penid不能重复";
        }
        User user = blid(loginVo);
        UserInfo userInfo = bildUserInfo(loginVo,user.getId());
        int i=0;
        i  =  loginUserMapper.insert(user);
        userInfoDao.insert(userInfo);
       if(i==1) {
           return "注册成功";
       }else{
           return "注册失败";
       }
    }

    private User blid (LoginVo loginVo) {
        User user= null;
        if(!ObjectUtils.isEmpty(loginVo) && !StringUtils.isEmpty(loginVo.getOpenid())) {
            user = new User();
            user.setId(CommonUtil.getUUID32());
            user.setIsverified(loginVo.getIsverified());
            user.setOpenid(loginVo.getOpenid());
            user.setPhone(loginVo.getPhone());
            user.setStatus(loginVo.getStatus());
            user.setPassword(loginVo.getPassword());
        }
        return user;
    }

    private UserInfo bildUserInfo(LoginVo loginVo,String userid) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(CommonUtil.getUUID32());
        userInfo.setAccount(loginVo.getAccount());
        userInfo.setAge(loginVo.getAge());
        userInfo.setHeadImage(loginVo.getHeadImage());
        userInfo.setMail(loginVo.getMail());
        userInfo.setPhone(loginVo.getPhone());
        userInfo.setUserid(userid);
        userInfo.setSex(loginVo.getSex());
        userInfo.setTrueName(loginVo.getTrueName());
        return userInfo;
    }

}
