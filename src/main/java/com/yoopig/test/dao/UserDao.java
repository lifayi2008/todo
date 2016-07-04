package com.yoopig.test.dao;

import com.yoopig.test.domain.User;
import com.yoopig.test.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lifayi on 2016/6/30.
 */
public class UserDao {

    public User findUser(String userName, String password) {
        User user = null;
        Connection connection = DBHelper.getConnection();
        String sql = "select id, username, password, email, date from blog where username = ? and password = ?";
        try {
            PreparedStatement pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1, userName);
            pStatement.setString(2, password);
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean addUser(User user) {
        Connection connection = DBHelper.getConnection();
        String sql = "insert into blog (username, password, email) values (?, ?, ?)";
        try {
            PreparedStatement pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1, user.getUserName());
            pStatement.setString(2, user.getPassword());
            pStatement.setString(3, user.getEmail());
            pStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean findUserByName(String username) {
        Connection connection = DBHelper.getConnection();
        String sql = "select username from blog where username = ?";
        try {
            PreparedStatement pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1, username);
            ResultSet resultSet = pStatement.executeQuery();
            if(resultSet.next())
                return true;
            else
                return false;
        } catch (SQLException e) {
            return true;
        }
    }
}
