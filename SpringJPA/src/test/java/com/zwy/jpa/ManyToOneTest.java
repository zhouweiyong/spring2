package com.zwy.jpa;

import com.zwy.jpa.bean.Category;
import com.zwy.jpa.bean.Product;
import com.zwy.jpa.dao.CategoryDao;
import com.zwy.jpa.dao.ProductDao;
import com.zwy.jpa.dao.impl.CategoryDaoImpl;
import com.zwy.jpa.dao.impl.ProductDaoImpl;
import org.junit.Test;

public class ManyToOneTest {

    @Test
    public void addCategory() {
        CategoryDao dao = new CategoryDaoImpl();
        dao.add(new Category("手机"));
        dao.add(new Category("电脑"));
        dao.add(new Category("优盘"));
    }

    @Test
    public void addProduct(){


    }
}
