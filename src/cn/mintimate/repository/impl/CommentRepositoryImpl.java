package cn.mintimate.repository.impl;

import cn.mintimate.entity.User_Comment;
import cn.mintimate.repository.CommentRepository;
import cn.mintimate.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {
    private QueryRunner queryRunner=new QueryRunner();
    private Connection connection = JDBCTools.getConnection();
    private List<User_Comment> comment=null;
    @Override
    public List<User_Comment> Get_Comment() {
        String sql = "select * from User_Comment";
//        List <Public_Image> public_images=null;
        try {
            comment =queryRunner.query(connection,sql,new BeanListHandler<>(User_Comment.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection, null, null);
        }
        return comment;
    }

    @Override
    public int Add_Comment(String user_name, String details, String date) {
        Connection connection = JDBCTools.getConnection();
        PreparedStatement stmt = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into User_Comment(user_name,details,date)values(?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, user_name);
            stmt.setString(2, details);
            stmt.setString(3, date);
            int count = stmt.executeUpdate();//影响的行数
            if(count>0){
                //添加成功
                return 1;
            }
            else {
                //添加失败
                return 0;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,stmt,null);
        }
        return 0;//失败
    }

    @Override
    public int Del_Comment(int id) {
        Connection connection = JDBCTools.getConnection();
        PreparedStatement stmt = null;
        String sql="delete from User_Comment where id=?";
        connection = JDBCTools.getConnection();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int count = stmt.executeUpdate();//影响的行数
            if(count>0){
                //添加成功
                return 1;
            }
            else {
                //添加失败
                return 0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,stmt,null);
        }
        return 0;//失败
    }
}
