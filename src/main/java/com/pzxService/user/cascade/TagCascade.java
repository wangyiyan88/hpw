package com.pzxService.user.cascade;

import com.bootdo.tagLibrary.domain.TagLibrary;
import com.pzxService.user.service.TagLibraryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagCascade {
 @Autowired
 private TagLibraryService tagLibraryService;




 @RequestMapping("/addtag")
    public String addTag(@RequestBody TagLibrary tagLibrary) {
     try{
         tagLibraryService.addTag(tagLibrary);
     }catch (Exception e){

     }

        return "";
    }
}
