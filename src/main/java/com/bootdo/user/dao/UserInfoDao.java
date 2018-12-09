package com.bootdo.user.dao;


import com.bootdo.user.domain.UserInfo;
import com.bootdo.user.domain.UserInfoExample;

import java.util.List;

public interface UserInfoDao {
    long countByExample(UserInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}