package cn.mintimate.service;

import cn.mintimate.entity.User_Comment;

import java.util.List;

public interface CommentService {
    public List<User_Comment> Get_Comment();
    public int Add_Comment(String user_name,String details,String date);
    public int Del_Comment(int id);
}
