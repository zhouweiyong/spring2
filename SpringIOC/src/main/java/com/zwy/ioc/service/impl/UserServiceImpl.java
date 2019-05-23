package com.zwy.ioc.service.impl;

import com.zwy.ioc.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void login() {
        System.out.println("登陆成功");
    }
}
