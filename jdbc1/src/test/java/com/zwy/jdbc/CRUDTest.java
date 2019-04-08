package com.zwy.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库增删改查测试
 */
public class CRUDTest {

    @Test
    public void add() {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = JDBCUtils.getConn();
            statement = conn.createStatement();
            String sql = "insert into product values (null ,'thinkpad t60',9600,2)";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
    }

    @Test
    public void delete() {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = JDBCUtils.getConn();
            statement = conn.createStatement();
            String sql = "delete from product where name='thinkpad t60'";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
    }

    @Test
    public void modify() {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = JDBCUtils.getConn();
            statement = conn.createStatement();
            String sql = "update product set name='thinkpad t450' where name='thinkpad t60'";
            int i = statement.executeUpdate(sql);
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
