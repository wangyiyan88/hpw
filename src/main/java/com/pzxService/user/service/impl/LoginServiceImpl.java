package com.pzxService.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.bootdo.Utils.CommonUtil;
import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.dao.LoginUserDao;
import com.bootdo.user.dao.UserInfoDao;
import com.bootdo.user.domain.User;
import com.bootdo.user.domain.UserExample;
import com.bootdo.user.domain.UserInfo;
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

    public String registered(MemberVo memberVo)  throws Exception {

        User user = blid(memberVo);
        UserInfo userInfo = bildUserInfo(memberVo,user.getId());
        int i=0;
        if(user != null) {
           i  =  loginUserMapper.insert(user);
            userInfoDao.insert(userInfo);
        }
       if(i==1) {
           return "01";
       }else{
           return "02";
       }
    }

    private User blid (MemberVo memberVo) {
        User user= null;
        if(!ObjectUtils.isEmpty(memberVo) && !StringUtils.isEmpty(memberVo.getOpenid())) {
            user = new User();
            user.setId(CommonUtil.getUUID32());
            user.setIsverified(memberVo.getIsverified());
            user.setOpenid(memberVo.getOpenid());
            user.setPhone(memberVo.getPhone());
            user.setStatus(memberVo.getStatus());
            user.setPassword(memberVo.getPassword());
        }
        return user;
    }

    private UserInfo bildUserInfo(MemberVo memberVo,String userid) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(CommonUtil.getUUID32());
        userInfo.setAccount(memberVo.getAccount());
        userInfo.setAge(memberVo.getAge());
        userInfo.setHeadImage(memberVo.getHeadImage());
        userInfo.setMail(memberVo.getMail());
        userInfo.setPhone(memberVo.getPhone());
        userInfo.setUserid(userid);
        userInfo.setSex(memberVo.getSex());
        userInfo.setTrueName(memberVo.getTrueName());
        return userInfo;
    }

}
