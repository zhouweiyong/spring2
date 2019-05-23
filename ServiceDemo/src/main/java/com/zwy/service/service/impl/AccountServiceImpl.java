package com.zwy.service.service.impl;

import com.zwy.service.bean.AccountBean;
import com.zwy.service.dao.AccountDao;
import com.zwy.service.dao.impl.AccountDaoImpl;
import com.zwy.service.service.AccountService;
import com.zwy.service.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    @Override
    public AccountBean queryBalace(String name) {
        AccountDao dao = new AccountDaoImpl();
        AccountBean bean = dao.findByName(name);
        return bean;
    }

    @Override
    public boolean zToL(int num) {
        Connection conn = null;
        try {
            conn = new DbUtils().getConn();
            conn.setAutoCommit(false);
            AccountDao dao = new AccountDaoImpl();
            AccountBean zb = dao.findByName("张三");
            AccountBean lb = dao.findByName("李四");

            zb.setBalance(zb.getBalance() - num);
            lb.setBalance(lb.getBalance() + num);
            dao.update(zb);
//            int i = 1 / 0;
            dao.update(lb);

            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {//事务执行出错回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public boolean lToZ(int num) {
        Connection conn = null;
        try {
            conn = new DbUtils().getConn();
            conn.setAutoCommit(false);
            AccountDao dao = new AccountDaoImpl();
            AccountBean zb = dao.findByName("张三");
            AccountBean lb = dao.findByName("李四");

            lb.setBalance(lb.getBalance() - num);
            zb.setBalance(zb.getBalance() + num);
            dao.update(lb);
            //认为造成转账出错
            int i = 1 / 0;
            dao.update(zb);

            conn.commit();
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            try {//事务执行出错回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;
        }
    }
}
