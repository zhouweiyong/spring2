package com.zwy.ioc.service.impl;

import com.zwy.ioc.service.UserService;
import org.springframework.stereotype.Component;

//xml
public class UserServiceImpl implements UserService {
    @Override
    public void login() {
        System.out.println("User1 登陆成功");
    }
}
