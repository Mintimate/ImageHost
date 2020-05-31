package cn.mintimate.repository.impl;

import cn.mintimate.entity.User_Guest;
import cn.mintimate.repository.User_GuestRepository;
import cn.mintimate.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class User_GuestRepositoryImpl implements User_GuestRepository {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public User_Guest login(String username, String password) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from User_Guest where user_email = ? and user_passwd = ?";
        User_Guest guest = null;
        try {
            guest = queryRunner.query(connection, sql, new BeanHandler<>(User_Guest.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            JDBCTools.release(connection, statement, resultSet);
            JDBCTools.release(connection, null, null);

        }
        return guest;
    }

    @Override
    public int register(String user_email, String user_name, String user_passwd) {
        Connection connection = JDBCTools.getConnection();
        String sql0 = "select * from User_Guest where user_email=?";
        try {
            User_Guest temp = queryRunner.query(connection, sql0, new BeanHandler<>(User_Guest.class), user_email);
            if (temp != null) {
                return 2;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into User_Guest(user_email,user_passwd,user_name)values(?,?,?)";
            User_Guest user_Guest = queryRunner.insert(connection, sql, new BeanHandler<>(User_Guest.class), user_email, user_passwd, user_name);
            if (user_Guest != null) {
                //添加成功
                return 1;
            } else {
                //添加失败
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, null, null);
        }
        return 0;//失败
    }
}
