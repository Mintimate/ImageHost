package cn.mintimate.Service.impl;

import cn.mintimate.Service.UploadService;
import cn.mintimate.repository.Public_ImageRepository;
import cn.mintimate.repository.impl.Public_ImageRepositoryImpl;


public class UploadServiceImpl implements UploadService{
    private Public_ImageRepository uploadImageRepository=new Public_ImageRepositoryImpl();
    @Override
    public int upload(String image_name, String Creation_date, String path, String user_name , String image_type) {
        return uploadImageRepository.Add_Image(image_name,Creation_date,path,user_name,image_type);
    }
}
