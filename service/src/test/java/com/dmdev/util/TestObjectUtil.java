package com.dmdev.util;

import com.dmdev.entity.Basket;
import com.dmdev.entity.Category;
import com.dmdev.entity.Customer;
import com.dmdev.entity.CustomerInfo;
import com.dmdev.entity.Order;
import com.dmdev.entity.Product;
import com.dmdev.entity.Role;
import com.dmdev.entity.Status;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class TestObjectUtil {
    public static final Category CATEGORY_1 = Category.builder()
            .name("Phone")
            .build();
    public static final Product PRODUCT_1 = Product.builder()
            .name("Samsung Galaxy S21")
            .description("super phone for everybody")
            .price(500.00)
            .quantity(5)
            .category(CATEGORY_1)
            .build();
    public static final Basket BASKET_1 = Basket.builder()
            .product(PRODUCT_1)
            .quantity(2)
            .build();
    public static final Customer CUSTOMER_1 = Customer.builder()
            .eMail("ivan2000@mail.ru")
            .password("pass")
            .customerInfo(CustomerInfo.builder()
                    .firstName("Ivan")
                    .lastName("Ivanov")
                    .phone("+79152323234")
                    .build())
            .role(Role.ADMIN)
            .build();
    public static final Order ORDER_1 = Order.builder()
            .customer(CUSTOMER_1)
            .open(LocalDate.now())
            .close(null)
            .status(Status.OPEN)
            .basket(BASKET_1)
            .build();
}
