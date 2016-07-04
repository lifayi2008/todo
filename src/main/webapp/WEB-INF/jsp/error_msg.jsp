<%--
  Created by IntelliJ IDEA.
  User: lifayi
  Date: 2016/7/4
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="msg" items="${sessionScope.errorMsg}">
        <p style="color:#FF0000"><c:out value="${msg}" /></p>
    </c:forEach>
    <c:remove var="errorMsg" />
</body>
</html>
