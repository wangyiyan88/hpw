package com.pzxService.user.cascade;


import com.alibaba.fastjson.JSON;
import com.bootdo.blogcontent.vo.RequestBlogConten;
import com.bootdo.user.Vo.Result;
import com.pzxService.Util.ResultUtil;
import com.pzxService.user.service.BlogContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hpService")
@RestController
public class BlogContentCascade {

    @Autowired
    private BlogContentService  blogContentService;

    @RequestMapping("/queryBlogConten")
    public  String  git(@RequestBody RequestBlogConten requestBlogConten) {
        Result result = null;
        try {
            result =   blogContentService.queryBlogConten(requestBlogConten);

        }catch (Exception e) {
            e.printStackTrace();
            result = ResultUtil.error("0007","查询BlogConten异常");
        }
        return JSON.toJSONString(result);
    }



}
