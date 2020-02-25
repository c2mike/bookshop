<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/28
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table.pos_abs
        {
            position: absolute;
            left:600px;
            top:150px
        }
    </style>
</head>
<body>
<c:if test="${user==null}">
    请先登录
</c:if>
<c:if test="${!empty(orders)}">
    <table border="1px" class="pos_abs">
        <tr>
            <td>日期</td>
            <td>下单人姓名</td>
            <td>下单人电话号码</td>
            <td>状态</td>
            <td>总价</td>
            <td>收货地址</td>
        </tr>
        <c:forEach var="me" items="${orders}">
            <tr>
                <td>${me.showdate}</td>
                <td>${user.username}</td>
                <td>${user.phone}</td>
                <td>${me.state}</td>
                <td>${me.price}</td>
                <td>${user.address}</td>
                <td><a href="/bookshop/orderservlet?func=showorderdetail&orderid=${me.id}">查看详情</a></td>
                <c:if test="${me.state eq '未支付'}">
                    <td><a href="/bookshop/orderservlet?func=pay&orderid=${me.id}">支付</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
