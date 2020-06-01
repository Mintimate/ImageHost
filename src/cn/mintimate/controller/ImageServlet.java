package cn.mintimate.controller;

import cn.mintimate.service.DeleteImgService;
import cn.mintimate.service.FindImgService;
import cn.mintimate.service.impl.DeleteImgServiceImpl;
import cn.mintimate.service.impl.FindImgServiceImpl;
import cn.mintimate.entity.Public_Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * 图片操作页面
 * -查找图片（未制定类别，默认查找全部图片）
 * -删除图片（post为多选，get为删除某一张）
 * -展示图片（图床并增加下载次数）
 * 上传和下载，以为需要method支持，在UploadServlet和DownloadServlet
 *
 */
@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    private FindImgService findImgService = new FindImgServiceImpl();
    private DeleteImgService deleteImgService=new DeleteImgServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "find";
        }
        String pageStr = req.getParameter("page");
        if (pageStr == null)
            pageStr = "1";
        Integer page = Integer.parseInt(pageStr);
        req.setAttribute("dataPrePage", 6);
        req.setAttribute("currentPage", page);
        switch (method) {
            case "find":
                //判断是否为类别选择
                String image_type = req.getParameter("type");
                if (image_type == null || image_type.equals("null")) {
                    List<Public_Image> list = findImgService.FindImgService(page);
                    req.setAttribute("list", list);
                    req.setAttribute("pages", findImgService.getPages());
                    //判断跳转那个页面
                    String control = req.getParameter("control");
                    if (control == null)
                        req.getRequestDispatcher("/ShowImage/ALLPlus.jsp").forward(req, resp);
                    else
                        req.getRequestDispatcher("/Function/ImageControl.jsp").forward(req, resp);
                } else {
                    List<Public_Image> list = findImgService.FindImgService(page, image_type);
                    req.setAttribute("list", list);
                    int pages = findImgService.getPages(image_type);
                    req.setAttribute("pages", pages);
                    switch (image_type) {
                        case "动漫":
                            req.getRequestDispatcher("/ShowImage/Cartoon.jsp").forward(req, resp);
                        case "壁纸":
                            req.getRequestDispatcher("/ShowImage/Wallpaper.jsp").forward(req, resp);
                        case "其他":
                            req.getRequestDispatcher("/ShowImage/Others.jsp").forward(req, resp);
                    }
                }
                break;
            case "del":
                int del= Integer.parseInt(req.getParameter("del"));
                int result=deleteImgService.del(del);
                List<Public_Image> list = findImgService.FindImgService(page);
                req.setAttribute("list", list);
                req.setAttribute("pages", findImgService.getPages());
                if(result==0)
                    req.getRequestDispatcher("/Function/ImageControl.jsp?error=yes").forward(req, resp);
                else
                    req.getRequestDispatcher("/Function/ImageControl.jsp?error=no").forward(req, resp);
                break;
            case "view":
                //图床浏览，根据图片ID，获取图片地址，并下载&访问+1
                int id=Integer.parseInt(req.getParameter("id"));
                String path=findImgService.ViewImg(id);
                System.out.println(path);
                req.getRequestDispatcher(path).forward(req,resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //图片类别，出了特使的上传和下载另外分开为Servlet，post只有"多选删除"操作；不另外swath判断
        //获取模式。并执行方法
        String []del= req.getParameterValues("choice");
        if(del==null){
            doGet(req,resp);
        }
        int result =deleteImgService.del(del);

        //获取一次图片数据
        String pageStr = req.getParameter("page");
        if (pageStr == null)
            pageStr = "1";
        Integer page = Integer.parseInt(pageStr);
        req.setAttribute("dataPrePage", 6);
        req.setAttribute("currentPage", page);
        List<Public_Image> list = findImgService.FindImgService(page);
        req.setAttribute("list", list);
        req.setAttribute("pages", findImgService.getPages());

        //判断删除结果
        if(result==0)
            req.getRequestDispatcher("/Function/ImageControl.jsp?error=yes").forward(req, resp);
        else
            req.getRequestDispatcher("/Function/ImageControl.jsp?error=no").forward(req, resp);
    }
}
