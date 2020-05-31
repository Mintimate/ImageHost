package cn.mintimate.repository;

import cn.mintimate.entity.User_Admin;

public interface User_AdminRepository {
    /**
     * 管理员用户登陆接口方法
     * @param username
     * @param password
     * @return
     */
    public User_Admin login(String username, String password);
}
