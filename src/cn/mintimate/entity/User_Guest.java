package cn.mintimate.entity;

public class User_Guest {
    private String id;
    private String user_name;
    private String user_email;
    private String user_passwd;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_passwd() {
        return user_passwd;
    }

    public void setUser_passwd(String user_passwd) {
        this.user_passwd = user_passwd;
    }

    public User_Guest(String id, String user_name, String user_email, String user_passwd) {
        this.id = id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_passwd = user_passwd;
    }
    public User_Guest(){

    }
}
