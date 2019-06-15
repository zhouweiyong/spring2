package com.zwy.jpa.dao;

import com.zwy.jpa.bean.Category;

public interface CategoryDao {

    public void add(Category category);

    Category findById(int id);
}
