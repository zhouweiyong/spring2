package com.zwy.ioc.service.impl;

import com.zwy.ioc.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * xml方式，通过set方法注入Map类型参数
 */
public class User7ServiceImpl implements UserService {
    private Map<String, String> name;

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    @Override
    public void login() {
        Set<Map.Entry<String, String>> entrySet = name.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getValue() + " ");
        }
        System.out.println(" 登陆成功");
    }
}
