package cn.mintimate.controller;

import cn.mintimate.Service.UploadService;
import cn.mintimate.Service.impl.UploadServiceImpl;
import cn.mintimate.entity.Image_Type;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    private UploadService uploadService = new UploadServiceImpl();

    /**
     * 处理文件上传
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String image_type=null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date day = new Date();
        //创建FileItemFactory工厂实现类
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        if (ServletFileUpload.isMultipartContent(req)) {
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        String name = fileItem.getFieldName();
                        image_type= fileItem.getString("UTF-8");
                        //普通表单项
                        System.out.println(fileItem.getFieldName());
                    } else {
                        //上传文件
                        String path = req.getSession().getServletContext().getRealPath("UploadImages");
                        fileItem.write(new File(path, fileItem.getName()));
                        uploadService.upload(fileItem.getName(), dateFormat.format(day), "/UploadImages"+"/"+fileItem.getName(), "Admin",image_type);
                        resp.sendRedirect("/Function/Admin_Upload.jsp?error=no");
                    }
                }
            } catch (Exception e) {
                resp.sendRedirect("/Function/Admin_Upload.jsp?error=yes");
            }
        }
    }
}
