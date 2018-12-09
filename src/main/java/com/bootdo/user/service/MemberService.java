package com.bootdo.user.service;


import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.domain.User;

import java.util.List;

/**
 * Created by W-YiYan on 2018/12/9.
 */
public interface MemberService {
    List<User> getUserList();
    long countuser();
    List<MemberVo> userList();
}
