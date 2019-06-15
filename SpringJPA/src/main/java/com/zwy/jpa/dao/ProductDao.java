package com.zwy.jpa.dao;

import com.zwy.jpa.bean.Product;

public interface ProductDao {

    public void add(Product product);

    Product findById(int id);
}
