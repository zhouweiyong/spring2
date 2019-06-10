package com.zwy.jpa.bean;

import javax.persistence.*;

/**
 * 表示这是一个实体，它会和表相对
 * 通过name属性指定表名，如果不指定，则使用类名作为表名
 */
//@Entity(name = "t_user")
@Entity
//也可以通过Table注解指定表名，但Entity还是需要
@Table(name = "a_user")
public class User {
    private int id;
    private String name;
    private int age;

    @Id//表示这个id是一个主键
    @GeneratedValue//主键生成策略，自增长
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //通过Column指定列名
//    @Column(name = "user_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
