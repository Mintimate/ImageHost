<%@ page import="cn.mintimate.entity.Public_Image" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mintimate
  Date: 2020/5/4
  Time: 7:39 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    站点图标--%>
    <link rel="apple-touch-icon" sizes="180x180" href="/resources/images/web-icon-next.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/resources/images/web-icon-next.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/resources/images/web-icon-next.png">
    <link rel="mask-icon" href="/images/logo.svg" color="#222">
    <%--    CSS--%>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/HideWebkit.css">
    <title>Mintimate图片管理</title>
    <script type="text/javascript" src="/resources/js/MyTool.js"></script>
</head>
<body>
<style type="text/css">
    #waifu {
        z-index: 1000 !important;
    }
</style>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><span style="font-size: large;background: linear-gradient(to right, #e66465, #9198e5);
        -webkit-background-clip: text;
        color: transparent;">Mintimate图床下载站</span></div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="https://v1.alapi.cn/api/avatar?email=${sessionScope.email}" class="layui-nav-img">
                    ${sessionScope.guest}
                </a>
            </li>

            <li class="layui-nav-item"><a href="/logout">登出</a></li>
            <li class="layui-nav-item"><a target="Main" href="/Function/Support.html">创造支持</a></li>
        </ul>
    </div>

    <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">
                        图片浏览
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/image?method=find" target="Main">全部</a></dd>
                        <dd><a href="/image?method=find&type=动漫" target="Main">动漫</a></dd>
                        <dd><a href="/image?method=find&type=壁纸" target="Main">壁纸</a></dd>
                        <dd><a href="/image?method=find&type=其他" target="Main">其他</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">
                        管理图片
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/Function/Admin_Upload.jsp" target="Main">上传图片</a></dd>
                        <dd><a href="/image?method=find&control=yes" target="Main">图片管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">
                        留言管理
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/Function/Comment.jsp" target="Main">所有留言</a></dd>
                        <dd><a href="/Function/CommentControl.jsp" target="Main">删除留言</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a onclick="egg()" href="javascript:var s=document.createElement('script');s.type='text/javascript';document.body.appendChild(s);s.src='https://www.mintimate.tk/asteroids.min.js';void(0);"><span
                            style="font-size: xx-small; ">小彩蛋</span></a>
                </li>
                <li class="layui-nav-item">
                    <a href="/Function/FindAllOfIP.jsp" target="Main">查看所有访客</a>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">友情链接</a>
                    <dl class="layui-nav-child">
                        <dd><a href="https://www.mintimate.cn" target="_blank">Mintimate博客</a></dd>
                        <dd><a href="https://github.com/Mintimate/ImgShare" target="_blank">Github开源地址</a></dd>
                        <dd><a href="https://space.bilibili.com/355567627" target="_blank">Mintimate's Bilibili</a></dd>
                        <dd><a href="https://72k.us/dir/26158157-38620952-62326d" target="_blank">城通网盘下载</a></dd>
                        <dd><a href="">此位招租</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body" style="height: 100%">
        <!-- 内容主体区域 -->
        <iframe name="Main" frameborder="1" scrolling="no" class="" height=95% width=100%
                src="/Function/Support.html"></iframe>
    </div>
</div>
<script src="/resources/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
