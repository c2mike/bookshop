<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/23
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath}/util.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty(categorylist.data)}">
    ${"暂时没有任何图书分类"}
</c:if>

<c:if test="${!empty(categorylist.data)}">
    <table border="1px">
        <tr>
            <td>分类名称</td>
            <td>分类描述</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <c:forEach var="me" items="${categorylist.data}">
            <tr>
                <td>
                    ${me.name}
                </td>
                <td>
                    ${me.description}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/updatecategory?id=${me.id}">修改</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/deletecategory?id=${me.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${!empty(categorylist.data)}">
    <c:forEach var="me" begin="${categorylist.startnum}" end="${categorylist.endnum}">
        <a href="${pageContext.request.contextPath}/selectcategory?pagenum=${me}">${me}</a>
    </c:forEach>
</c:if>
<c:if test="${!empty(categorylist.data)}">
    <a href="${pageContext.request.contextPath}/selectcategory?pagenum=${categorylist.currentpagenum+1}">"下一页"</a>
    <a href="${pageContext.request.contextPath}/selectcategory?pagenum=${categorylist.currentpagenum-1}">"上一页"</a>
    <input type="text" id="currentpage">
    <input type="button" value="跳转" onclick="getpage()">
</c:if>
</body>
</html>
