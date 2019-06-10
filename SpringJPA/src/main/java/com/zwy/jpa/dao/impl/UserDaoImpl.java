package com.zwy.jpa.dao.impl;

import com.zwy.jpa.bean.User;
import com.zwy.jpa.dao.UserDao;
import com.zwy.jpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        EntityManager manager = JPAUtil.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(user);
        transaction.commit();
        manager.close();
    }

    @Override
    public User findById(int id) {
        EntityManager manager = JPAUtil.getManager();
        User user = manager.find(User.class, id);
        return user;
    }

    @Override
    public void remove(int id) {
        EntityManager manager = JPAUtil.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        User user = manager.find(User.class, id);
        manager.remove(user);
        transaction.commit();
    }

    @Override
    public void update(int id, User user) {
        EntityManager manager = JPAUtil.getManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        User tu = manager.find(User.class, id);
        tu.setAge(user.getAge());
        tu.setName(user.getName());
        manager.persist(tu);
        transaction.commit();
    }
}
