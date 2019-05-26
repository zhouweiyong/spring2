package com.zwy.ioc;

import com.zwy.ioc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 由spring生产实例
 * 默认情况下spring生成的实例是单例，可以通过设置做成多例
 *
 * @Component 是通用注解，但是随着时间的推移，代码会分层来写
 * 所以Spring针对三层的类也提供了各自的注解
 * web---@Controller
 * service---@Service
 * dao---@Repository
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
        UserService user3 = (UserService) context.getBean("us2");

        if (user2 == user3) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }


        //带参，依赖注入，通过构造函数注入
        UserService user4 = (UserService) context.getBean("us3");
        user4.login();

        //带参，依赖注入，通过set方法注入
        UserService user5 = (UserService) context.getBean("us4");
        user5.login();

        UserService user6 = (UserService) context.getBean("us5");
        user6.login();
        UserService user7 = (UserService) context.getBean("us6");
        user7.login();

        UserService user8 = (UserService) context.getBean("us7");
        user8.login();

        UserService user9 = (UserService) context.getBean("us8");
        user9.login();

        UserService user10 = (UserService) context.getBean("user9");
        user10.login();

    }
}
