<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 2020/08/19
  Time: 11:13 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
