package com.zwy.jdbc;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
/**
 * 数据库添加一条数据
 */
public class DatabaseAdd {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            DriverManager.registerDriver(new Driver());
            /**
             * 于数据库和系统时区差异会引起错误
             * 在jdbc连接的url后面加上serverTimezone=GMT即可解决问题
             */
            String url = "jdbc:mysql://192.168.0.150:3306/shop?serverTimezone=GMT";
            String user = "zhou";
            String password = "Nz123456!";
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            String sql = "insert into product values (null ,'一加手机',3600,1)";
            int i = st.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
