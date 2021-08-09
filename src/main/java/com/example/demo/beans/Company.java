package com.example.demo.beans;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="companies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "company")
    @Singular
    @ToString.Exclude
    private List<Coupon1> coupons = new ArrayList<>();


}
