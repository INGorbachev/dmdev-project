package com.dmdev.entity;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testMappingBuyer(){

        var configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure();

        try (var sessionFactory = configuration.buildSessionFactory()) {
            var session = sessionFactory.openSession();

            session.beginTransaction();
            var customer = Customer.builder()
                    .userName("IVAN222")
                    .firstName("Ivan")
                    .lastName("Ivanov")
                    .eMail("ivan2000@mail.ru")
                    .password("pass")
                    .phoneNumber("+791512345678")
                    .build();

            session.save(customer);
            session.getTransaction().commit();
        }


    }

}