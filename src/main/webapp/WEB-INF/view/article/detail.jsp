<%@ page import="model.Article" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: son
  Date: 2020/08/24
  Time: 3:03 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>

<%--    <script type="text/javascript" src="<c:url value="../../resource/jquery-3.5.1.js"/>"></script>--%>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

    <style type="text/css">
        #wrap {
            margin:5% 10%
        }
    </style>

    <script>
        <%
            Article article = (Article)request.getAttribute("article");
        %>
        const reqBno = <%=article.getArticle_id()%>;

        <%
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Date now = new Date();

        %>
        const regReply = () => {

            const replyData = {
                article_id: reqBno,
                comment_writer: "${authInfo.name}",
                comment_content: $('#reply').val(),
                comment_written_time: "<%= fm.format(now)%>"
            };

            $.ajax({
                type: "post",
                url: "/newComment",
                data: JSON.stringify(replyData),	// 자바스크립트의 객체를 JSON 문자열화 시켜주는 함수
                contentType: "application/json; charset=utf-8", 	// contentType : 클라이언트가 서버에게 파라미터를 넘기면서 이건 json 이야~ 라고 알려주는 것
                success: function(item){

                    const template = '<div class="reply-wrapper">'+
                        '<p class="replyer"><strong>'+item['comment_writer']+'</strong>  <span class="reply-regdate">'+ moment(item['comment_written_time']).format("YYYY-MM-DD HH:mm")+'</span></p>'+
                        '<p class="reply">'+item['comment_content']+'</p></div>';


                    $(".reply-container").append(template);
                }
            });

        };
    </script>

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



        <br/>
        <br/>
        <br/>
        <br/>
        <h3>댓글</h3>

<c:if test="${! empty authInfo }">
        <div class="reply-input-container">

            <p>
				<textarea style="resize: none" id="reply"
                          placeholder="댓글 내용을 입력해 주세요"></textarea>
                <button id="btn-reply-reg" onclick="regReply()" style="margin:0 auto">댓글 등록</button>
            </p>
        </div>
</c:if>
        <div class="reply-container">

            <div class="reply-wrapper">
                <p class="replyer">
                <h4>작성자이름</h4> <span class="reply-regdate">2020-07-31</span>
                </p>
                <p class="reply">내용</p>
            </div>

        </div>
    </div>
</div>



</body>

<script>


    $.ajax({
        url : "/commentList/"+reqBno,
        success : function(response) {

            const replyList = response;
            const replyContainer = $(".reply-container");

            replyContainer.empty();

            replyList.forEach((item) => {

                const template = '<div class="reply-wrapper">'+
                    '<p class="replyer"><strong>'+item['comment_writer']+'</strong>  <span class="reply-regdate">'+ moment(item['comment_written_time']).format("YYYY-MM-DD HH:mm")+'</span>'+
                    '<p class="reply">'+item['comment_content']+'</p></div>';


                replyContainer.append(template);
            })

        }
    });
</script>
</html>
