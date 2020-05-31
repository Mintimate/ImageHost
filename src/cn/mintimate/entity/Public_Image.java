package cn.mintimate.entity;

import java.util.Date;

public class Public_Image {
    private int id;
    private String image_name;
    private String Creation_date;
    private String download_count;
    private String path;
    private String user_name;
    private String image_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getCreation_date() {
        return Creation_date;
    }

    public void setCreation_date(String creation_date) {
        Creation_date = creation_date;
    }

    public String getDownload_count() {
        return download_count;
    }

    public void setDownload_count(String download_count) {
        this.download_count = download_count;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getImage_type() {
        return image_type;
    }

    public void setImage_type(String image_type) {
        this.image_type = image_type;
    }

    public Public_Image(int id, String image_name, String creation_date, String download_count, String path, String user_name, String image_type) {
        this.id = id;
        this.image_name = image_name;
        Creation_date = creation_date;
        this.download_count = download_count;
        this.path = path;
        this.user_name = user_name;
        this.image_type = image_type;
    }

    public Public_Image() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\"=" + id +
                ",\"image_name\":" + "\""+image_name +"\"" +
                ",\"Creation_date\":" + "\""+Creation_date+"\"" +
                ",\"download_count\":" + "\""+download_count +"\"" +
                ",\"path\":" + "\""+path +"\"" +
                ",\"user_name\":" + "\""+user_name+"\"" +
                '}';
    }


}
