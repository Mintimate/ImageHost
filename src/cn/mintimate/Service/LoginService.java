package cn.mintimate.Service;

public interface LoginService {
    /**
     * 登陆服务接口
     * @param user_email
     * @param user_passwd
     * @param type
     * @return
     */
    public Object login(String user_email,String user_passwd,String type);
}
