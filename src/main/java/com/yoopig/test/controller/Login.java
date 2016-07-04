package com.yoopig.test.controller;

import com.yoopig.test.domain.User;
import com.yoopig.test.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifayi on 2016/6/30.
 */
@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();

        User user = (new UserService()).login(username, password);
        try {
            if(user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/content/index");
            } else {
                List<String> errorMsg = new ArrayList();
                request.getSession().setAttribute("errorMsg", errorMsg);
                errorMsg.add("用户名或者密码错误请重新输入");
                response.sendRedirect("/login");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
