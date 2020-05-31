package cn.mintimate.entity;

public class Image_Type {
    private int id;
    private String image_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_type() {
        return image_type;
    }

    public void setImage_type(String image_type) {
        this.image_type = image_type;
    }

    public Image_Type(int id, String image_type) {
        this.id = id;
        this.image_type = image_type;
    }
    public Image_Type(){

    }
}
