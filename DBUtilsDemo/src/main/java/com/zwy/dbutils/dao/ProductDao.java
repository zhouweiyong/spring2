package com.zwy.dbutils.dao;


import com.zwy.dbutils.bean.ProductBean;

import java.util.List;

public interface ProductDao {

    void add(ProductBean bean);

    void delete(int id);

    void modify(ProductBean bean);

    ProductBean findById(int id);

    List<ProductBean> findAll();
}
