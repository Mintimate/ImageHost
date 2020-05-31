package cn.mintimate.repository.impl;

import cn.mintimate.repository.IP_CountRepository;
import cn.mintimate.util.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IP_CountRepositoryImpl implements IP_CountRepository {
    @Override
    public int Add_IP(String IP, String date) {
        Connection connection = JDBCTools.getConnection();
        PreparedStatement stmt = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into IP_Count(IP,date)values(?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, IP);
            stmt.setString(2, date);
            System.out.println(IP);
            System.out.println(date);
            int count = stmt.executeUpdate();//影响的行数
            if (count > 0)//成功
                return 1;
            else
                return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection,stmt,null);
        }
        return 0;
    }
}
