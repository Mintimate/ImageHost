package cn.mintimate.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCTools {
    private static DataSource dataSource;
    static {
        dataSource=new ComboPooledDataSource("MyDB");
    }
    public static Connection getConnection(){
        Connection connection=null;
        try {
            if (connection == null || connection.isClosed())
                connection=dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if (connection != null) {
                connection.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
