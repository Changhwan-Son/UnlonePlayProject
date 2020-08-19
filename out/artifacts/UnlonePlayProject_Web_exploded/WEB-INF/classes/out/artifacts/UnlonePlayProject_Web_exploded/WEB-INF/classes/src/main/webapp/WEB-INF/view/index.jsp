<%--
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
        <div style="border: 1px solid gold; float: left; width: 25%; ">
            <h1>웹 페이지 이름</h1>
        </div>

        <c:if test="${empty authInfo}">
            <div style="border: 1px solid red; float: right; width: 20%; ">
                <a href="<c:url value='/login'/>"><h2 style="float:left; width:50%">로그인</h2></a>
                <a href="<c:url value='/register'/>"><h2 style="float:left; width:50%">회원가입</h2></a>
            </div>
        </c:if>

        <c:if test="${! empty authInfo }">
            <div style="border: 1px solid red; float: right; width: 20%; ">
            <h2 style="float:left; width:50%">${authInfo.name}</h2>
                <a href="<c:url value='/logout'/>"><h2 style="float:left; width:50%">로그아웃</h2></a>
            </div>
        </c:if>

        <div style="border: 1px solid blue; float: right; width: 45%;">
            <h2 style="float:left; width:33%">정치</h2>
            <h2 style="float:left; width:33%">경제</h2>
            <h2 style="float:left; width:33%">사회</h2>
        </div>

    </div>


    <div class="time" style="border: 1px solid gold; text-align: center" >
        <h2>20xx년 xx월 xx일 xx시</h2>
    </div>

    <div class="container">
        <div class="container_line1" style="width:100% ;height:33%" >
            <div class="container_article" style="border: 1px solid gold; width:33%; float:left" >
                <p>언론사 사진 들어갈 자리</p>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <p>사진</p>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2>기사 제목 들어갈 자리</h2>
                        <p>기사 내용 들어갈 자리</p>
                    </div>
                </div>
            </div>

            <div class="container_article" style="border: 1px solid gold; width:33%; float:left" >
                <p>언론사 사진 들어갈 자리</p>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <p>사진</p>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2>기사 제목 들어갈 자리</h2>
                        <p>기사 내용 들어갈 자리</p>
                    </div>
                </div>
            </div>

            <div class="container_article" style="border: 1px solid gold; width:33%; float:left" >
                <p>언론사 사진 들어갈 자리</p>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <p>사진</p>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2>기사 제목 들어갈 자리</h2>
                        <p>기사 내용 들어갈 자리</p>
                    </div>
                </div>
            </div>


        </div>

        <div class="container_line2" style="width:100%;height:33%">
            <div class="container_article" style="border: 1px solid gold; width:33%; float:left" >
                <p>언론사 사진 들어갈 자리</p>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <p>사진</p>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2>기사 제목 들어갈 자리</h2>
                        <p>기사 내용 들어갈 자리</p>
                    </div>
                </div>
            </div>

            <div class="container_article" style="border: 1px solid gold; width:33%;float:left" >
                <p><h2>키워드 들어갈 자리</h2> </p>
                <p>1. 키워드 1</p>
                <p>2. 키워드 2</p>
                <p>3. 키워드 3</p>
            </div>

            <div class="container_article" style="border: 1px solid gold; width:33%; float:left" >
                <p>언론사 사진 들어갈 자리</p>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <p>사진</p>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2>기사 제목 들어갈 자리</h2>
                        <p>기사 내용 들어갈 자리</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="container_line3" style="width:100%;height:33%">
            <div class="container_article" style="border: 1px solid gold; width:33%; float:left" >
                <p>언론사 사진 들어갈 자리</p>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <p>사진</p>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2>기사 제목 들어갈 자리</h2>
                        <p>기사 내용 들어갈 자리</p>
                    </div>
                </div>
            </div>

            <div class="container_article" style="border: 1px solid gold; width:33%; float:left" >
                <p>언론사 사진 들어갈 자리</p>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <p>사진</p>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2>기사 제목 들어갈 자리</h2>
                        <p>기사 내용 들어갈 자리</p>
                    </div>
                </div>
            </div>

            <div class="container_article" style="border: 1px solid gold; width:33%; float:left" >
                <p>언론사 사진 들어갈 자리</p>
                <div class="press1_article1">
                    <div class="article_image" style="width:30%; float:left; text-align: center">
                        <p>사진</p>
                    </div>
                    <div class="article_content" style="width:70%; float:left">
                        <h2>기사 제목 들어갈 자리</h2>
                        <p>기사 내용 들어갈 자리</p>
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
