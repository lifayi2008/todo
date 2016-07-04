package com.yoopig.test.utils;

/**
 * Created by lifayi on 2016/7/1.
 */
public class PageRequest {

    private int pageSize;
    private int page;

    public PageRequest(int pageSize, int page) {
        if(pageSize > 0 && page > 0) {
            this.pageSize = pageSize;
            this.page = page;
        } else {
            this.pageSize = 1;
            this.page = 1;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPage() {
        return page;
    }

    public int getOffSize() {
        return (page - 1) * pageSize;
    }
}
