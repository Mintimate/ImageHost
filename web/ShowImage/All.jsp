<%@ page import="cn.mintimate.entity.Public_Image" %>
<%@ page import="cn.mintimate.service.FindImgService" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.mintimate.service.impl.FindImgServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: mintimate
  Date: 2020/5/11
  Time: 7:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">
    <link rel="stylesheet"  type="text/css" href="/resources/css/HideWebkit.css">
</head>
<body>
<style>
    .layui-table-cell{
        height:36px;
        line-height: 36px;
    }
    .layui-table img {
        height: 55px;
    }
</style>
<div style="padding: 15px; height: 100%">
    <%
        FindImgService findImgService=new FindImgServiceImpl();
        List<Public_Image> list=findImgService.FindImgService();
    %>
    <table class="layui-table" lay-size="lg">
        <thead>
        <tr>
            <th>图片ID</th>
            <th>图片名称</th>
            <th>图片预览图</th>
            <th>加入时间</th>
            <th>下载数量</th>
            <th>下载地址</th>
        </tr>
        </thead>
        <tbody>
        <% for (Public_Image public_image : list) {
            request.setAttribute("public_image", public_image);
        %>
        <tr style="height: 10%">
            <td height="100px">${public_image.id}</td>
            <td height="100px">${public_image.image_name}</td>
            <td height="100px"><img src="${public_image.path}" /></td>
            <td height="100px">${public_image.creation_date}</td>
            <td height="100px">${public_image.download_count}</td>
            <td height="100px"><a href="/DownloadImage?filename=${public_image.image_name}&id=${public_image.id}">Here</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>