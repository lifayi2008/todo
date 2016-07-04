package com.yoopig.test.controller;

import com.yoopig.test.service.ContentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lifayi on 2016/7/4.
 */
@WebServlet("/content/delete")
public class Delete extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        if(new ContentService().deleteById(id)) {
            try {
                response.sendRedirect("/content/index");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
