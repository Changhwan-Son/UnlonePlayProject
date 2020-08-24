<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 2020/08/24
  Time: 3:03 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        #wrap {
            margin:5% 10%
        }
    </style>

</head>

<body>

<div id="wrap">
    <div class="header" style="width:100%; height:20%">
        <div style="float: left; width: 25%; ">
            <h1>웹 페이지 이름</h1>
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
            <h2 style="float:right; width:45%">전체 기사 보기</h2>
        </div>

    </div>
</div>

</body>
</html>
