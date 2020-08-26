<%@ page import="model.Article" %><%--
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

<%
    Article article = (Article)request.getAttribute("article");
%>

<div id="wrap">
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

    <div class="container" >
        <div class="article_press">
            <h3><%=article.getArticle_press()%></h3>
        </div>

        <div class="article_title">
            <h1><%=article.getArticle_title()%></h1>
        </div>

        <div class="article_date" style="text-align: right">
            <p>작성:<%=article.getArticle_written_time()%>
               수정:<%=article.getArticle_modified_time()%></p>
        </div>

        <div class="article_image"  style="text-align: center">
            <img src="<%=article.getArticle_image()%>"/>
        </div>

        <br/>
        <div class="article_body">
            <p><%=article.getArticle_content()%></p>
        </div>

        <div class="article_url">
            <p>원본 url: <a href="<%=article.getArticle_url()%>"><%=article.getArticle_url()%></a></p>
        </div>
    </div>
</div>



</body>
</html>
