package com.dmdev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String eMail;
    private String password;
    @Embedded
    private CustomerInfo customerInfo;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();
}
