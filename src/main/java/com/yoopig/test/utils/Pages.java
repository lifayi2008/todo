package com.yoopig.test.utils;

import java.util.List;

/**
 * Created by lifayi on 2016/7/1.
 */
public class Pages<T> {
    private PageRequest pageRequest;
    private List<T> content;
    private int total;

    public Pages() {};

    public Pages(PageRequest pageRequest, List<T> content, int total) {
        this.pageRequest = pageRequest;
        this.content = content;
        this.total = total;
    }

    public List<T> getContent() {
        return content;
    }

    public int getTotal() {
        return total;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
