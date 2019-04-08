package com.zwy.pre;

import org.junit.Test;

import java.sql.*;

/**
 * PreparedStatement增删改查
 */
public class StatementTest {

    @Test
    public void add() {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "insert into product values (null ,?,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "戴尔电脑");
            statement.setInt(2, 3800);
            statement.setInt(3, 2);
            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
    }
    @Test
    public void delete(){
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "delete from product where name=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "戴尔电脑");
            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
    }
    @Test
    public void modify(){
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "update product set name=? where name=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "戴尔电脑222");
            statement.setString(2, "戴尔电脑");
            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
    }

    @Test
    public void query() {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "select * from product";
            statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
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



