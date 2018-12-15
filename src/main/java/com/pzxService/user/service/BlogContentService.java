package com.pzxService.user.service;



import com.bootdo.blogcontent.domain.BlogContent;
import com.bootdo.blogcontent.vo.RequestBlogConten;
import com.bootdo.user.Vo.Result;

import java.util.List;

public interface BlogContentService {

    Result queryBlogConten(RequestBlogConten blogContent) throws Exception;

}
