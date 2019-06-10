package com.zwy.jpa.dao;

import com.zwy.jpa.bean.User;

public interface UserDao {

    public void add(User user);

    public User findById(int id);

    public void remove(int id);

    public void update(int id,User user);

}
