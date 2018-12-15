package com.bootdo.blogcontent.dao;

import com.bootdo.blogcontent.domain.BlogContent;
import com.bootdo.blogcontent.domain.BlogContentExample;
import java.util.List;

public interface BlogContentDao {
    long countByExample(BlogContentExample example);

    int deleteByPrimaryKey(Long cid);

    int insert(BlogContent record);

    int insertSelective(BlogContent record);

    List<BlogContent> selectByExampleWithBLOBs(BlogContentExample example);

    List<BlogContent> selectByExample(BlogContentExample example);

    BlogContent selectByPrimaryKey(Long cid);

    int updateByPrimaryKeySelective(BlogContent record);

    int updateByPrimaryKeyWithBLOBs(BlogContent record);

    int updateByPrimaryKey(BlogContent record);
}