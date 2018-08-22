<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="com.entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.util.WebUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>
    <style type="text/css">
        /*table {
            border: 1px solid black;
            border-collapse: collapse;
            width: 800px;
        }

        th, td {
            border: 1px solid black;
            text-align: center;
        }*/
    </style>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <%=WebUtil.getSessionValue(request)%>
    <form method="get" action="/book/bookFind">
        <label>名称：</label><input type="text" name="name">
        <input type="submit" value="查询" class="btn btn-primary"/>
    </form>

    <form method="post" action="/book/delBook">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th>全选</th>
                <th>ID</th>
                <th>名称</th>
                <th>价钱</th>
                <th>作者</th>
                <th>操作</th>
            </tr>
            </thead>
            <%
                List<Book> bookList = (List<Book>) request.getAttribute("bookList");
                for (Book book : bookList) {
            %>
            <tr>
                <td><input type="checkbox" value="<%=book.getId()%>" name="check"></td>
                <td><%=book.getId()%>
                </td>
                <td><a href="/book/BookById?id=<%=book.getId()%>"><%=book.getName()%>
                </a></td>
                <td><%=book.getPrice()%>
                </td>
                <td><%=book.getWritter()%>
                </td>
                <td><a href="/book/delBook?id=<%=book.getId()%>">删除</a> | <a href="/book/updBook?id=<%=book.getId()%>">编辑</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <br/>
        <input type="submit" value="批量删除" class="btn btn-primary"/>
    </form>
    <a href="/book/addBook">快快快快快点我，添加新的东西。。。。。</a>
</div>
</body>
</html>
