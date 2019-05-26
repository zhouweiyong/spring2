package com.zwy.ioc.service.impl;

import com.zwy.ioc.bean.UserBean;
import com.zwy.ioc.service.UserService;

import java.util.Map;
import java.util.Set;

/**
 * xml方式，通过set方法注入对象类型参数
 */
public class User8ServiceImpl implements UserService {
    private UserBean userBean;

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    @Override
    public void login() {

        System.out.println(userBean.getName() + " 登陆成功");
    }
}
