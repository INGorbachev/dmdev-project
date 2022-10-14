package com.dmdev.entity;

import com.dmdev.util.HibernateTestUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ProductTest {
    @Test
    void checkProductSave() {

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
        session.save(category);
        session.save(product);
        session.clear();

        assertThat(product.getId()).isNotNull();

        session.getTransaction().commit();
    }
    @Test
    void checkAddProduct() {
        @Cleanup var sessionFactory = HibernateTestUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        var category = Category.builder()
                .name("Notebook")
                .build();
        var product = Product.builder()
                .name("Macbook")
                .build();
        category.addProduct(product);
        session.save(product);
        session.clear();

        assertThat(category.getId()).isNotNull();

        session.getTransaction().commit();
    }
}

