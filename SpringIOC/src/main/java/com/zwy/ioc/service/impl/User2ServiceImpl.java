package com.zwy.ioc.service.impl;

import com.zwy.ioc.service.UserService;
import org.springframework.stereotype.Component;

//注解
@Component("us2")
public class User2ServiceImpl implements UserService {
    @Override
    public void login() {
        System.out.println("user2 登陆成功");
    }
}
