<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>小春论坛登录</title>
</head>
<tbody>
<c:if test="${!empty error}">
    <%--<c:out>标签显示表达式的结果--%>
    <span style="color:red"><c:out value="${error}"></c:out></span>
</c:if>
<form action="<c:url value="/loginCheck.html" />" method="post">
    用户名:<input type="text" name="userName">
    <br>
    密码：<input type="password" name="password">
    <br>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>
</tbody>
</html>
