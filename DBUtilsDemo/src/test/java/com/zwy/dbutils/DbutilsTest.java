package com.zwy.dbutils;

import com.zwy.dbutils.bean.ProductBean;
import com.zwy.dbutils.dao.impl.ProductDaoImpl;
import org.junit.Test;

import java.util.List;

public class DbutilsTest {
    @Test
    public void add() {
        ProductBean bean = new ProductBean();
        bean.setName("HTC G2");
        bean.setPrice(3600);
        bean.setCid(1);
        ProductDaoImpl dao = new ProductDaoImpl();
        dao.add(bean);
    }

    @Test
    public void delete() {
        ProductDaoImpl dao = new ProductDaoImpl();
        List<ProductBean> all = dao.findAll();
        ProductBean bean = all.get(all.size() - 1);
        dao.delete(bean.getId());
    }

    @Test
    public void modify() {
        ProductDaoImpl dao = new ProductDaoImpl();
        List<ProductBean> all = dao.findAll();
        ProductBean bean = all.get(all.size() - 1);
        bean.setName("HTC G10");
        dao.modify(bean);

    }

    @Test
    public void findById() {
        ProductDaoImpl dao = new ProductDaoImpl();
        ProductBean bean = dao.findById(3);
        System.out.println("id:" + bean.getId() + " name:" + bean.getName() + " price:" + bean.getPrice() + " cid:" + bean.getCid());

    }

    @Test
    public void findAll() {
        ProductDaoImpl dao = new ProductDaoImpl();
        List<ProductBean> all = dao.findAll();
        for (ProductBean bean : all) {
            System.out.println("id:" + bean.getId() + " name:" + bean.getName() + " price:" + bean.getPrice() + " cid:" + bean.getCid());
        }
    }
}
