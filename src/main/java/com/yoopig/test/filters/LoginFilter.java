package com.yoopig.test.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * Created by lifayi on 2016/7/4.
 */
@WebFilter(urlPatterns = "/content/*")
public class LoginFilter implements Filter {

    public void init(FilterConfig config) {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if(req.getSession().getAttribute("user") == null) {
            res.sendRedirect("/login");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

    }
}
