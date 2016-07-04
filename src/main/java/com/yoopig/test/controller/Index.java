package com.yoopig.test.controller;

import com.yoopig.test.domain.Content;
import com.yoopig.test.domain.User;
import com.yoopig.test.service.ContentService;
import com.yoopig.test.utils.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lifayi on 2016/6/30.
 */
@WebServlet("/content/index")
public class Index extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            String requestPage = request.getParameter("page");
            int page = 1;
            if(requestPage != null && !requestPage.trim().equals(""))
                page = Integer.parseInt(requestPage);
            int uid = ((User)request.getSession().getAttribute("user")).getId();
            Pages<Content> contentPages = (new ContentService()).listContent(page, uid);
            request.setAttribute("contentPages", contentPages);
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
