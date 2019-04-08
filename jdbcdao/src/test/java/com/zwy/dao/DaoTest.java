package com.zwy.dao;

import com.zwy.dao.bean.ProductBean;
import com.zwy.dao.dao.ProductDao;
import com.zwy.dao.dao.impl.ProductDaoImpl;
import org.junit.Test;

import java.util.List;

public class DaoTest {

    @Test
    public void findAll() {
        ProductDao dao = new ProductDaoImpl();
        List<ProductBean> list = dao.findAll();
        for (ProductBean bean : list) {
            System.out.println("id:" + bean.getId() + " name:" + bean.getName() + " price:" + bean.getPrice() + " cid=" + bean.getCid());
        }
    }

    @Test
    public void findById() {
        ProductDao dao = new ProductDaoImpl();
        ProductBean bean = dao.findById(5);
        System.out.println("id:" + bean.getId() + " name:" + bean.getName() + " price:" + bean.getPrice() + " cid=" + bean.getCid());

    }

    @Test
    public void add() {
        ProductBean bean = new ProductBean();
        bean.setName("HTC ONE");
        bean.setPrice(7200);
        bean.setCid(1);
        ProductDao dao = new ProductDaoImpl();
        dao.add(bean);
    }

    @Test
    public void delete() {
        ProductDao dao = new ProductDaoImpl();
        List<ProductBean> list = dao.findAll();
        dao.delete(list.get(list.size() - 1).getId());
    }

    @Test
    public void modify() {
        ProductDao dao = new ProductDaoImpl();
        List<ProductBean> list = dao.findAll();
        ProductBean bean = list.get(list.size() - 1);
        bean.setPrice(8600);
        dao.modify(bean);
    }
}
