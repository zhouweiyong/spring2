package com.zwy.ioc;

import com.zwy.ioc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 由spring生产实例
 * 默认情况下spring生成的实例是单例，可以通过设置做成多例
 */
public class MainTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //XML实现IOC
        UserService userService = (UserService) context.getBean("us");
        userService.login();

        //注解实现IOC
        UserService user2 = (UserService) context.getBean("us2");
        user2.login();

    }
}