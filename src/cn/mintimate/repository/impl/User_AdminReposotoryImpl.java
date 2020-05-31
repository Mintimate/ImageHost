package cn.mintimate.repository.impl;

import cn.mintimate.entity.User_Admin;
import cn.mintimate.repository.User_AdminRepository;
import cn.mintimate.util.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_AdminReposotoryImpl implements User_AdminRepository {
    @Override
    public User_Admin login(String username, String password) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from User_Admin where user_email = ? and user_passwd = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User_Admin admin = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                admin = new User_Admin(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return admin;
    }
}
