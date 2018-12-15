package com.pzxService.user.service.impl;

import com.bootdo.blogcontent.dao.BlogContentDao;
import com.bootdo.blogcontent.domain.BlogContent;
import com.bootdo.blogcontent.domain.BlogContentExample;
import com.bootdo.blogcontent.vo.RequestBlogConten;
import com.bootdo.blogcontent.vo.ResponseBlogContenList;
import com.bootdo.common.utils.StringUtils;
import com.bootdo.user.Vo.Result;
import com.pzxService.Util.ResultUtil;
import com.pzxService.user.service.BlogContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogContentServicelmpl implements BlogContentService {
    @Autowired
    private BlogContentDao blogContentDao;

    @Override
    public Result queryBlogConten(RequestBlogConten blogContent) throws Exception {
        Result result = null;
         ResponseBlogContenList responseBlogContenList = new ResponseBlogContenList();
         int currPage = blogContent.getCurrPage();
         int pageSize  = blogContent.getPageSize();
         BlogContentExample blogContentExample = new BlogContentExample();
         BlogContentExample.Criteria  criteria =  blogContentExample.createCriteria();
         if(currPage>0&&pageSize>0) {
             blogContentExample.setPageSize(pageSize);
             blogContentExample.setStartRow((currPage-1)*pageSize);
         }
         BlogContent blogContent1 = blogContent.getBlogContent();
         String type =   blogContent1.getType();
         if(!StringUtils.isBlank(type)) {
             criteria.andTypeEqualTo(type);
         }
         List<BlogContent>  list=  blogContentDao.selectByExample(blogContentExample);
         long count = blogContentDao.countByExample(blogContentExample);
         responseBlogContenList.setCount(count);
         responseBlogContenList.setBlogContentList(list);
        result = ResultUtil.success(responseBlogContenList);
        return null;

    }

}
