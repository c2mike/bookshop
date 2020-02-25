<%--
  Created by IntelliJ IDEA.
  User: mayun
  Date: 2020/1/29
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        var iscommit = false;
        function formcommitonce() {
            if(iscommit==false)
            {
                iscommit = true;
                return true;
            }
            else
            {
                return false;
            }
        }
    </script>
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
<form action="${pageContext.request.contextPath}/userservlet?func=login" method="get" class="pos_abs">
    <input type="text" name="username" required>用户名<br>
    <input type="password" name="password" required>密码<br>
    <input type="text" name="checkstr" required>
    <img src="/bookshop/imgservlet"><br>
    <input type="hidden" name="func" value="login">
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
