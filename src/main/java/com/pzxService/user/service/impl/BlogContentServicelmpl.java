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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BlogContentServicelmpl implements BlogContentService {
    private static Logger logger =  Logger.getLogger(BlogContentServicelmpl.class.getSimpleName());

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
             logger.info("currPage:  "+currPage+"   pageSize:   "+pageSize);
             blogContentExample.setPageSize(pageSize);
             blogContentExample.setStartRow((currPage-1)*pageSize);
         }else{
             currPage = 1;
             pageSize = 10;
             blogContentExample.setPageSize(pageSize);
             blogContentExample.setStartRow((currPage-1)*pageSize);
         }
         BlogContent blogContent1 = blogContent.getBlogContent();
         if(!ObjectUtils.isEmpty(blogContent1)) {
             String type =   blogContent1.getType();
             String categories = blogContent1.getCategories();
             if(!StringUtils.isBlank(type)) {
                 criteria.andTypeEqualTo(type);
             }
             if(!StringUtils.isBlank(categories)) {
                 criteria.andCategoriesEqualTo(categories);
             }
         }
         List<BlogContent>  list=  blogContentDao.selectByExample(blogContentExample);
          blogContentExample.setPageSize(0);
          blogContentExample.setStartRow(0);
         long count = blogContentDao.countByExample(blogContentExample);
         responseBlogContenList.setCount(count);
         responseBlogContenList.setBlogContentList(list);
         result = ResultUtil.success(responseBlogContenList);
        return result;

    }

}
