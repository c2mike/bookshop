<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/28
  Time: 5:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/bookshop/util.js"></script>
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
<c:if test="${cart==null}">
    你还没有添加商品
</c:if>
<table border="1px" class="pos_abs">
<c:if test="${cart!=null}">
    <tr>
        <td>书名</td>
        <td>作者</td>
        <td>描述</td>

        <td>单价</td>
        <td>数量</td>
        <td>图片</td>
    </tr>
</c:if>

    <c:forEach var="me" items="${cart}">
        <tr>
            <td>
                    ${me.value.book.name}
            </td>

            <td>
                    ${me.value.book.author}
            </td>

            <td>
                ${me.value.book.description}
            </td>

            <td>
                    ${me.value.book.price}
            </td>

            <td>
                    ${me.value.count}
            </td>

            <td>
                <img src="${pageContext.request.contextPath}/upload/${me.value.book.pic}">
            </td>
        </tr>
    </c:forEach>
    <c:if test="${!empty(cart)}">
        <tr>
            <td><input type="button" value="清空" onclick="clearshoppingcart()"></td>
            <td><input type="button" value="提交订单" onclick="commitorder()"></td>
        </tr>
    </c:if>
</table>
</body>
</html>
