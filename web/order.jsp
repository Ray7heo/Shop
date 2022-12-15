<%--
  Created by IntelliJ IDEA.
  User: Theo
  Date: 2022-12-15
  Time: 下午 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>个人订单</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="js/jquery-3.6.1.min.js"></script>
    <script>
        function updateOrder(id) {

            let status = $("#status" + id + " option:selected").val()
            let paytype = $("#pay" + id + " option:selected").val()
            $.post("updateOrderServlet", {
                id: id,
                status: status,
                paytype: paytype
            }, function (data, status) {
                alert("修改成功")
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
            <th scope="col">订单总额</th>
            <th scope="col">订单数量</th>
            <th scope="col">订单的状态</th>
            <th scope="col">支付方式</th>
            <th scope="col">订单时间</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${orderList!=null}">
            <c:forEach items="${orderList}" var="item" varStatus="status">
                <tr>
                    <th scope="row">
                    </th>
                    <td>${item.total}</td>
                    <td>${item.amount}</td>
                    <td>
                        <select class="custom-select" id="status${item.id}">
                            <c:if test="${item.status==0}">
                                <option value="0" selected>未支付</option>
                            </c:if>
                            <c:if test="${item.status!=0}">
                                <option value="0">未支付</option>
                            </c:if>
                            <c:if test="${item.status==1}">
                                <option value="1" selected>已支付</option>
                            </c:if>
                            <c:if test="${item.status!=1}">
                                <option value="1">已支付</option>
                            </c:if>
                            <c:if test="${item.status==2}">
                                <option value="2" selected>已发货</option>
                            </c:if>
                            <c:if test="${item.status!=2}">
                                <option value="2">已发货</option>
                            </c:if>
                            <c:if test="${item.status==3}">
                                <option value="3" selected>已收货</option>
                            </c:if>
                            <c:if test="${item.status!=3}">
                                <option value="3">已收货</option>
                            </c:if>
                            <c:if test="${item.status==4}">
                                <option value="4" selected>撤销</option>
                            </c:if>
                            <c:if test="${item.status!=4}">
                                <option value="4">撤销</option>
                            </c:if>


                        </select>
                    </td>
                    <td>
                        <select class="custom-select" id="pay${item.id}">
                            <c:if test="${item.status==1}">
                                <option value="1" selected>微信</option>
                            </c:if>
                            <c:if test="${item.status!=1}">
                                <option value="1">微信</option>
                            </c:if>
                            <c:if test="${item.status==2}">
                                <option value="2" selected>支付宝</option>
                            </c:if>
                            <c:if test="${item.status!=2}">
                                <option value="2">支付宝</option>
                            </c:if>
                            <c:if test="${item.status==3}">
                                <option value="3" selected>银联</option>
                            </c:if>
                            <c:if test="${item.status!=3}">
                                <option value="3">银联</option>
                            </c:if>
                        </select>
                    </td>
                    <td>
                        <fmt:formatDate value="${item.order_time}" pattern="yyyy:MM:dd hh:mm:ss"></fmt:formatDate>
                    </td>
                    <td>
                        <a type="button" class="btn btn-primary" onclick="updateOrder(${item.id})">修改订单</a>
                        <a type="button" class="btn btn-danger" onclick="showOrderItem(${item.id})">订单详情</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>
</div>
</body>
</html>
