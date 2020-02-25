<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="client.css" type="text/css">
    <script src="/util.js" type="text/javascript"></script>
</head>
<body>
<div id="body">
    <div id="category">
        书籍分类：
        <br>
        <c:forEach var="me" items="${categories}">
            <li>
                <a href="${pageContext.request.contextPath}/getbookbycategory?name=${me.name}">${me.name}</a>
            </li>
        </c:forEach>
    </div>

    <div id="bookandpages">
        <c:forEach var="me2" items="${page.data}">

        <div id = "books">
            <div id="image">
                <img src="${pageContext.request.contextPath}/upload${me2.pic}" width="83px" height="118px">
            </div>
            <div id = "bookinfo">
                <li>
                    书名：${me2.name}
                </li>
                <li>
                    作者:${me2.author}
                </li>
                <li>
                    价格：${me2.price}
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/shoppingcartservlet?func=buy&id=${me2.id}">购买此书</a>
                </li>
            </div>
        </div>
            <div style="clear:both"></div>
        </c:forEach>
        <!-- clear -->
    </div>
    <div id="page">
        <jsp:include page="/client/page.jsp" ></jsp:include>
    </div>
</div>
</body>
</html>
