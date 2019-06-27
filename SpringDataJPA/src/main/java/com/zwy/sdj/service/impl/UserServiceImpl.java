package com.zwy.sdj.service.impl;

import com.zwy.sdj.bean.User;
import com.zwy.sdj.dao.UserDao;
import com.zwy.sdj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save(new User("lisi",12));
        System.out.println("user save!!!");
    }
}
