package cn.mintimate.Service.impl;

import cn.mintimate.Service.RegisterService;
import cn.mintimate.repository.User_GuestRepository;
import cn.mintimate.repository.impl.User_GuestRepositoryImpl;

public class RegisterServiveImpl implements RegisterService {
    private User_GuestRepository user_guestRepository=new User_GuestRepositoryImpl();
    @Override
    public int register(String user_name, String user_email, String user_passwd) {
        return user_guestRepository.register(user_email,user_name,user_passwd);
    }
}
