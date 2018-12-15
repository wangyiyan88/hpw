package com.bootdo.opinionsFeedback.dao;

import com.bootdo.opinionsFeedback.domain.OpinionsFeedback;
import com.bootdo.opinionsFeedback.domain.OpinionsFeedbackExample;
import java.util.List;

public interface OpinionsFeedbackDao {
    long countByExample(OpinionsFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpinionsFeedback record);

    int insertSelective(OpinionsFeedback record);

    List<OpinionsFeedback> selectByExample(OpinionsFeedbackExample example);

    OpinionsFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpinionsFeedback record);

    int updateByPrimaryKey(OpinionsFeedback record);
}