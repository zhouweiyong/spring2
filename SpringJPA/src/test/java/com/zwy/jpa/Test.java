package com.zwy.jpa;

import com.zwy.jpa.bean.User;
import com.zwy.jpa.dao.UserDao;
import com.zwy.jpa.dao.impl.UserDaoImpl;
import com.zwy.jpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Test {
    @org.junit.Test
    public void add() {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setName("李世民");
        user.setAge(150);
        userDao.add(user);

    }

    @org.junit.Test
    public void findById() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findById(11);
        System.out.println(user.getName() + " " + user.getAge());
    }

    @org.junit.Test
    public void remove() {
        UserDao userDao = new UserDaoImpl();
        userDao.remove(12);
    }
    @org.junit.Test
    public void update(){
        UserDao userDao = new UserDaoImpl();
        User user =new User();
        user.setAge(200);
        user.setName("秦始皇");
        userDao.update(11,user);
    }
}
