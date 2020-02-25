<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/28
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<table border="1px" class="pos_abs">
    <tr>
        <td>书名称</td>
        <td>数量</td>
        <td>单价</td>
        <td>图片</td>
    </tr>
    <c:forEach var="me" items="${order.items}">
        <tr>
        <td>${me.book.name}</td>
        <td>${me.count}</td>
        <td>${me.book.price}</td>
        <td><img src="${pageContext.request.contextPath}/upload/${me.book.pic}"></img></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
