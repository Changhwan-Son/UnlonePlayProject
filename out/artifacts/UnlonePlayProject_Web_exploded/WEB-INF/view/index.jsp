<%@ page import="java.util.List" %>
<%@ page import="model.Article" %>
<%@ page import="service.CrawlingService" %>
<%@ page import="dao.ArticleDao" %><%--
  Created by IntelliJ IDEA.
  User: son
  Date: 2020/08/18
  Time: 12:24 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UnlonePlay</title>
</head>
<body style="margin:5% 10%">
<div class="frame">
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


    <div class="time" style="text-align: center" >
        <h2>20xx년 xx월 xx일 xx시</h2>
    </div>

    <%
        List<Article> articles = (List<Article>)request.getAttribute("articles");
        //Article article = articles.get(0);

    %>

    <c:set var="articles" value="<%=articles%>"/>
    <div class="container" style="height:130%">
        <div class="container_line1" style="width:100%; height:33%" >
            <div class="container_article" style="width:33%; float:left" >
                <h2>경향신문</h2>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; ">
                        <a>
                            <img src="${articles.get(0).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>

                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(0).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(0).article_content}</p>
                    </div>
                </div>

                <div class="press1_article2">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(1).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(1).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(1).article_content}</p>
                    </div>
                </div>
            </div>

            <div class="container_article" style="width:33%; float:left" >

            </div>

            <div class="container_article" style="width:33%; float:right" >
                <h2>조선일보</h2>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(2).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(2).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(2).article_content}</p>
                    </div>
                </div>

                <div class="press1_article2">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(3).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(3).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(3).article_content}</p>
                    </div>
                </div>
            </div>


        </div>

        <div class="container_line2" style="width:100%;height:33%">
            <div class="container_article" style="width:33%; float:left" >
                <h2>한겨례</h2>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(4).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(4).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(4).article_content}</p>
                    </div>
                </div>

                <div class="press1_article2">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(5).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(5).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(5).article_content}</p>
                    </div>
                </div>
            </div>

            <div class="container_article" style="width:33%;float:left ; text-align: center" >
                <p><h2>키워드 들어갈 자리</h2> </p>
                <p>1. 키워드 1</p>
                <p>2. 키워드 2</p>
                <p>3. 키워드 3</p>
            </div>

            <div class="container_article" style="width:33%; float:right" >
                <h2>중앙일보</h2>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(6).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(6).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(6).article_content}</p>
                    </div>
                </div>

                <div class="press1_article2">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(7).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(7).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(7).article_content}</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="container_line3" style="width:100%;height:33%">
            <div class="container_article" style=" width:33%; float:left" >
                <h2>오마이뉴스</h2>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(8).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(8).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(8).article_content}</p>
                    </div>
                </div>

                <div class="press1_article2">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(9).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(9).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(9).article_content}</p>
                    </div>
                </div>
            </div>

            <div class="container_article" style="width:33%; float:left" >

            </div>

            <div class="container_article" style="width:33%; float:right" >
                <h2>동아일보</h2>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(10).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(10).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(10).article_content}</p>
                    </div>
                </div>

                <div class="press1_article2">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <a>
                            <img src="${articles.get(11).article_image}" width="70%" height="30%"/>
                        </a>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2 style="overflow:hidden;white-space: nowrap; text-overflow: ellipsis">${articles.get(11).article_title} </h2>
                        <p style="overflow:hidden;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;">${articles.get(11).article_content}</p>
                    </div>
                </div>
            </div>
        </div>


    </div>



    <div class="footer">

        footer입니다.
    </div>

</div>
</body>
</html>
