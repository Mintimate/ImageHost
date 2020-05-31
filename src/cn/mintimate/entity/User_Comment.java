package cn.mintimate.entity;

public class User_Comment {
    private int id;
    private String user_name;
    private String details;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User_Comment() {
    }

    public User_Comment(int id, String user_name, String details, String date) {
        this.id = id;
        this.user_name = user_name;
        this.details = details;
        this.date = date;
    }
}
