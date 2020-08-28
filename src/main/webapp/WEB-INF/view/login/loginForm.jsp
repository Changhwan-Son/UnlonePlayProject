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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body style="margin:5% 10%">

<div class="header" style="width:100%; height:20%">
    <div style="float: left; width: 25%; ">
        <h1><a href="/">UnlonePlay</a></h1>
    </div>

    <c:if test="${empty authInfo}">
        <div style="float: right; width: 20%; ">
            <a href="<c:url value='/login'/>"><h2 style="float:left; width:50%">로그인</h2></a>
            <a href="<c:url value='/register'/>"><h2 style="float:left; width:50%">회원가입</h2></a>
        </div>
    </c:if>

    <c:if test="${! empty authInfo }">
        <div style="float: right; width: 20%; ">
            <h2 style="float:left; width:50%">${authInfo.name}</h2>
            <a href="<c:url value='/logout'/>"><h2 style="float:left; width:50%">로그아웃</h2></a>
        </div>
    </c:if>

    <div style="float: right; width: 45%;">
        <h2 style="float:right; width:45%"><a href="/list?nowPage=1">전체 기사 보기</a></h2>
    </div>

</div>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<div>

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
</div>

</body>
</html>