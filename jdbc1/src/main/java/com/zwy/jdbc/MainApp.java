package com.zwy.jdbc;



import java.sql.*;

/**
 * 数据库查询
 */
public class MainApp {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            //DriverManager.registerDriver(new Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            /**
             * 于数据库和系统时区差异会引起错误
             * 在jdbc连接的url后面加上serverTimezone=GMT即可解决问题
             */
            String url = "jdbc:mysql://192.168.0.150:3306/shop?serverTimezone=GMT";
            String user = "zhou";
            String password = "Nz123456!";
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();

            String sql = "select * from product";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                System.out.println("id:" + id + " name:" + name + " price:" + price);
            }


        } catch (Exception e) {
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
