package cn.mintimate.controller;

import cn.mintimate.Service.CommentService;
import cn.mintimate.Service.FindImgService;
import cn.mintimate.Service.impl.CommentServiceImpl;
import cn.mintimate.Service.impl.FindImgServiceImpl;
import cn.mintimate.entity.Public_Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/Data")
public class CommentServlet extends HttpServlet {
    CommentService commentService=new CommentServiceImpl();

    /**
     * 对Comment评论进行操作
     * 使用get进行删除操作，post进行添加操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int del= Integer.parseInt(req.getParameter("del"));
        if(commentService.Del_Comment(del)==0)
            resp.sendRedirect("/Function/CommentControl.jsp?error=yes");
        else
            resp.sendRedirect("/Function/CommentControl.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_name = req.getParameter("username");
        String detials = req.getParameter("details");
        if (user_name == null) {
            resp.sendRedirect("/Function/Comment.jsp?error=yes");
        }
        else{
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date day = new Date();
            commentService.Add_Comment(user_name,detials,dateFormat.format(day));
            resp.sendRedirect("/Function/Comment.jsp?error=no");
        }
    }
}
