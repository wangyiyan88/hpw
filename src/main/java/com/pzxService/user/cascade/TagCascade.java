package com.pzxService.user.cascade;

import com.alibaba.fastjson.JSON;
import com.bootdo.tagLibrary.domain.TagLibrary;

import com.bootdo.user.Vo.Result;
import com.pzxService.Util.ResultUtil;
import com.pzxService.user.service.TagLibraryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hpService")
public class TagCascade {
 @Autowired
 private TagLibraryService tagLibraryService;



 @RequestMapping("/addtag")
    public String addTag(@RequestBody TagLibrary tagLibrary) {
     Result result = null;
     try{
         result  =  tagLibraryService.addTag(tagLibrary);
     }catch (Exception e){
         result = ResultUtil.error("0007","添加标签异常");
     }
         return  JSON.toJSONString(result);
    }
}
