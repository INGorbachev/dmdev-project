package com.dmdev.entity;

import org.assertj.core.api.Assertions;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class OrdersTest {

    @Test
    void checkOrder(){

        var configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure();

        try (var sessionFactory = configuration.buildSessionFactory()){
            var session = sessionFactory.openSession();

            session.beginTransaction();

            var order = Orders.builder()
                    .openOrder(LocalDate.now())
                    .closeOrder(null)
                    .orderStatus(Status.OPEN)
                    .customer_id(1L)
                    .product_id(1L)
                    .build();

            session.save(order);
            session.getTransaction().commit();
            session.clear();
            var expected = session.get(Product.class, 1L).getProductName();

            Assertions.assertThat(order).isEqualTo(expected);
        }
    }

}