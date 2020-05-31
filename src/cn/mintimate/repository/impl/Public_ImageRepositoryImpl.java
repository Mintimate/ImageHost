package cn.mintimate.repository.impl;

import cn.mintimate.entity.Public_Image;
import cn.mintimate.repository.Public_ImageRepository;
import cn.mintimate.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 针对Public_Image表的数据库操作
 *
 */
public class Public_ImageRepositoryImpl implements Public_ImageRepository {
    private QueryRunner queryRunner=new QueryRunner();
    private Connection connection = JDBCTools.getConnection();
    private  List <Public_Image> public_images=null;

    @Override
    public int Add_Image(String image_name, String Creation_date, String path, String user_name, String image_type) {
        //添加图片操作
        Connection connection = JDBCTools.getConnection();
        PreparedStatement stmt = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into Public_Image(image_name,Creation_date,path,user_name,image_type)values(?,?,?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, image_name);
            stmt.setString(2, Creation_date);
            stmt.setString(3, path);
            stmt.setString(4, user_name);
            stmt.setString(5, image_type);
            int count = stmt.executeUpdate();//影响的行数
            if (count > 0) {
                //添加成功
                return 1;
            } else {
                //添加失败
                return 0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, stmt, null);
        }

        return 0;//失败
    }

    @Override
    public List<Public_Image> FindImg(int index,int limit) {
        //查找图片（分页查找）
        Connection connection=JDBCTools.getConnection();
        List <Public_Image> list =new ArrayList<>();
        String sql="select * from Public_Image limit ?,?";
        try {
            list=queryRunner.query(connection,sql,new BeanListHandler<>(Public_Image.class),index,limit);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,null,null);
        }
        return list;
    }

    @Override
    public List<Public_Image> FindImg(int index, int limit, String image_type) {
        //查找图片（分页、分类别查找）
        List <Public_Image> list =new ArrayList<>();
        Connection con=JDBCTools.getConnection();
        String sql="select * from Public_Image where image_type=? limit ?,?";
        try {
            list=queryRunner.query(con,sql,new BeanListHandler<>(Public_Image.class),image_type,index,limit);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(con,null,null);
        }
        return list;    }


    @Override
    public void Downlaod(int id) {
        //对图片的下载量++操作
        String sql = "UPDATE Public_Image SET download_count=download_count+1 WHERE id=?";
        try {
            queryRunner.update(connection, sql, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
        }
    }

    @Override
    public int Del(int id) {
        //删除图片的操作
        Connection con=JDBCTools.getConnection();
        int count=0;
        String sql = "delete from Public_Image where id = ?";
        try {
            if(queryRunner.update(con,sql,id)>0)
                count=1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTools.release(con, null, null);
        }
        return count;
    }

    @Override
    public int Del(String[] id) {
        //批量删除图片操作
        Connection con=JDBCTools.getConnection();
        int count=0;
        String sql = "delete from Public_Image where id = ?";
        try {
            for (String del:id) {
                if(queryRunner.update(con,sql,del)>0)
                    count++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTools.release(con, null, null);
        }
        if(count==id.length)
            return 1;
        else
            return 0;
    }

    @Override
    public int count() {
        //计算所有图片数量
        Connection con_count=JDBCTools.getConnection();
        String sql = "select count(*) from Public_Image";
        int count=0;
        try {
            Object o=queryRunner.query(con_count,sql,new ScalarHandler());
            String temp=o.toString();
            count=Integer.parseInt(temp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTools.release(con_count,null,null);
        }
        return count;
    }

    @Override
    public int count(String image_type) {
        //计算某类图片的数量
        Connection con_count=JDBCTools.getConnection();
        String sql = "select count(*) from Public_Image where image_type=?";
        int count=0;
        try {
            Object o=queryRunner.query(con_count,sql,new ScalarHandler(),image_type);
            String temp=o.toString();
            count=Integer.parseInt(temp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCTools.release(con_count,null,null);
        }
        return count;    }

    @Override
    public String ViewImg(int id) {
        //展示图片（图床）
        Connection con=JDBCTools.getConnection();
        String sql="select path from Public_Image where id=?";
        Public_Image path=null;
        try{
            path=queryRunner.query(con,sql,new BeanHandler<>(Public_Image.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return path.getPath();
    }
}
