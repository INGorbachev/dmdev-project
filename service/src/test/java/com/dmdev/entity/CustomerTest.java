package com.dmdev.entity;

import com.dmdev.util.HibernateTestUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CustomerTest {

    @Test
    void testCustomerSave() {

        @Cleanup var sessionFactory = HibernateTestUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
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
        session.save(customer);
        session.clear();

        assertThat(customer.getId()).isNotNull();

        session.getTransaction().commit();
    }
}

