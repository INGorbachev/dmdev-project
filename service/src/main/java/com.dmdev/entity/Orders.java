package com.dmdev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ProductsInOrder productsInOrder;
    private LocalDate openOrder;
    private LocalDate closeOrder;
    @Enumerated(EnumType.STRING)
    private Status orderStatus;
    private Long customer_id;
    private Long product_id;
    @OneToMany
    private List<Product> products;

}
