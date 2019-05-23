package com.zwy.service.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    private ComboPooledDataSource dataSource;

    public DbUtils() {
        this.dataSource = new ComboPooledDataSource();
    }

    public Connection getConn() throws SQLException {
        Connection connection = tl.get();
        if (connection==null){
            connection =dataSource.getConnection();
            tl.set(connection);
        }
        return connection;
    }

    public void close(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                rs.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 关闭连接池
     */
    public void closePool() {
        dataSource.close();
    }
}
