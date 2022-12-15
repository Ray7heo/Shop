<%--
  Created by IntelliJ IDEA.
  User: Theo
  Date: 2022-12-13
  Time: 下午 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的购物车</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="js/jquery-3.6.1.min.js"></script>
    <script>
        function updateCartItem(id) {
            let amount = $("#amount" + id).val();
            $.post("updateCartItemServlet", {
                itemId: id,
                amount: amount
            }, function (data, status) {
                alert("修改成功")
                location.reload()
            });
        }

        function delCartItem(id) {
            $.post("delCartItemServlet", {
                cid: id
            }, function (data, status) {
                alert("删除成功")
                location.reload()
            });
        }

        function submitOrder() {
            if ($(":checked").length === 0) {
                alert("请选择购物车中的项目!!!")
                return
            }
            let checked = ''
            for (let i = 0; i < $(":checked").length; i++) {
                checked += $(":checked")[i].value + ","
            }
            checked = checked.substring(0, checked.length - 1)
            $.post("addOrderServlet", {
                checked: checked
            }, function (data, status) {
                alert(data)
                location.reload()
            })
        }
    </script>
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
                    <a class="nav-link" href="#">我的订单</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active">我的购物车</a>
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
            <th scope="col">数量</th>
            <th scope="col">总金额</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${cartItems!=null}">
            <c:forEach items="${cartItems}" var="item" varStatus="status">
                <tr>
                    <th scope="row">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="${item.id}" id=${item.id}>
                            <label class="form-check-label" for="${item.id}">${status.index+1}</label>
                        </div>
                    </th>
                    <td>${item.goods.name}</td>
                    <td>
                        <img src="${item.goods.image1}" class="img-thumbnail" width="150" height="150">
                    </td>
                    <td>${item.goods.price}</td>
                    <td>
                        <div class="form-group mx-sm-2 mb-2">
                            <input type="number" class="form-control" id="amount${item.id}"
                                   value="${item.amount}" min="1" name="amount">
                        </div>
                    </td>
                    <td>${item.goods.price*item.amount}</td>
                    <td>
                        <a type="button" class="btn btn-primary" onclick="updateCartItem(${item.id})">修改</a>
                        <a type="button" class="btn btn-danger" onclick="delCartItem(${item.id})">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>
    <div class="text-right">
        <button class="btn btn-outline-success" type="button" onclick="submitOrder()">提交</button>
    </div>

</div>
</body>
</html>
