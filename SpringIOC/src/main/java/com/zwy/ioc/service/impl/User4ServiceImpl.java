package com.zwy.ioc.service.impl;

import com.zwy.ioc.service.UserService;

/**
 * xml方式
 * 依赖注入
 * 通过set参数
 */
public class User4ServiceImpl implements UserService {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void login() {
        System.out.println(name + " 登陆成功");
    }
}
