package cn.mintimate.controller;

import cn.mintimate.Service.LoginService;
import cn.mintimate.Service.impl.LoginServiceImpl;
import cn.mintimate.entity.User_Admin;
import cn.mintimate.entity.User_Guest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    /**
     * 处理登陆的业务逻辑层
     * 原计划是做游客和管理员的下载站的……后面改成图床
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.setCharacterEncoding("UTF-8");
        String user_email=req.getParameter("user_email");
        String user_passwd=req.getParameter("user_passwd");
        String type=req.getParameter("type");
        Object object = loginService.login(user_email,user_passwd,type);
        if(object != null){
            HttpSession session = req.getSession();
            switch (type){
                case "guest":
                    User_Guest guest = (User_Guest) object;
                    System.out.printf(guest.toString());
                    session.setAttribute("guest",guest.getUser_name());
                    session.setAttribute("email",guest.getUser_email());
                    resp.sendRedirect("/Guest_Control.jsp");
                    break;
                case "admin":
                    User_Admin admin = (User_Admin) object;
                    session.setAttribute("admin",admin);
                    //跳转到管理员的首页
                    session.setAttribute("guest",admin.getUser_name());
                    session.setAttribute("email",admin.getUser_email());
                    resp.sendRedirect("/Admin_Control.jsp");
                    break;
            }
        }
        else{
            resp.sendRedirect("/login.jsp?error=yes");
        }
    }
}
