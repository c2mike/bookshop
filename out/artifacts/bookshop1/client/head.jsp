<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <!-- link rel="stylesheet" href="head.css" type="text/css"-->
    <script src="${pageContext.request.contextPath}/util.js"></script>
</head>
<body >

    <a href="${pageContext.request.contextPath}/clientservlet" target="body">返回首页</a>
        <a href="/bookshop/shoppingcartservlet?func=showcart" target="body">查看购物车</a>
        <a href="/bookshop/orderservlet?func=showorder" target="body">查看订单</a>
        <a href="/bookshop/userservlet?func=register" target="body">注册</a>
        <a href="/bookshop/manager.jsp" target="body">进入后台</a>
    <c:if test="${user==null}">
        <a href="/bookshop/client/login.jsp" target="body">登录</a>
        </c:if>
        体验账号：mike，密码：cc

</body>
</html>
