<%--
  Created by IntelliJ IDEA.
  User: Theo
  Date: 2022-12-13
  Time: 上午 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">首页 </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">我的订单</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="cart.jsp">我的购物车</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">我的个人信息</a>
            </li>
        </ul>
        <div class="my-2 my-lg-0">
            <span class="text-info">${user.name}</span>
        </div>
    </div>
</nav>
</body>
</html>
