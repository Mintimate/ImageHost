package cn.mintimate.controller;

import cn.mintimate.Service.RegisterService;
import cn.mintimate.Service.impl.RegisterServiveImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    private RegisterService registerService = new RegisterServiveImpl();

    /**
     * 注册逻辑处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = 0;
        PrintWriter out = resp.getWriter();
        String regname = req.getParameter("regname");
        String regemail = req.getParameter("regemail");
        String reregpass = req.getParameter("reregpass");
        //判断三者是否有空
        if(regname.isEmpty()||regemail.isEmpty()||reregpass.isEmpty()) {
            resp.sendRedirect("/login.jsp?error=SomethingIsNull");
            return;
        }

        //判断邮箱是否合法
        if(!regemail.contains("@")) {
            resp.sendRedirect("/login.jsp?error=email");
            return;
        }
        i = registerService.register(regname, regemail, reregpass);
        switch (i) {
            case 1:
                resp.sendRedirect("/login.jsp?error=no");
                break;
            case 2:
                resp.sendRedirect("/login.jsp?error=EmailHadBeenUsed");
                break;
            case 0:
                resp.sendRedirect("/login.jsp?error=HMG");
                break;
        }
        return;

    }
}
