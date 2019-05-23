package com.zwy.service.service;

import com.zwy.service.bean.AccountBean;

public interface AccountService {

    public AccountBean queryBalace(String name);

    public boolean zToL(int num);

    public boolean lToZ(int num);
}
