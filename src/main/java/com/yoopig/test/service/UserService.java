package com.yoopig.test.service;

import com.yoopig.test.dao.UserDao;
import com.yoopig.test.domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by lifayi on 2016/6/30.
 */
public class UserService {

    public User login(String username, String password) {
        if(username.equals("") || password.equals("")) {
            return null;
        } else {
            return (new UserDao()).findUser(username, password);
        }
    }

    public boolean register(String username, String password, String password2, String email) {
        UserDao userDao = new UserDao();
        if(username.equals("") || password.equals("") || !password.equals(password2)) {
            return false;
        } else if(userDao.findUserByName(username)) {
            return false;
        } else {
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            user.setEmail(email);

            return userDao.addUser(user);
        }
    }
}
