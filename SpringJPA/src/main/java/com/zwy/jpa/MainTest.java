package com.zwy.jpa;

import com.zwy.jpa.bean.User;

import javax.persistence.*;

public class MainTest {
    public static void main(String[] args) {
        //获取实体工厂
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("account");
//        创建实体管理员
        EntityManager manager = factory.createEntityManager();
        //开启事务，写入操作必须开启事务（增删改），查询不需要开启
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        //保存数据，底下干活的是hibernate
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        //持久化保存
        manager.persist(user);
        transaction.commit();

        manager.close();
        factory.close();
    }
}
