package com.example.demo.beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    //cascade type = all (only on this direction)
//    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
//    @Singular
//    List<Coupon> coupons;


}
