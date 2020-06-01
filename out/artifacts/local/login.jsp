<%--
  Created by IntelliJ IDEA.
  User: mintimate
  Date: 2020/4/13
  Time: 8:49 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Login组件</title>
<%--    站点图标--%>
    <link rel="apple-touch-icon" sizes="180x180" href="/resources/images/web-icon-next.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/resources/images/web-icon-next.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/resources/images/web-icon-next.png">
    <link rel="mask-icon" href="/images/logo.svg" color="#222">
<%--    css--%>
    <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/style.css">

</head>
<body>
<div class="materialContainer">
    <div>
        <form action="/login" method="post">
            <div class="box">
                <div class="title">登录</div>
                <div class="input">
                    <label for="name">邮箱</label>
                    <input type="text" name="user_email" id="name">
                    <span class="spin"></span>
                </div>
                <div class="input">
                    <label for="pass">密码</label>
                    <input type="password" name="user_passwd" id="pass">
                    <span class="spin"></span>
                </div>
                <table width="100%" style="padding-top: 15px;margin-left: 0">
                    <tr>
                        <td width="25%">用户角色:</td>
                        <td width="30%" ><input type="radio" value="guest" name="type" checked="true"/>
                            <i style="font-size: small" class="fas fa-user">普通用户&nbsp;</i>
                        </td>
                        <td width="30%"><input type="radio" value="admin" name="type"/>
                            <i style="font-size: small" class="fas fa-user-cog">管理员</i>
                        </td>
                        <td>
                            <button type="reset" class="fas fa-trash-alt" style="border-style: none; color: #ED2553;background: none;">
                                清空
                            </button>
                        </td>
                    </tr>
                </table>
                <div class="button login">
                    <button type="submit" value="登陆">
                        <span>登录</span>
                        <i class="fa fa-check"></i>
                    </button>
                </div>
            </div>
        </form>
    </div>
    <form action="/Register" method="post">
        <div class="overbox">
            <div class="material-button alt-2">
                <span class="shape"></span>
            </div>
            <div class="title">注册</div>
            <div class="input">
                <label for="regname">用户名</label>
                <input type="text" name="regname" id="regname">
                <span class="spin"></span>
            </div>
            <div class="input">
                <label for="regpass">邮箱</label>
                <input type="text" name="regemail" id="regpass">
                <span class="spin"></span>
            </div>
            <div class="input">
                <label for="reregpass">密码</label>
                <input type="password" name="reregpass" id="reregpass">
                <span class="spin"></span>
            </div>
            <div class="button">
                <button type="submit" value="注册">
                    <span>注册</span>
                </button>
            </div>
        </div>
    </form>
</div>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/index.js"></script>
<script>
    //取出传回来的参数error并与yes比较
    var errori = '<%=request.getParameter("error")%>';
    if (errori == 'yes') {
        alert("登陆失败！请检查用户名或密码");
    }
    if (errori=="SomethingIsNull"){
        alert("注册失败！用户名和密码需要非空")
    }
    if(errori =='email'){
        alert("注册失败！请检查邮箱是否合法");
    }
    if(errori =='EmailHadBeenUsed'){
        alert("注册失败！用户已存在");
    }
    if(errori =='no'){
        alert("恭喜你，注册成功！请登陆吧(´▽｀)")
    }
    if(errori =='OMG'){
        alert("OMG!还有这种操作？请联系管理员")
    }
</script>
</body>
</html>
