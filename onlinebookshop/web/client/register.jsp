<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/27
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        form.pos_abs
        {
            position: absolute;
            left:600px;
            top:150px
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/userservlet" method="post" class="pos_abs">
    <input type="text" name="username" required>用户名<br>
    <input type="password" name="password" required>密码<br>
    <input type="text" name="email" >邮箱<br>
    <input type="text" name="phone" required>电话<br>
    <input type="text" name="address" required>收货地址<br>
    <input type="hidden" name="randomstr" value="${randomstr}">
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
