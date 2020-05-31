package cn.mintimate.repository;

import cn.mintimate.entity.Public_Image;

import java.util.List;

public interface Public_ImageRepository {
    public int Add_Image(String image_name, String Creation_date, String path, String user_name, String image_type);
    public List<Public_Image> FindImg(int paper,int limit);
    public List<Public_Image> FindImg(int paper,int limit,String image_type);
    public void Downlaod(int id);
    public int Del(int id);
    public int Del(String []id);
    public int count();
    public int count(String image_type);
    public String ViewImg(int id);
}
