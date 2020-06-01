package cn.mintimate.service.impl;

import cn.mintimate.service.LoginService;
import cn.mintimate.repository.User_GuestRepository;
import cn.mintimate.repository.User_AdminRepository;
import cn.mintimate.repository.impl.User_AdminReposotoryImpl;
import cn.mintimate.repository.impl.User_GuestRepositoryImpl;

public class LoginServiceImpl implements LoginService {
    /**
     * 登陆接口实例
     */
    private User_GuestRepository guestRepository =new User_GuestRepositoryImpl();
    private User_AdminRepository adminRepository = new User_AdminReposotoryImpl();
    @Override
    public Object login(String user_email, String user_passwd, String type) {
        Object object = null;
        switch (type){
            case "guest":
                object = guestRepository.login(user_email,user_passwd);
                break;
            case "admin":
                object = adminRepository.login(user_email, user_passwd);
                break;
        }
        return object;
    }

}
