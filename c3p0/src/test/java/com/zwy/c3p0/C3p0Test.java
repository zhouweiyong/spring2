package com.zwy.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 代码配置连接池
 */
public class C3p0Test {
    @Test
    public void findById() {
        try {
            //创建连接池
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            //设置连接池
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://192.168.0.150:3306/shop?serverTimezone=GMT");
            dataSource.setUser("zhou");
            dataSource.setPassword("Nz123456!");

            //设置连接池最大连接数
            dataSource.setMaxPoolSize(20);
            //设置初始连接数
            dataSource.setInitialPoolSize(10);

            Connection conn = dataSource.getConnection();
            System.out.println(conn);
            String sql = "select * from product where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price =rs.getInt("price");

                System.out.println("id:"+id+" name:"+name+" price:"+price);
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
