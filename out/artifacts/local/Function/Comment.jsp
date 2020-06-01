<%@ page import="java.util.List" %>
<%@ page import="cn.mintimate.repository.CommentRepository" %>
<%@ page import="cn.mintimate.repository.impl.CommentRepositoryImpl" %>
<%@ page import="cn.mintimate.entity.User_Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>评论列表页面</title>
    <link rel="stylesheet" type="text/css" href="/resources/layui/css/layui.css" media="all">

</head>
<body>
<form method="post" action="/Data">
    <table class="layui-table" lay-even lay-skin="nob">
        <thead>
        <tr>
            <th width="50%">来写个评论，留下自己的脚步吧(´▽｀)</th>
            <th width="10%">当前用户:</th>
            <th>
                <select name="username" class="layui-btn layui-btn-disabled layui-btn-fluid">
                    <option value="${sessionScope.guest}" selected>${sessionScope.guest}</option>
                </select>
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td colspan="4"><textarea name="details" placeholder="请输入内容" class="layui-textarea"></textarea></td>
        </tr>
        <tr>
            <td colspan="1">
                <button type="reset" class="layui-btn  layui-btn-danger layui-btn-fluid">取消</button>
            </td>
            <td colspan="3">
                <button type="submit" class="layui-btn layui-btn-fluid">提交</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
全部评论：
<%
    CommentRepository commentRepository = new CommentRepositoryImpl();
    List<User_Comment> list = commentRepository.Get_Comment();
    for (User_Comment user_comment : list) {
        request.setAttribute("comment", user_comment);
%>
<table class="layui-table">
    <thead>
    <tr>
        <th width="20%">用户:${comment.user_name}</th>
        <th>时间:${comment.date}</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td colspan="2" align="center">${comment.details}</td>
    </tr>
    </tbody>
</table>
<%
    }
%>
<script>
    //取出传回来的参数error并与yes比较
    var errori = '<%=request.getParameter("error")%>';
    if (errori == 'yes') {
        alert("操作有误!");
    }
</script>
</body>
</html>
