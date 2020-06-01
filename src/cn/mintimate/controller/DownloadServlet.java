package cn.mintimate.controller;

import cn.mintimate.service.DownloadService;
import cn.mintimate.service.impl.DownlaodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 下载逻辑处理
 * 根据页面传入图片ID，对图片进行下载操作
 * (未来会整合到ImageServlet内）
 */

@WebServlet("/DownloadImage")
public class DownloadServlet extends HttpServlet {
    private DownloadService downloadService=new DownlaodServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        downloadService.Download(id);
        resp.setContentType("application/x-msdownload");
        String filename=req.getParameter("filename");
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        OutputStream outputStream=resp.getOutputStream();
        String path=req.getServletContext().getRealPath("UploadImages/"+filename);
        InputStream inputStream=new FileInputStream(path);
        int temp=0;
        while ((temp=inputStream.read())!=-1){
            outputStream.write(temp);
        }
        inputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
