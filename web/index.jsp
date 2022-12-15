<%--
  Created by IntelliJ IDEA.
  User: Theo
  Date: 2022-12-12
  Time: 下午 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="js/jquery-3.6.1.min.js"></script>

    <script>
        function addCart(userId, goodsId) {
            $.post("addCartServlet", {
                userId: userId,
                goodsId: goodsId
            }, function (data, status) {
                alert(data)
            });
        }
    </script>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">首页 </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="showOrderServlet?uid=${user.id}">我的订单</a>
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
    <div class="row row-cols-3 no-gutters">
        <c:if test="${goodsList!=null}">
            <c:forEach items="${goodsList}" var="goods">
                <div class="card col" style="width: 16rem;">
                    <img src="${goods.image1}" class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title text-danger">￥${goods.price}</h5>
                        <p class="card-text">${goods.desc}</p>
                        <a id="a" class="btn btn-outline-danger" onclick="addCart(${user.id}, ${goods.id})">加入购物车</a>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${goodsList==null}">
            <p class="text-danger text-center">获取失败!!!</p>
        </c:if>
    </div>
    <%--    <div class="text-center footer bg-light">--%>
    <%--        <p>21软件1班孟成挺:P20210304132</p>--%>
    <%--    </div>--%>
</div>
</body>
</html>
