package com.example.demo.beans;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany
    List<Coupon> coupons;
}
