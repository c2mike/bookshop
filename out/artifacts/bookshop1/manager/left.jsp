<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/21
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="#">分类管理</a><br>
<a href="${pageContext.request.contextPath}/selectcategory" target="body">查看分类</a><br>
<a href="${pageContext.request.contextPath}/insertcategory" target="body">添加分类</a><br><br><br><br>
<a href="#">图书管理</a><br>
<a href="${pageContext.request.contextPath}/selectbook" target="body">查看图书</a><br>
<a href="${pageContext.request.contextPath}/insertbook" target="body">添加图书</a><br><br><br><br>
<a href="#">订单管理</a><br>
</body>
</html>
