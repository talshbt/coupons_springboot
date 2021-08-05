package com.example.demo.beans;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name="coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
