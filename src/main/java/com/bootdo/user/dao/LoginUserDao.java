package com.bootdo.user.dao;

import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.domain.User;
import com.bootdo.user.domain.UserExample;

import java.util.List;
import java.util.Map;

public interface LoginUserDao {

    long countByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<MemberVo> userList(Map<String, Object> map);

    long countByUser(Map<String, Object> map);
}
