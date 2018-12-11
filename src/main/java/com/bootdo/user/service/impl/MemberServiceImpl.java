package com.bootdo.user.service.impl;

import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.dao.LoginUserDao;
import com.bootdo.user.dao.UserInfoDao;
import com.bootdo.user.domain.User;
import com.bootdo.user.domain.UserInfo;
import com.bootdo.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by W-YiYan on 2018/12/9.
 */
@Transactional
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private LoginUserDao memberMapping;

    @Autowired
    private UserInfoDao userInfoMapping;

    @Override
    public List<User> getUserList() {
        List<User>  uList =  memberMapping.selectByExample(null);
        return uList;
    }

    @Override
    public long countuser(Map<String, Object> map) {
        return memberMapping.countByUser(map);
    }

    @Override
    public List<MemberVo> userList(Map<String, Object> map) {
        return memberMapping.userList(map);
    }

    @Override
    public int saveUser(User user) {
        return memberMapping.insert(user);
    }

    @Override
    public int saveUserInfo(UserInfo userinfo) {
        return userInfoMapping.insert(userinfo);
    }


}
