<%--
  Created by IntelliJ IDEA.
  User: lifayi
  Date: 2016/6/30
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body>
    <h3>欢迎来到多用户Todo List，请登录</h3>
    <hr />
    <%@ include file="error_msg.jsp" %>
    <form action="/login" method="post">
        <label>用户名：<input type="text" name="username" /></label><br />
        <label>密码：<input type="password" name="password" /></label><br />
        <input type="submit" value="提交" /> 没有账号？<a href="/register">注册</a>
    </form>
</body>
</html>
