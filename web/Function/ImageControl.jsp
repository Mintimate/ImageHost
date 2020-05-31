<%@ page import="cn.mintimate.entity.Public_Image" %>
<%@ page import="cn.mintimate.Service.impl.FindImgServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.mintimate.Service.FindImgService" %><%--
  Created by IntelliJ IDEA.
  User: mintimate
  Date: 2020/5/11
  Time: 3:13 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/HideWebkit.css">
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/js/MyTool.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#next").click(function(){
                var pages = parseInt($("#pages").html());
                var page = parseInt($("#currentPage").html());
                if(page == pages){
                    return;
                }
                page++;
                location.href = "/image?control=yes&page="+page;
            })

            $("#previous").click(function () {
                var page = parseInt($("#currentPage").html());
                if(page == 1){
                    return;
                }
                page--;
                location.href = "/image?control=yes&page="+page;
            })

            $("#first").click(function () {
                location.href = "/image?control=yes&page=1";
            })

            $("#last").click(function(){
                var pages = parseInt($("#pages").html());
                location.href = "/image?control=yes&page="+pages;
            })
        })
        //全选和全不选（第一个参数为复选框名称，第二个参数为是全选还是全不选）
        function allCheck(name, boolValue) {
            var allvalue = document.getElementsByName(name);
            for (var i = 0; i < allvalue.length; i++) {
                if (allvalue[i].type == "checkbox")
                    allvalue[i].checked = boolValue;
            }
        }

        //反选 参数为复选框名称
        function reserveCheck(name) {
            var revalue = document.getElementsByName(name);
            for (i = 0; i < revalue.length; i++) {
                if (revalue[i].checked == true)
                    revalue[i].checked = false;
                else
                    revalue[i].checked = true;
            }
        }
        function flash(){
            location.replace(document.referrer);
        }
    </script>

</head>
<body>
<style>
    .layui-table-cell {
        height: 36px;
        line-height: 36px;
    }

    .layui-table img {
        height: 55px;
    }
</style>
<div style="padding: 15px; height: 100%">
    <table class="layui-table" lay-size="lg">
        <thead>
        <tr>
            <th>选择</th>
            <th>图片名称</th>
            <th>图片预览图</th>
            <th>加入时间</th>
            <th>下载数量</th>
            <th>下载地址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="public_image">
        <form method="post" action="/image" onsubmit="return delete_all_check()" >
        <tr style="height: 10%">
                <td height="100px"><input type="checkbox" name="choice" value="${public_image.id}">
                </td>
                <td height="100px">${public_image.image_name}</td>
                <td height="100px"><img src="${public_image.path}"/></td>
                <td height="100px">${public_image.creation_date}</td>
                <td height="100px">${public_image.download_count}</td>
                <td height="100px"><a onclick="flash()" download="图片" href="${public_image.path}">Here</a></td>
                <td height="100px"><a class="layui-btn layui-btn-danger layui-btn-fluid"
                                      href="/image?method=del&del=${public_image.id}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2" align="center">
                <button class="layui-btn layui-btn-primary layui-btn-xs">
                    <a href="javascript:allCheck('choice',true)">全选</a>
                </button>
                <button class="layui-btn layui-btn-primary layui-btn-xs">
                    <a href="javascript:allCheck('choice',false)">全不选</a>
                </button>
                <button class="layui-btn layui-btn-primary layui-btn-xs">
                    <a href="javascript:reserveCheck('choice')">反选</a>
                </button>
                <button class="layui-btn layui-btn-danger layui-btn-xs" type="submit">
                    <span style="color: #f0f8ff; ">删除选定</span>
                </button>
            </td>
        </form>

        <td colspan="5" align="center">
                <span class="layui-btn-disabled layui-btn-xs">每页<span id="dataPrePage">${dataPrePage}</span>条数据</span>
                <button id="first" class="layui-btn layui-btn-primary layui-btn-xs ">首页</button>
                <button id="last" class="layui-btn layui-btn-primary layui-btn-xs">尾页</button>
                <button class="layui-btn-disabled layui-btn-xs"><span id="currentPage">${currentPage }</span>/<span
                        id="pages">${pages }</span></button>
                <button id="previous" class="layui-btn layui-btn-primary layui-btn-xs">上一页</button>
                <button id="next" class="layui-btn layui-btn-primary layui-btn-xs">下一页</button>
                <button class="layui-btn layui-btn-normal layui-btn-xs" href="#" onclick="do_flash()">刷新下载数</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script>
    //取出传回来的参数error并与yes比较
    var errori = '<%=request.getParameter("error")%>';
    if (errori == 'yes') {
        alert("操作有误!");
    } else if (errori == 'no') {
        alert("操作成功");
    }
</script>
</body>
</html>