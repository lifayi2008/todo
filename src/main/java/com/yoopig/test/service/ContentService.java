package com.yoopig.test.service;

import com.yoopig.test.dao.ContentDao;
import com.yoopig.test.domain.Content;
import com.yoopig.test.utils.Pages;
import com.yoopig.test.utils.PageRequest;

import java.io.InputStream;

/**
 * Created by lifayi on 2016/7/1.
 */
public class ContentService {
    public static final int pageSize = 20;

    public boolean addContent(int uid, String title, String content1) {
        if(title.equals(""))
            return false;
        Content content = new Content();
        content.setUid(uid);
        content.setTitle(title);
        content.setContent(content1);
        return (new ContentDao().addContent(content));
    }

    public Pages<Content> listContent(int page, int uid) {
        PageRequest pageRequest = new PageRequest(pageSize, page);
        return new ContentDao().listContent(pageRequest, uid);
    }

    public void changeStatus(String finished, String important, String id) {

        ContentDao contentDao = new ContentDao();
        if(id == null || id.trim().equals("")) {
            return;
        }

        int contentId = Integer.parseInt(id);

        if(finished != null && !finished.trim().equals("")) {
            int status = Integer.parseInt(finished);
            if(status != 1) {
                contentDao.changeStatus((byte)0, "0", contentId);
            } else {
                contentDao.changeStatus((byte)0, "1", contentId);
            }
            return;
        }

        if(important != null && !important.trim().equals("")) {
            int status = Integer.parseInt(important);
            if(status != 1) {
                contentDao.changeStatus((byte)1, "0", contentId);
            } else {
                contentDao.changeStatus((byte)1, "1", contentId);
            }
            return;
        }
    }

    public Integer getUserIdbyId(int id) {
        return new ContentDao().getUserIdbyId(id);
    }

    public boolean deleteById(String id) {
        int intId = Integer.parseInt(id);
        return new ContentDao().deleteById(intId);
    }
}
