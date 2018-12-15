package com.pzxService.user.service;

import com.bootdo.opinionsFeedback.domain.OpinionsFeedback;
import com.bootdo.user.Vo.Result;

public interface OpinionsFeedbackService {

    Result addOpinionsFeedback(OpinionsFeedback  opinionsFeedback) throws Exception;

}
