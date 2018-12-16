package com.bootdo.blogcontent.vo;

import com.bootdo.blogcontent.domain.BlogContent;

import java.util.List;


public class ResponseBlogContenList {
    private long count;

    private List<BlogContent> blogContentList;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<BlogContent> getBlogContentList() {
        return blogContentList;
    }

    public void setBlogContentList(List<BlogContent> blogContentList) {
        this.blogContentList = blogContentList;
    }
}
