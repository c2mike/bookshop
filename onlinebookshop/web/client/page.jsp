<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/27
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/util.js"></script>
当前页数是:[${page.currentpagenum}]
<c:if test="${page.currentpagenum>1}">
    <a href="${pageContext.request.contextPath}/clientservlet?pagenum=${page.currentpagenum-1}">上一页</a>

</c:if>
<c:forEach var="me" begin="${page.startnum}" end="${page.endnum}">
    <a href="${pageContext.request.contextPath}/clientservlet?pagenum=${me}" >${me}</a>
</c:forEach>
<c:if test="${page.currentpagenum<page.totalpage}">
    <a href="${pageContext.request.contextPath}/clientservlet?pagenum=${page.currentpagenum+1}">下一页</a>
</c:if>
<input type="text" id="currentpage">
<input type="button" value="跳转" onclick="getpagebook2()">

