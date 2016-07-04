package com.yoopig.test.controller;

import com.yoopig.test.domain.User;
import com.yoopig.test.service.ContentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lifayi on 2016/7/1.
 */
@WebServlet("/content/changeStatus")
public class ChangeStatus extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String finished = request.getParameter("finished");
        String important = request.getParameter("important");
        String id = request.getParameter("id");
//        int userId = ((User)request.getSession().getAttribute("user")).getId();

        (new ContentService()).changeStatus(finished, important, id);

        try {
            response.sendRedirect("/content/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
