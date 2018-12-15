package com.bootdo.blogcontent.vo;

import com.bootdo.blogcontent.domain.BlogContent;

public class RequestBlogConten {
    private int pageSize;
    private int currPage;
    private BlogContent blogContent;

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

    public BlogContent getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(BlogContent blogContent) {
        this.blogContent = blogContent;
    }
}
