package com.dmdev.util;

import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

@UtilityClass
public class HibernateTestUtil {

    public static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:14");

    static {
        postgres.start();
    }

    public static SessionFactory buildSessionFactory() {
        var configuration = buildConfiguration();
        return configuration.buildSessionFactory();
    }

    private static Configuration buildConfiguration() {

        var configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.setProperty("hibernate.connection.url", postgres.getJdbcUrl());
        configuration.setProperty("hibernate.connection.username", postgres.getUsername());
        configuration.setProperty("hibernate.connection.password", postgres.getPassword());
        configuration.configure();
        return configuration;
    }
}
