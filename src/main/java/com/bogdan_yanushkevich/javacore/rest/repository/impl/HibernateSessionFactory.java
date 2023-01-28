package com.bogdan_yanushkevich.javacore.rest.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println("Database connection error.");
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public static Session openSession() {
        return getSessionFactory().openSession();
    }
}



   /* private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {

    }

    public static SessionFactory getSessionFactory() {

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (sessionFactory == null) {

            Flyway flyway = Flyway.configure().dataSource(properties.getProperty("URL"),
                    properties.getProperty("userName"), properties.getProperty("password")).load();
            flyway.baseline();
            flyway.migrate();

            try {

                Configuration configuration = new Configuration().configure();

                configuration.addAnnotatedClass(Event.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(File.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }
}*/