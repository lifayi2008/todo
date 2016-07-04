package com.yoopig.test.controller;

import com.yoopig.test.domain.Content;
import com.yoopig.test.domain.User;
import com.yoopig.test.service.ContentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifayi on 2016/7/1.
 */
@WebServlet("/content/add")
public class Add extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");

        String title = request.getParameter("title");
        String content1 = request.getParameter("content");

        User user = (User) request.getSession().getAttribute("user");

        try {
            if((new ContentService()).addContent(user.getId(), title, content1)) {
                response.sendRedirect("/content/index");
            } else {
                List<String> errorMsg = new ArrayList();
                request.getSession().setAttribute("errorMsg", errorMsg);
                errorMsg.add("标题为空或过长");
                response.sendRedirect("/content/add");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
