package com.pzxService.user.service.impl;

import com.bootdo.common.utils.StringUtils;
import com.bootdo.opinionsFeedback.dao.OpinionsFeedbackDao;
import com.bootdo.opinionsFeedback.domain.OpinionsFeedback;
import com.bootdo.user.Vo.Result;
import com.pzxService.Util.ResultUtil;
import com.pzxService.user.service.OpinionsFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OpinionsFeedbackServiceImpl implements OpinionsFeedbackService {

    @Autowired
    private OpinionsFeedbackDao opinionsFeedbackDao;

    @Override
    public Result addOpinionsFeedback(OpinionsFeedback opinionsFeedback) throws Exception {
        Result result = null;
        if(StringUtils.isBlank(opinionsFeedback.getCallname())||StringUtils.isBlank(opinionsFeedback.getContent())
                || StringUtils.isBlank(opinionsFeedback.getMlevel())||StringUtils.isBlank(opinionsFeedback.getMobile())) {
            return ResultUtil.error("0002","内容，等级，称呼，手机号 為必填參數");
        }
        opinionsFeedback.setCreateTime(new Date(System.currentTimeMillis()));
       int i =  opinionsFeedbackDao.insert(opinionsFeedback);
       if(i > 0) {
           result = ResultUtil.success("添加意见与反馈成功");
       }else{
           result = ResultUtil.error("0001","添加意见与反馈失败");
       }
        return result;
    }
}
