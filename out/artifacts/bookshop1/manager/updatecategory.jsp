<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/24
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/updatecategory" method="post">
        <input type="text" name="name">分类名称<br>
        <input type="text" name="description">描述<br>
        <input type="hidden" name="id" value="${id}"><br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
</body>
</html>
