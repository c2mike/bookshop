<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/21
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理界面</title>
</head>
<frameset rows="25%,*">
    <frame src="manager/head.jsp">
    <frameset cols="25%,*">
        <frame src="manager/left.jsp">
        <frame src="manager/body.jsp" name="body">
    </frameset>
</frameset>
</html>
