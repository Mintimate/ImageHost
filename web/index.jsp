<%--
  Created by IntelliJ IDEA.
  User: mintimate
  Date: 2020/4/16
  Time: 2:43 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="static cn.mintimate.util.GetIP.getIpAddr" %>
<!doctype html>
<html lang="zh" class="no-js">
<head>
    <meta charset="UTF-8">
<%--    按钮等图标--%>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
<%--    站点图标--%>
    <link rel="apple-touch-icon" sizes="180x180" href="/resources/images/web-icon-next.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/resources/images/web-icon-next.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/resources/images/web-icon-next.png">
    <link rel="mask-icon" href="/images/logo.svg" color="#222">
<%--    CSS--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="resources/layui/css/layui.css">
    <link rel="stylesheet" href="resources/css/index_css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="resources/css/index_css/style.css"> <!-- Resource style -->
    <script src="resources/js/index_js/modernizr.js"></script> <!-- Modernizr -->

    <title>无名菜鸟的站点</title>
</head>
<body>
<%

%>
<section class="cd-intro">
    <div class="cd-intro-content mask-2">
        <div class="content-wrapper">
            <div>
                <h1>项目加载成功</h1>
                <h1>近期更新:</h1>
                <p>增加图床功能，并记录图片访问次数</p>
                <p>修复分页逻辑错误</p>
                <p>增加"下载量刷新"</p>
                <div class="action-wrapper">
                    <a href="/login.jsp" class="cd-btn main-action">登录/注册</a>
                    <a href="mailto:mintimate215@gmail.com" class="cd-btn">Mail To Me</a>
                </div>
                <p><span style="color: #f0ffff; ">项目总进度</span></p>
                <div class="layui-progress layui-progress-big" lay-showpercent="true">
                    <div class="layui-progress-bar layui-bg-red" lay-percent="99%"></div>
                </div>
                <p>您的IP：<%=getIpAddr(request)%></p>
            </div>
        </div>
    </div>
</section>
<script src="resources/js/autoload.js"></script>
<script src="/resources/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use('element', function() {
        var $ = layui.jquery;
        var element = layui.element;
    })
</script>
</body>
</html>