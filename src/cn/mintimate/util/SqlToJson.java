package cn.mintimate.util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.stringtree.json.JSONValidatingWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Sql转Json
 * Power By Mintimate
 */

public class SqlToJson {
    private String chart_name="IP_Count";//获取那张表的数据
    private int a,b;

    public void setChart_name(String chart_name) {
        this.chart_name = chart_name;
    }

    public String getJson(int page, int limit){
        //获取数据库表有几行：
        int count=chart_count(chart_name);
        location(page,limit);//给a，b定位
        JSONValidatingWriter jsonValidatingWriter=new JSONValidatingWriter();//json类
        Connection connection = JDBCTools.getConnection();
        String sql="select * from "+chart_name+" limit ?,?";
        String Json=null;
        try {
            MapListHandler mapListHandler=new MapListHandler();
            Json=jsonValidatingWriter.write(new QueryRunner().query(connection, sql, new MapListHandler(),a,b-a));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection, null, null);
        }
        return "{\"code\":0,\"count\":"+count+",\"data\":"+Json+"}";

    }


    public String getJson(){
        int count=chart_count(chart_name);
        JSONValidatingWriter jsonValidatingWriter=new JSONValidatingWriter();//json类
        Connection connection = JDBCTools.getConnection();
        String sql="select * from "+chart_name;
        String Json=null;
        try {
            MapListHandler mapListHandler=new MapListHandler();
            Json=jsonValidatingWriter.write(new QueryRunner().query(connection, sql, new MapListHandler()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection, null, null);
        }
        return "{\"code\":0,\"count\":"+count+",\"data\":"+Json+"}";
    }

    private static int chart_count(String chart){
        //获取那张表的总数
        int count=0;
        String sql_count="select count(*) from IP_Count";
        Connection con = JDBCTools.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = con.prepareStatement(sql_count);
            resultSet = ps.executeQuery();
            resultSet.next();
            count=resultSet.getInt(1);//得到有几条数据在表
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(con, ps, resultSet);
        }
        return count;
    }
    private void location(int page, int limit){
        int count=chart_count(chart_name);
        a=(page-1)*limit;
        if(page<=count/page)
            b=page*limit;
        else
            b=page*limit+(count%page) ;
    }
}
