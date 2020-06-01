package cn.mintimate.service.impl;

import cn.mintimate.service.DownloadService;
import cn.mintimate.repository.Public_ImageRepository;
import cn.mintimate.repository.impl.Public_ImageRepositoryImpl;

public class DownlaodServiceImpl implements DownloadService {
    private Public_ImageRepository public_imageRepository=new Public_ImageRepositoryImpl();
    @Override
    public void Download(int id) {
        public_imageRepository.Downlaod(id);
    }
}
