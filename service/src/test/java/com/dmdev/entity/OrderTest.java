package com.dmdev.entity;

import com.dmdev.util.HibernateTestUtil;
import lombok.Cleanup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class OrderTest {

    @Test
    void checkOrderSave() {

        @Cleanup var sessionFactory = HibernateTestUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        Category category = Category.builder()
                .name("Phone")
                .build();
        var product = Product.builder()
                .name("Iphone7")
                .description("super phone for everybody")
                .price(500.00)
                .quantity(5)
                .category(category)
                .build();
        var basket = Basket.builder()
                .product(product)
                .quantity(2)
                .build();
        var customer = Customer.builder()
                .eMail("ivan2000@mail.ru")
                .password("pass")
                .customerInfo(CustomerInfo.builder()
                        .firstName("Ivan")
                        .lastName("Ivanov")
                        .phone("+79152323234")
                        .build())
                .role(Role.ADMIN)
                .build();
        var order = Order.builder()
                .customer(customer)
                .open(LocalDate.now())
                .close(null)
                .status(Status.OPEN)
                .basket(basket)
                .build();
        session.save(category);
        session.save(product);
        session.save(basket);
        session.save(customer);
        session.save(order);
        session.clear();

        Assertions.assertThat(order.getId()).isNotNull();

        session.getTransaction().commit();
    }
}

