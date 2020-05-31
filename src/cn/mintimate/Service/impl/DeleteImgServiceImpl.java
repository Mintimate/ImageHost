package cn.mintimate.Service.impl;

import cn.mintimate.Service.DeleteImgService;
import cn.mintimate.repository.Public_ImageRepository;
import cn.mintimate.repository.impl.Public_ImageRepositoryImpl;

public class DeleteImgServiceImpl implements DeleteImgService {
    private Public_ImageRepository public_imageRepository=new Public_ImageRepositoryImpl();
    @Override
    public int del(int id) {
        return public_imageRepository.Del(id);
    }

    @Override
    public int del(String[] id) {
        return public_imageRepository.Del(id);
    }
}
