package com.bootdo.tagLibrary.dao;

import com.bootdo.tagLibrary.domain.TagLibrary;
import com.bootdo.tagLibrary.domain.TagLibraryExample;
import java.util.List;

public interface TagLibraryDao {
    long countByExample(TagLibraryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TagLibrary record);

    int insertSelective(TagLibrary record);

    List<TagLibrary> selectByExample(TagLibraryExample example);

    TagLibrary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagLibrary record);

    int updateByPrimaryKey(TagLibrary record);
}