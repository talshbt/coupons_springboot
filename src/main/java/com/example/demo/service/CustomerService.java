package com.example.demo.service;

import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;
import com.example.demo.exceptions.CouponSystemException;

import java.util.List;

public interface CustomerService {
    void purchaseCoupon(int couponId) throws CouponSystemException;
    List<Coupon1> getCustomerCoupons() throws CouponSystemException;
    List<Coupon1> getCustomerCoupons(Category category);
    List<Coupon1> getCustomerCoupons(double price);
    Customer getCustomerDetails() throws CouponSystemException;
    int getIdByLoginDetails(String email, String password);
}
