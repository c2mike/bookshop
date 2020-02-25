<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/21
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$在线书城前台系统$</title>

  </head>
<frameset rows="25%,*">
  <frame src="client/head.jsp" name="head">
  <frame src="${pageContext.request.contextPath}/clientservlet" name="body">
</frameset>
</html>
