package com.zwy.jpa;

import com.zwy.jpa.bean.Category;
import com.zwy.jpa.bean.Product;
import com.zwy.jpa.dao.CategoryDao;
import com.zwy.jpa.dao.ProductDao;
import com.zwy.jpa.dao.impl.CategoryDaoImpl;
import com.zwy.jpa.dao.impl.ProductDaoImpl;
import org.junit.Test;

import java.util.List;

public class ManyToOneTest {

    @Test
    public void addCategory() {
        CategoryDao dao = new CategoryDaoImpl();
        dao.add(new Category("手机"));
        dao.add(new Category("电脑"));
        dao.add(new Category("优盘"));
    }

    //一对多测试
    @Test
    public void addProduct() {
        ProductDao dao = new ProductDaoImpl();
        Product product = new Product();
        product.setName("Redmi note7 pro");
        CategoryDao cDao = new CategoryDaoImpl();
        product.setCategory(cDao.findById(20));
        dao.add(product);
    }

    @Test
    public void findCategory(){
        CategoryDao dao = new CategoryDaoImpl();
        Category category = dao.findById(20);
        List<Product> productList = category.getProductList();
        for (Product product : productList) {
            System.out.println(product.getId()+" "+product.getName());
        }
    }

    @Test
    public void findProduct(){
        ProductDao dao = new ProductDaoImpl();
        Product product = dao.findById(24);
        System.out.println(product.getId()+" "+product.getName()+" category:"+product.getCategory().getName());
    }
}
