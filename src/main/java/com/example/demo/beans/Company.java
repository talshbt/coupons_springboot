package com.example.demo.beans;

import lombok.Singular;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    @OneToMany
    @Singular
    List<Coupon> coupons;


}
