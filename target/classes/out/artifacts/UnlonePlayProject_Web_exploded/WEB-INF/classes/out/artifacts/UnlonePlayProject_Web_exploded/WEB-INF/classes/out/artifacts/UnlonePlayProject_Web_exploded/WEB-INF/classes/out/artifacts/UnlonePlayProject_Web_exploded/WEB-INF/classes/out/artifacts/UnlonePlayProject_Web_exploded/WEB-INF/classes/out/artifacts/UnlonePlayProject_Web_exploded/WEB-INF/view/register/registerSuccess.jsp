<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 2020/08/19
  Time: 11:16 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>환영합니다. ${registerRequest.name}</p>
<p><a href="<c:url value='/index'/>">[홈으로 가기]</a></p>

</body>
</html>
