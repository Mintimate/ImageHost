<%@ page import="cn.mintimate.entity.User_Comment" %>
<%@ page import="cn.mintimate.repository.impl.CommentRepositoryImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.mintimate.repository.CommentRepository" %><%--
  Created by IntelliJ IDEA.
  User: mintimate
  Date: 2020/5/11
  Time: 11:30 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论管理</title>
    <link rel="stylesheet" type="text/css" href="/resources/layui/css/layui.css" media="all">

</head>
<body>
<%
    CommentRepository commentRepository = new CommentRepositoryImpl();
    List<User_Comment> list = commentRepository.Get_Comment();
    for (User_Comment comment : list) {
        request.setAttribute("comment", comment);
%>
全部评论：
<table class="layui-table">
    <thead>
    <tr>
        <th width="20%">用户:${comment.user_name}</th>
        <th width="60%">时间:${comment.date}</th>
        <th><a class="layui-btn layui-btn-danger layui-btn-fluid" href="/Data?del=${comment.id}">删除</a></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td colspan="3">${comment.details}</td>
    </tr>
    </tbody>
</table>
<%
    }
%>
<script>
    //取出传回来的参数error并与yes比较
    var errori ='<%=request.getParameter("error")%>';
    if(errori=='yes'){
        alert("操作有误!");
    }
</script>
</body>
</html>
