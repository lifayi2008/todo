package com.yoopig.test.controller;

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
@WebServlet("/register")
public class Register extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
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
        String password2 = request.getParameter("password2").trim();
        String email = request.getParameter("email").trim();

        try {
            if ((new UserService()).register(username, password, password2, email)) {
                response.sendRedirect("/login");
            } else {
                List<String> errorMsg = new ArrayList<String>();
                errorMsg.add("用户名为空，或者两次输入的密码不一致");
                request.getSession().setAttribute("errorMsg", errorMsg);
                response.sendRedirect("/register");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
