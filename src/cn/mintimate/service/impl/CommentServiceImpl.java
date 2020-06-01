package cn.mintimate.service.impl;

import cn.mintimate.service.CommentService;
import cn.mintimate.entity.User_Comment;
import cn.mintimate.repository.CommentRepository;
import cn.mintimate.repository.impl.CommentRepositoryImpl;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository=new CommentRepositoryImpl();
    @Override
    public List<User_Comment> Get_Comment() {
        return commentRepository.Get_Comment();
    }

    @Override
    public int Add_Comment(String user_name, String details, String date) {
        return commentRepository.Add_Comment(user_name, details, date);
    }

    @Override
    public int Del_Comment(int id) {
        return commentRepository.Del_Comment(id);
    }
}
