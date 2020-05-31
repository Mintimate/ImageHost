package cn.mintimate.entity;

public class IP_Count {
    private int id;
    private String IP;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public IP_Count(int id, String IP, String date) {
        this.id = id;
        this.IP = IP;
        this.date = date;
    }
    public IP_Count(){

    }
}
