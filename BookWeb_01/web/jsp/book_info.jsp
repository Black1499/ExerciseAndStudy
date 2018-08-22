<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="com.entity.Book" %>
<%@ page import="com.util.WebUtil" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/15
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书详细</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <%=WebUtil.getSessionValue(request)%>

    <%Book book = (Book) request.getAttribute("book");%>
    <h4>ID：<%=book.getId()%>
    </h4>
    <h4>名称：<%=book.getName()%>
    </h4>
    <h4>价钱：<%=book.getPrice()%>
    </h4>
    <h4>作者：<%=book.getWritter()%>
    </h4>
</div>
</body>
</html>
