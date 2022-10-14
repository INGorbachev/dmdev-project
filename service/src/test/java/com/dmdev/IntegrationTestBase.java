package com.dmdev;


import com.dmdev.util.HibernateTestUtil;
import com.dmdev.util.TestObjectUtil;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import org.junit.jupiter.api.BeforeAll;

@UtilityClass
public class IntegrationTestBase {

    static void prepareDatabase() {
        @Cleanup var sessionFactory = HibernateTestUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(TestObjectUtil.CATEGORY_1);
        session.save(TestObjectUtil.PRODUCT_1);
        session.save(TestObjectUtil.BASKET_1);
        session.save(TestObjectUtil.CUSTOMER_1);
        session.save(TestObjectUtil.ORDER_1);

        session.getTransaction().commit();
    }

}
