<%--
  Created by IntelliJ IDEA.
  User: Theo
  Date: 2022-12-12
  Time: 下午 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="loginServlet" method="post" id="loginForm">
    <div class="form-group">
        <label for="username">用户名:</label>
        <input type="text" class="form-control" id="username" name="username">
    </div>
    <div class="form-group">
        <label for="password">密 码:</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>
    <button type="submit" class="btn btn-primary">登录</button>
</form>
<p class="text-center text-danger">${msg}</p>
</body>
</html>
