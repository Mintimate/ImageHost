<%@ page import="java.sql.Connection" %>
<%@ page import="cn.mintimate.util.JDBCTools" %>
<%@ page import="cn.mintimate.entity.Image_Type" %>
<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanListHandler" %><%--
  Created by IntelliJ IDEA.
  User: mintimate
  Date: 2020/5/3
  Time: 4:43 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mintimate上传(DebugOnly)</title>
    <link rel="stylesheet" href="/resources/layui/css/layui.css"  media="all">
</head>
<body>
<form action="/upload" enctype="multipart/form-data" method="post">
    <table class="layui-table">
        <colgroup>
            <col width="30%">
            <col width="30%">
            <col>
        </colgroup>
        <tbody>
        <tr>
            <td>图片类型</td>
            <td>选择图片</td>
            <td>上传用户</td>
        </tr>
        <tr>
            <td><select name="category"  class="layui-btn layui-btn-radius layui-btn-primary layui-btn-fluid">
                <%
                    QueryRunner queryRunner=new QueryRunner();
                    Connection connection = JDBCTools.getConnection();
                    String sql = "select * from Image_Type";
                    List <Image_Type> select=null;
                    try{
                        select=queryRunner.query(connection,sql,new BeanListHandler<>(Image_Type.class));
                        for (Image_Type image_type: select ) {
                            String category=image_type.getImage_type();
                %>
                <option value="<%=category%>"><%=category%></option>
                <%
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                %>
            </select></td>
            <td><input  name="img" type="file" accept="image/png,image/gif,image/jpg"></td>
            <td><button class="layui-btn layui-btn-disabled layui-btn-fluid" type="reset">Admin(DebugOnly)</button></td>
        </tr>
        <tr>
            <td colspan="3"><button type="submit" class="layui-btn layui-btn-danger layui-btn-radius layui-btn-fluid">上传</button></td>
        </tr>
        <tr>
            <td colspan="3"><a href="index.jsp" class="layui-btn  layui-btn-normal layui-btn-radius layui-btn-fluid">返回主页</a></td>
        </tr>
        </tbody>
    </table>
</form>
<script>
    //取出传回来的参数error并与yes比较
    var errori = '<%=request.getParameter("error")%>';
    if (errori == 'yes') {
        alert("上传失败，请联系管理员!");
    }
    else if(errori =="no"){
        alert("操作成功，图片已经上传！")
    }
</script>
</body>
</html>
