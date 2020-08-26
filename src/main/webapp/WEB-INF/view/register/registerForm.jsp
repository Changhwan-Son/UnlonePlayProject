<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 2020/08/19
  Time: 11:13 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
            <h2 style="float:right; width:45%"><a href="/list">전체 기사 보기</a></h2>
        </div>

    </div>

<h2>회원 가입</h2>
<form action="registerSuccess" method="post">
    <p>
        <label>이름:<br>
            <input type="text" name="name" id="name" value="${registerRequest.name}">
        </label>
    </p>

    <p>
        <label>비밀번호:<br>
            <input type="text" name="password" id="password">
        </label>
    </p>
    <p>
        <label>비밀번호 확인:<br>
            <input type="text" name="confirmPassword" id="confirmPassword">
        </label>
    </p>
    <input type="submit" value="확인">
</form>

</body>
</html>
