package cn.mintimate.service.impl;

import cn.mintimate.service.FindImgService;
import cn.mintimate.entity.Public_Image;
import cn.mintimate.repository.Public_ImageRepository;
import cn.mintimate.repository.impl.Public_ImageRepositoryImpl;

import java.util.List;

public class FindImgServiceImpl implements FindImgService {
    private Public_ImageRepository public_imageRepository =new Public_ImageRepositoryImpl();
    private  final int LIMIT=5;

    @Override
    public int getPages() {
        int count=public_imageRepository.count();
        int page = 0;
        if(count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT+1;
        }
        return page;
    }

    @Override
    public int getPages(String image_type) {
        int count=public_imageRepository.count(image_type);
        int page = 0;
        if(count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT+1;
        }
        return page;
    }

    @Override
    public List<Public_Image> FindImgService(int page) {
        int index = (page-1)*LIMIT;
        return public_imageRepository.FindImg(index,LIMIT);
    }

    @Override
    public List<Public_Image> FindImgService(int page, String image_type) {
        int index = (page-1)*LIMIT;
        return public_imageRepository.FindImg(index,LIMIT,image_type);
    }

    @Override
    public String ViewImg(int id) {
        public_imageRepository.Downlaod(id);
        return public_imageRepository.ViewImg(id);
    }
}
