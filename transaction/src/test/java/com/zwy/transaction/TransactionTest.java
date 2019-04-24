package com.zwy.transaction;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {

    @Test
    public void test1() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            Connection conn = dataSource.getConnection();
            //开启事务，关闭自动提交
            conn.setAutoCommit(false);

            String sql = "insert into product values(null,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "戴尔 xps");
            statement.setInt(2, 6900);
            statement.setInt(3, 2);
            statement.executeUpdate();

            //提交事务
            conn.commit();

            //释放资源，回收连接对象
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
