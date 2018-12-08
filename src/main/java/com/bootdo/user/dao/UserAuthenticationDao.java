package com.bootdo.user.dao;


import com.bootdo.user.domain.UserAuthentication;
import com.bootdo.user.domain.UserAuthenticationExample;

import java.util.List;

public interface UserAuthenticationDao {
    long countByExample(UserAuthenticationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAuthentication record);

    int insertSelective(UserAuthentication record);

    List<UserAuthentication> selectByExample(UserAuthenticationExample example);

    UserAuthentication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAuthentication record);

    int updateByPrimaryKey(UserAuthentication record);
}