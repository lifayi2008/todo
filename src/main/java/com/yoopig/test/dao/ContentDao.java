package com.yoopig.test.dao;

import com.yoopig.test.domain.Content;
import com.yoopig.test.utils.DBHelper;
import com.yoopig.test.utils.Pages;
import com.yoopig.test.utils.PageRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifayi on 2016/7/1.
 */
public class ContentDao {

    public boolean addContent(Content content) {

        Connection connection = DBHelper.getConnection();
        String sql = "insert into content(uid, title, content) values (?, ?, ?)";
        PreparedStatement pStatement = null;
        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, content.getUid());
            pStatement.setString(2, content.getTitle());
            pStatement.setString(3, content.getContent());
            return pStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.releaseResource(pStatement, null);
        }
        return false;
    }

    public Pages<Content> listContent(PageRequest pageRequest, int uid) {
        Connection connection = DBHelper.getConnection();
        String sql = "select id, uid, title, content, finished, important from content where uid = ? order by finished DESC, important ASC, createTime DESC limit ? offset ? ";
        String sql2 = "select count(*) from content where uid = ?";

        Pages<Content> pageContent = new Pages<Content>();
        List<Content> listContent = new ArrayList<Content>();

        try {
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, uid);
            pStatement.setInt(3, pageRequest.getOffSize());
            pStatement.setInt(2, pageRequest.getPageSize());

            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                Content content = new Content();
                content.setId(resultSet.getInt("id"));
                content.setUid(resultSet.getInt("uid"));
                content.setTitle(resultSet.getString("title"));
                content.setContent(resultSet.getString("content"));
                content.setFinished(resultSet.getByte("finished"));
                content.setImportant(resultSet.getByte("important"));
                listContent.add(content);
            }
            pageContent.setContent(listContent);

            pStatement = connection.prepareStatement(sql2);
            pStatement.setInt(1, uid);
            resultSet = pStatement.executeQuery();
            if (resultSet.next())
                pageContent.setTotal(resultSet.getInt("count(*)"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageContent;
    }

    public boolean changeStatus(Byte type, String status, int id) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement pStatement = null;
        String sql = null;

        if(type == 0) {
            //欲标记为完成的条目如果之前标记为重要则先取消重要标记
            if(status.equals("1")) {
                sql = "update content set finished = ?, important = '0' where id = ?";
            } else {
                sql = "update content set finished = ? where id = ?";
            }
        } else {
            sql = "update content set important = ? where id = ?";
        }

        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, status);
            pStatement.setInt(2, id);
//            pStatement.setInt(3, userId);
            return pStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.releaseResource(pStatement, null);
        }
        return false;
    }

    public Integer getUserIdbyId(int id) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        String sql = "select uid from content where id = ?";

        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt("uid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.releaseResource(pStatement, resultSet);
        }
        return null;
    }

    public boolean deleteById(int id) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement pStatement = null;
        String sql = "delete from content where id = ?";

        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, id);
            return pStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
