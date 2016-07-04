package com.yoopig.test.domain;

/**
 * Created by lifayi on 2016/7/1.
 */
public class Content {
    private int id;
    private int uid;
    private String title;
    private String content;
    private byte finished;
    private byte important;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte getFinished() {
        return finished;
    }

    public void setFinished(byte finished) {
        this.finished = finished;
    }

    public byte getImportant() {
        return important;
    }

    public void setImportant(byte important) {
        this.important = important;
    }
}
