<%@ page import="dao.ArticleDao" %>
<%@ page import="org.apache.tomcat.jdbc.pool.DataSource" %>
<%@ page import="service.CrawlingService" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Article" %><%--
  Created by IntelliJ IDEA.
  User: son
  Date: 2020/08/24
  Time: 3:03 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>전체 기사 목록</title>

    <style type="text/css">
        #wrap {
            margin:5% 10%
        }

        #board, #pageForm, #searchForm{
            text-align :center;
        }

        #bList {
            text-align: center;
            margin: 0 auto;
        }

    </style>



</head>
<body>


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
            <h2 style="float:right; width:45%"><a href="/list?nowPage=1">전체 기사 보기</a></h2>
        </div>

    </div>

    <div id="board">
        <table id="bList" width="80%" border="3" bordercolor="lightgray">
            <colgroup>
                <col width="5%">
                <col width="10%">
                <col width="5%">
                <col width="60%">
                <col width="15%">
                <col width="5%">
            </colgroup>
            <thead>
                <tr height="40">
                    <th scope="col">번호</th>
                    <th scope="col">언론사</th>
                    <th scope="col">분야</th>
                    <th scope="col">제목</th>
                    <th scope="col">작성일</th>
                    <th scope="col">조회수</th>
                </tr>
            </thead>
            <tbody>

               <c:forEach items="${viewAll}" var="list">
                   <tr>
                       <td>${list.article_id}</td>
                       <td>${list.article_press}</td>
                       <td>${list.article_theme}</td>
                       <td><a href="article?id=${list.article_id}">${list.article_title}</a></td>
                       <td>${list.article_written_time}</td>
                       <td>1</td>
                   </tr>
               </c:forEach>

            </tbody>
        </table>


        <div style="display: block; text-align: center;">
            <c:if test="${paging.startPage != 1 }">
                <a href="${pageContext.request.contextPath}/list?nowPage=${paging.startPage - 1 }">&lt;</a>
            </c:if>
            <c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
                <c:choose>
                    <c:when test="${p == paging.nowPage }">
                        <b>${p }</b>
                    </c:when>
                    <c:when test="${p != paging.nowPage }">
                        <a href="${pageContext.request.contextPath}/list?nowPage=${p }">${p }</a>
                    </c:when>
                </c:choose>
            </c:forEach>
            <c:if test="${paging.endPage != paging.lastPage}">
                <a href="${pageContext.request.contextPath}/list?nowPage=${paging.endPage+1 }">&gt;</a>
            </c:if>
        </div>
    </div>



    <br>
    <div id="searchForm">
        <form>
            <select name="opt">
                <option value="0">제목</option>
                <option value="1">내용</option>
                <option value="2">제목+내용</option>
                <option value="3">글쓴이</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="검색"/>
        </form>
    </div>
</div>

</body>
</html>
