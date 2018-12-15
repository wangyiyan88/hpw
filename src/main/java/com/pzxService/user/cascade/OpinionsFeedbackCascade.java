package com.pzxService.user.cascade;


import com.alibaba.fastjson.JSON;
import com.bootdo.opinionsFeedback.domain.OpinionsFeedback;
import com.bootdo.user.Vo.Result;
import com.pzxService.Util.ResultUtil;
import com.pzxService.user.service.OpinionsFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hpService")
public class OpinionsFeedbackCascade {

    @Autowired
    private OpinionsFeedbackService opinionsFeedbackService;

    @RequestMapping("/addOpinionsFeedback")
    public String addOpinionsFeedback(@RequestBody OpinionsFeedback opinionsFeedback) {
        Result result = null;
        try{
            result = opinionsFeedbackService.addOpinionsFeedback(opinionsFeedback);
        }catch (Exception e) {
            result = ResultUtil.error("0007","添加意见和反馈异常");
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }

}
