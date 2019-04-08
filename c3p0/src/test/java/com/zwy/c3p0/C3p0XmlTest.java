package com.zwy.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 通过xml配置连接池
 */
public class C3p0XmlTest {

    @Test
    public void findById() {
        try {
            //创建连接池
            ComboPooledDataSource dataSource = new ComboPooledDataSource();

            Connection conn = dataSource.getConnection();
            System.out.println(conn);
            String sql = "select * from product where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");

                System.out.println("id:" + id + " name:" + name + " price:" + price);
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
