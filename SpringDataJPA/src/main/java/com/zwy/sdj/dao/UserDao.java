package com.zwy.sdj.dao;

import com.zwy.sdj.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {


}
