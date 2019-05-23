package com.zwy.service.dao;

import com.zwy.service.bean.AccountBean;

import java.util.List;

public interface AccountDao {

    public void update(AccountBean bean);

    public AccountBean findById(int id);


    public AccountBean findByName(String name);

    public List<AccountBean> findAll();

}
