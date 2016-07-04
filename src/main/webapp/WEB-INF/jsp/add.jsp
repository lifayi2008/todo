<%--
  Created by IntelliJ IDEA.
  User: lifayi
  Date: 2016/7/1
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
    <%@ include file="login_header.jsp" %>
    <hr />
    <%@ include file="error_msg.jsp" %>
    <form action="/content/add" method="post" id="form">
        <label>标题: <input type="text" name="title" /></label><br /><br />
        <label>内容: <textarea rows="10" cols="100" form="form" name="content">请填写内容
        </textarea></label><br />
        <input type="submit" value="提交" />
    </form>

</body>
</html>
