package com.zwy.service;

import com.zwy.service.bean.AccountBean;
import com.zwy.service.dao.AccountDao;
import com.zwy.service.dao.impl.AccountDaoImpl;
import com.zwy.service.service.AccountService;
import com.zwy.service.service.impl.AccountServiceImpl;
import org.junit.Test;

import java.util.List;

public class AccountDaoTest {

    @Test
    public void findById() {
        AccountDao dao = new AccountDaoImpl();
        AccountBean bean = dao.findById(1);
        System.out.println("bean>>id=" + bean.getId() + " name=" + bean.getName() + " balance=" + bean.getBalance());
    }

    @Test
    public void findByName() {
        AccountDao dao = new AccountDaoImpl();
        AccountBean bean = dao.findByName("张三");
        System.out.println("bean>>id=" + bean.getId() + " name=" + bean.getName() + " balance=" + bean.getBalance());
    }

    @Test
    public void findAll() {
        AccountDao dao = new AccountDaoImpl();
        List<AccountBean> list = dao.findAll();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("name:" + list.get(i).getName());
            }
        }
    }

    @Test
    public void zToL(){
        AccountService service = new AccountServiceImpl();
        service.zToL(100);
    }
}
