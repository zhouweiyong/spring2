package com.zwy.ioc.bean;

import com.oracle.webservices.internal.api.message.PropertySet;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("ab")
public class AddressBean {


    public void showAdd() {
        System.out.println("live in 深圳");
    }
}
