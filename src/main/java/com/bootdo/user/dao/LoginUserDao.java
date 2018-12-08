package com.bootdo.user.dao;

import com.bootdo.user.domain.User;
import com.bootdo.user.domain.UserExample;

import java.util.List;

public interface LoginUserDao {

    long countByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
