package com.zwy.aop.service.impl;

import com.zwy.aop.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void login() {
        System.out.println("张三登陆成功");
    }
}
