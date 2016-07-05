package com.yoopig.test.filters;

import com.yoopig.test.domain.User;
import com.yoopig.test.service.ContentService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifayi on 2016/7/4.
 */
@WebFilter(urlPatterns = {"/content/delete", "/content/changeStatus"})
public class ContentManipulateFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        int id = Integer.parseInt(req.getParameter("id"));

        Integer neededUid = new ContentService().getUserIdbyId(id);

        if(neededUid != null && ((User)req.getSession().getAttribute("user")).getId() == neededUid) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
//            List<String> errorMsg = new ArrayList<String>();
//            errorMsg.add("你无权进行此操作");
//            req.getSession().setAttribute("errorMsg", errorMsg);
            res.sendRedirect("/content/index");
        }
    }

    public void destroy() {

    }
}
