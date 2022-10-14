package com.dmdev.entity;

import com.dmdev.util.HibernateTestUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CategoryTest {

    @Test
    void checkCategorySave() {
        @Cleanup var sessionFactory = HibernateTestUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        var category = Category.builder()
                .name("Phone")
                .build();
        session.save(category);
        session.clear();

        assertThat(category.getId()).isNotNull();

        session.getTransaction().commit();
    }
}