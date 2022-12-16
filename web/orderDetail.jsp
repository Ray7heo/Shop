<%--
  Created by IntelliJ IDEA.
  User: Theo
  Date: 2022-12-16
  Time: 上午 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">

</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">首页 </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="showOrderServlet?uid=${user.id}">我的订单</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="showCartServlet?uid=${user.id}">我的购物车</a>
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

    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">商品名称</th>
            <th scope="col">商品图片</th>
            <th scope="col">价格</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${orderItemList!=null}">
            <c:forEach items="${orderItemList}" var="item" varStatus="status">
                <tr>
                    <td></td>
                    <td>${item.goods.name}</td>
                    <td>
                        <img src="${item.goods.image1}" class="img-thumbnail" width="150" height="150">
                    </td>
                    <td>${item.goods.price}</td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>
</div>
</body>
</html>
