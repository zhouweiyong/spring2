package com.zwy.ioc.service.impl;

import com.zwy.ioc.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//注解
@Component("us2")
@Scope("prototype")//加上这个，生成的对象就不是单例，而是多例
public class User2ServiceImpl implements UserService {
    @Override
    public void login() {
        System.out.println("user2 登陆成功");
    }
}
