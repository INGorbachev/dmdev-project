package com.dmdev.entity;

import com.dmdev.util.HibernateUtil;
import lombok.Cleanup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void checkProductSave() {

        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();

        var product = Product.builder()
                .productName("Iphone7")
                .description("super phone for everybody")
                .price(500.00)
                .productQuantity(5)
                .build();

        var actual = product.getProductName();

        session.beginTransaction();
        session.save(product);
        session.clear();
        var expected = session.get(Product.class, 1L).getProductName();
        session.getTransaction().commit();

        Assertions.assertThat(actual).isEqualTo(expected);
    }


}

