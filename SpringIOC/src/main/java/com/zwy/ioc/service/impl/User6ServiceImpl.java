package com.zwy.ioc.service.impl;

import com.zwy.ioc.service.UserService;

import java.util.List;

/**
 * xml方式，通过set方法注入List类型参数
 */
public class User6ServiceImpl implements UserService {
    private List<String> name;

    public void setName(List<String> name) {
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
