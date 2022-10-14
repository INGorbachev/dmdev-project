package com.dmdev.entity;

import com.dmdev.util.HibernateTestUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BasketTest {

        @Test
        void checkBasketSave(){

            @Cleanup var sessionFactory = HibernateTestUtil.buildSessionFactory();
            @Cleanup var session = sessionFactory.openSession();
            session.beginTransaction();
            var category = Category.builder()
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
            session.save(category);
            session.save(product);
            session.save(basket);
            session.clear();

            assertThat(basket.getId()).isNotNull();

            session.getTransaction().commit();
        }
}