<%--
  Created by IntelliJ IDEA.
  User: lifayi
  Date: 2016/6/30
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <h3>欢迎注册多用户Todo List，请注册</h3>
    <hr />
    <%@ include file="error_msg.jsp" %>
    <form action="/register" method="post">
        <label>用户名：<input type="text" name="username" /></label><br />
        <label>密码：<input type="password" name="password" /></label><br />
        <label>重复密码：<input type="password" name="password2" /></label><br />
        <label>邮箱：<input type="text" name="email" /></label><br />
        <input type="submit" value="提交" />
    </form>
</body>
</html>
