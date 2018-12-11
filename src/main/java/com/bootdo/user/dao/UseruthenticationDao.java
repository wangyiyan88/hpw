package com.bootdo.user.dao;

import com.bootdo.user.domain.Useruthentication;
import com.bootdo.user.domain.UseruthenticationExample;
import java.util.List;

public interface UseruthenticationDao {
    long countByExample(UseruthenticationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Useruthentication record);

    int insertSelective(Useruthentication record);

    List<Useruthentication> selectByExample(UseruthenticationExample example);

    Useruthentication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Useruthentication record);

    int updateByPrimaryKey(Useruthentication record);
}