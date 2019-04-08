package com.zwy.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQuery {

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = JDBCUtils.getConn();
            statement = conn.createStatement();
            String sql = "select * from product";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                System.out.println("id:" + id + " name:" + name + " price:" + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
    }
}
