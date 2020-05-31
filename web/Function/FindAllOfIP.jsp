<%@ page import="java.util.List" %>
<%@ page import="cn.mintimate.repository.CommentRepository" %>
<%@ page import="cn.mintimate.repository.impl.CommentRepositoryImpl" %>
<%@ page import="cn.mintimate.entity.User_Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>IP Count</title>
    <link rel="stylesheet" type="text/css" href="/resources/layui/css/layui.css" media="all">

</head>
<body>
<table id="demo" lay-filter="test"></table>
<script src="/resources/layui/layui.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            , page: true //开启分页
            ,limit: 10
            ,cellMinWidth:300
            , url: '/json/IP_Count' //数据接口
            , cols: [[ //表头
                {field: 'id', title: 'id',  sort: true, fixed: 'left'}
                , {field: 'IP', title: 'IP'}
                , {field: 'date', title: 'date', sort: true}
            ]]

        });

    });
</script>
</body>
</html>
