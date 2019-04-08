package com.zwy.dao.dao;

import com.zwy.dao.bean.ProductBean;

import java.util.List;

public interface ProductDao {

    void add(ProductBean bean);

    void delete(int id);

    void modify(ProductBean bean);

    ProductBean findById(int id);

    List<ProductBean> findAll();
}
