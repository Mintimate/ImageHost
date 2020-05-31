package cn.mintimate.Service;

import cn.mintimate.entity.Public_Image;

import java.util.List;

public interface FindImgService {
    public int getPages();
    public int getPages(String image_type);
    public List<Public_Image> FindImgService(int page);
    public List<Public_Image> FindImgService(int page,String image_type);
    public String ViewImg(int id);
}
