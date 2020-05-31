package cn.mintimate.repository;


import cn.mintimate.entity.User_Guest;

public interface User_GuestRepository {
    /**
     * 游客用户登陆接口方法
     * 游客用户注册接口方法
     * @param username
     * @param password
     * @return
     */
    public User_Guest login(String username, String password);
    public int register(String useremail,String username,String password);
}
