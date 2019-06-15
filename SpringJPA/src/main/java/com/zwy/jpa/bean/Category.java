package com.zwy.jpa.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "a_category")
public class Category {
    private int id;
    private String name;
    private List<Product> productList = new ArrayList<>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

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

    //指明和Product的哪一个属性建立关系
    @OneToMany(mappedBy = "category")
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
