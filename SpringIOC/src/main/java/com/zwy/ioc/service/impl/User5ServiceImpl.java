package com.zwy.ioc.service.impl;

import com.zwy.ioc.service.UserService;

/**
 * xml方式，通过set方法注入数组类型参数
 */
public class User5ServiceImpl implements UserService {
    private String[] name;

    public void setName(String[] name) {
        this.name = name;
    }

    @Override
    public void login() {
        for (String s : name) {
            System.out.print(s + " ");
        }
        System.out.println(" 登陆成功");
    }
}
