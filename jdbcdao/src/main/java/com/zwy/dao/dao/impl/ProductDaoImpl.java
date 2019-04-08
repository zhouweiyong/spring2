package com.zwy.dao.dao.impl;

import com.zwy.dao.bean.ProductBean;
import com.zwy.dao.dao.ProductDao;
import com.zwy.dao.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void add(ProductBean bean) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "insert into product values (null ,?,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, bean.getName());
            statement.setInt(2, bean.getPrice());
            statement.setInt(3, bean.getCid());
            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "delete from product where id=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
    }

    @Override
    public void modify(ProductBean bean) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "update product set name=?,price=?,cid=? where id=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, bean.getName());
            statement.setInt(2, bean.getPrice());
            statement.setInt(3, bean.getCid());
            statement.setInt(4,bean.getId());
            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
    }

    @Override
    public ProductBean findById(int id) {
        Connection conn = null;
        PreparedStatement statement = null;
        ProductBean bean = null;
        try {
            conn = JDBCUtils.getConn();
            String sql = "select * from product where id=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                bean = new ProductBean(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("cid")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
        return bean;
    }

    @Override
    public List<ProductBean> findAll() {
        Connection conn = null;
        PreparedStatement statement = null;
        ArrayList<ProductBean> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConn();
            String sql = "select * from product";
            statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ProductBean bean = new ProductBean(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("cid")
                );
                list.add(bean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement);
        }
        return list;
    }
}
