<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/24
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/insertbook" method="post" enctype="multipart/form-data">
    <input type="text" name="name">书名<br>
    <input type="text" name="description">描述<br>
    <input type="text" name="author">作者<br>
    <input type="text" name="price">价格<br>
    <input type="text" name="categoryname">分类名称<br>

    <input type="file" name="file">图片<br>

    <input type="submit" value="提交">
    <input type="reset" value="重置"><br>
</form>
</body>
</html>
