package com.zwy.dbutils.dao.impl;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zwy.dbutils.bean.ProductBean;
import com.zwy.dbutils.dao.ProductDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void add(ProductBean bean) {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "insert into product values(null,?,?,?)";
            runner.update(new ComboPooledDataSource().getConnection(),
                    sql,
                    bean.getName(),
                    bean.getPrice(),
                    bean.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "delete from product where id=?";
            runner.update(new ComboPooledDataSource().getConnection(),
                    sql,
                    id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(ProductBean bean) {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "update product set name=?,price=?,cid=? where id=?";
            runner.update(new ComboPooledDataSource().getConnection(),
                    sql,
                    bean.getName(),
                    bean.getPrice(),
                    bean.getCid(),
                    bean.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProductBean findById(int id) {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "select * from product where id=?";
            ProductBean bean = runner.query(new ComboPooledDataSource().getConnection(),
                    sql,
                    new BeanHandler<ProductBean>(ProductBean.class),
                    id);
            return bean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProductBean> findAll() {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "select * from product";
            List<ProductBean> list = runner.query(new ComboPooledDataSource().getConnection(),
                    sql,
                    new BeanListHandler<ProductBean>(ProductBean.class));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
