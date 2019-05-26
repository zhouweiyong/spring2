package com.zwy.ioc.service.impl;

import com.zwy.ioc.bean.AddressBean;
import com.zwy.ioc.bean.UserBean;
import com.zwy.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 注解方式，注入对象依赖
 */
@Service("user9")
public class User9ServiceImpl implements UserService {

    //    @Resource(name = "ab")//根据别名注入
    @Autowired//自动注入
    private AddressBean addressBean;

    @Override
    public void login() {
        addressBean.showAdd();
    }
}
