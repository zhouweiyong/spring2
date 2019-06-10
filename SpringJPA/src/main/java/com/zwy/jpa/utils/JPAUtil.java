package com.zwy.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("account");

    public static EntityManager getManager() {
        return factory.createEntityManager();
    }


}
