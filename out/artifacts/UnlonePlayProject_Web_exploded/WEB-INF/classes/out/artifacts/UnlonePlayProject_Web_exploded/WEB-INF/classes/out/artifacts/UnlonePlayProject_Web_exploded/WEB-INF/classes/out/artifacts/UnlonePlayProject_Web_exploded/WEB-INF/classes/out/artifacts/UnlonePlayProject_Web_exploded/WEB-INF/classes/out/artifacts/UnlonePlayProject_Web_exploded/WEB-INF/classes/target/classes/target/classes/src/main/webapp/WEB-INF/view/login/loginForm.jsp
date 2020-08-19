<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 2020/08/19
  Time: 12:12 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>로그인
<form:form modelAttribute="loginRequest">
    <form:errors />
    <p>
        <label>아이디:<br>
            <form:input path="name" />
            <form:errors path="name" />
        </label>
    </p>
    <p>
        <label>비밀번호:<br>
            <form:input path="password" />
            <form:errors path="password" />
        </label>
    </p>
    <input type="submit" value="로그인">
</form:form>

</body>
</html>