package com.example.demo.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name="coupons")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.ORDINAL)
    private Category category;

    @ManyToOne
    private Company company;
    private String title;
    private String desc;
    private Date startDate;
    private Date endDate;
    private int amount;
    private double price;
    private String image;

}
