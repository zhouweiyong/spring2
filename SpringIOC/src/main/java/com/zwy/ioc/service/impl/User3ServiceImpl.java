package com.zwy.ioc.service.impl;

import com.zwy.ioc.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * xml方式
 * 带参数构造
 * 依赖注入
 */
public class User3ServiceImpl implements UserService {
    private String name;

    public User3ServiceImpl(String name) {
        this.name = name;
    }

    @Override
    public void login() {
        System.out.println(name+" 登陆成功");
    }
}
