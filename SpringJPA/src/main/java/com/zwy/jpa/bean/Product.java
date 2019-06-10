package com.zwy.jpa.bean;

import javax.persistence.*;

@Entity(name = "a_product")
public class Product {
    private int id;
    private String name;
//    private int cid;

    private Category category;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @ManyToOne(targetEntity = Category.class)
    //如果不写JoinColumn，hibernate自动创建一个列作为外键，列名为cid_id
    //通过JoinColumn为外键列命名
//    @JoinColumn(name = "cid")
//    public int getCid() {
//        return cid;
//    }
//
//    public void setCid(int cid) {
//        this.cid = cid;
//    }

    @ManyToOne
    @JoinColumn(name = "cid")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
