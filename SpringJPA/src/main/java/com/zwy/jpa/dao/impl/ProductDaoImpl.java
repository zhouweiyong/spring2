package com.zwy.jpa.dao.impl;

import com.zwy.jpa.bean.Product;
import com.zwy.jpa.dao.ProductDao;
import com.zwy.jpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void add(Product product) {
        EntityManager manager = JPAUtil.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(product);
        transaction.commit();
        manager.close();
    }

    @Override
    public Product findById(int id){
        EntityManager manager = JPAUtil.getManager();
       return manager.find(Product.class,id);
    }
}
