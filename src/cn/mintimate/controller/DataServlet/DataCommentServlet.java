package cn.mintimate.controller.DataServlet;

import cn.mintimate.util.SqlToJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/json/Comment")
public class DataCommentServlet extends HttpServlet {
    private SqlToJson sqlToJson = new SqlToJson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        sqlToJson.setChart_name("Comment");
        PrintWriter out = resp.getWriter();
        if (page == null || limit == null) {
            //如果没有传page或者limit，则返回全部数据
            out.println(sqlToJson.getJson());
        } else
            //调用SqlToJson以伪Json返回
            out.println(sqlToJson.getJson(Integer.parseInt(page), Integer.parseInt(limit)));
    }
}
