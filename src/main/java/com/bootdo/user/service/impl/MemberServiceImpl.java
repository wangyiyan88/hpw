package com.bootdo.user.service.impl;

import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.dao.LoginUserDao;
import com.bootdo.user.domain.User;
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

    @Override
    public List<User> getUserList() {
        List<User>  uList =  memberMapping.selectByExample(null);
        return uList;
    }

    @Override
    public long countuser() {
        return memberMapping.countByExample(null);
    }

    @Override
    public List<MemberVo> userList() {
        return memberMapping.userList();
    }

}
