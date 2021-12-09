package com.enigma.betestmmi.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return sessionFactory;
    }

}
