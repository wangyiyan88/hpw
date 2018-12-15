package com.bootdo.blogcontent.vo;

import com.bootdo.blogcontent.domain.BlogContent;

import java.util.List;


public class ResponseBlogContenList {
    private long count;

    private int pageSize;

    private int currPage;

    private List<BlogContent> blogContentList;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<BlogContent> getBlogContentList() {
        return blogContentList;
    }

    public void setBlogContentList(List<BlogContent> blogContentList) {
        this.blogContentList = blogContentList;
    }
}
