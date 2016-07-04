<%--
  Created by IntelliJ IDEA.
  User: lifayi
  Date: 2016/7/1
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="com.yoopig.test.domain.User" %>
<h3>欢迎来到本站</h3>
<p>你的用户名是：${user.userName} &nbsp;|&nbsp; 你的邮箱是：${user.email} &nbsp; | &nbsp; <a href="/content/logout">退出登陆</a></p>
