<%--
  Created by IntelliJ IDEA.
  User: lifayi
  Date: 2016/6/30
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.yoopig.test.domain.Content" %>
<%@ page import="com.yoopig.test.utils.Pages"%>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
    <%@ include file="login_header.jsp" %>
    <hr />
    <a href="/content/add">添加新的待办事项</a><br /><br />
    <ol>
        <c:forEach var="item" items="${contentPages.getContent()}">
            <c:if test="${item.getImportant() eq 1}" >
                <li style="color:red">
            </c:if>
            <c:if test="${item.getImportant() eq 0}" >
                <li>
            </c:if>
                <c:choose>
                    <c:when test="${item.getFinished() eq 0}">
                        <c:out value="${item.getTitle()}" />&nbsp;&nbsp;
                        <small><a href="/content/changeStatus?id=${item.getId()}&finished=1">已完成</a></small>
                            <c:choose>
                                <c:when test="${item.getImportant() eq 0}">
                                    &nbsp;<small><a href="/content/changeStatus?id=${item.getId()}&important=1">重要</a></small>
                                </c:when>
                                <c:otherwise>
                                    &nbsp;<small><a href="/content/changeStatus?id=${item.getId()}&important=0">不重要</a></small>
                                </c:otherwise>
                            </c:choose>

                    </c:when>
                    <c:otherwise>
                        <del><c:out value="${item.getTitle()}" /></del>&nbsp;&nbsp;
                        <small><a href="/content/changeStatus?id=${item.getId()}&finished=0">重做</a></small>
                    </c:otherwise>
                </c:choose>
            &nbsp;<small><a href="/content/delete?id=${item.getId()}">删除</a></small>
            </li><br />
        </c:forEach>
    </ol>
</body>
</html>
