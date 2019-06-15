package com.zwy.jpa.dao.impl;

import com.zwy.jpa.bean.Category;
import com.zwy.jpa.dao.CategoryDao;
import com.zwy.jpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public void add(Category category) {
        EntityManager manager = JPAUtil.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(category);
        transaction.commit();
        manager.close();
    }

    @Override
    public Category findById(int id) {
        EntityManager manager = JPAUtil.getManager();
        Category category = manager.find(Category.class, id);
        return category;
    }

}
