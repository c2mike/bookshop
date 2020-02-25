<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/24
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath}/util.js"></script>
<meta  http-equiv="Content-Type"; content="text/html"; charset="utf-8">
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty(bookpage.data)}">
    ${"暂时没有任何图书"}
</c:if>
<c:if test="${!empty(bookpage.data)}">
    <table border="1px">
        <tr>
            <td>书名</td>
            <td>书描述</td>
            <td>作者</td>
            <td>价格</td>
            <td>分类</td>
            <td>图片</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <c:forEach var="me" items="${bookpage.data}">
            <tr>
                <td>
                        ${me.name}
                </td>
                <td>
                        ${me.description}
                </td>
                <td>
                        ${me.author}
                </td>
                <td>
                        ${me.price}
                </td>
                <td>
                        ${me.categoryname}
                </td>
                <td>
                        <img src="${pageContext.request.contextPath}/upload${me.pic}">
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/updatebook?id=${me.id}">修改</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/deletebook?id=${me.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${!empty(bookpage.data)}">
    <c:forEach var="me" begin="${bookpage.startnum}" end="${bookpage.endnum}">
        <a href="${pageContext.request.contextPath}/selectbook?pagenum=${me}">${me}</a>
    </c:forEach>
</c:if>
<c:if test="${!empty(bookpage.data)}">
    <a href="${pageContext.request.contextPath}/selectbook?pagenum=${bookpage.currentpagenum+1}">"下一页"</a>
    <a href="${pageContext.request.contextPath}/selectbook?pagenum=${bookpage.currentpagenum-1}">"上一页"</a>
    <input type="text" id="currentpage">
    <input type="button" value="跳转" onclick="getpagebook()">
</c:if>
</body>
</html>
