package com.zwy.service.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zwy.service.bean.AccountBean;
import com.zwy.service.dao.AccountDao;
import com.zwy.service.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void update(AccountBean bean) {
        DbUtils dbUtils = new DbUtils();
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "update account set balance=? where id=?";
            runner.update(dbUtils.getConn(),
                    sql,
                    bean.getBalance(),
                    bean.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public AccountBean findById(int id) {
        try {
            DbUtils dbUtils = new DbUtils();
            QueryRunner runner = new QueryRunner();
            String sql = "select * from account where id=?";
            AccountBean accountBean = runner.query(dbUtils.getConn(),
                    sql,
                    new BeanHandler<AccountBean>(AccountBean.class),
                    id);
            return accountBean;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询条件包含中文，需要在c3p0-config.xml做设置
     *
     * @param name
     * @return
     */
    @Override
    public AccountBean findByName(String name) {
        try {
            DbUtils dbUtils = new DbUtils();
            QueryRunner runner = new QueryRunner();
            String sql = "select * from account where name=?";
            AccountBean accountBean = runner.query(dbUtils.getConn(),
                    sql,
                    new BeanHandler<AccountBean>(AccountBean.class),
                    name);
            return accountBean;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AccountBean> findAll() {
        try {
            DbUtils dbUtils = new DbUtils();
            QueryRunner runner = new QueryRunner();
            String sql = "select * from account";
            List<AccountBean> list = runner.query(new ComboPooledDataSource().getConnection(),
                    sql,
                    new BeanListHandler<AccountBean>(AccountBean.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
