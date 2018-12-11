package com.bootdo.user.service;


import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.domain.User;
import com.bootdo.user.domain.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by W-YiYan on 2018/12/9.
 */
public interface MemberService {
    List<User> getUserList();
    long countuser(Map<String, Object> map);
    List<MemberVo> userList(Map<String, Object> map);
    int saveUser(User user);
    int saveUserInfo(UserInfo userinfo);
}
