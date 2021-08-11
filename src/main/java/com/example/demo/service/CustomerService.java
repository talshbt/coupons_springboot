package com.example.demo.service;

import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;

import java.util.List;

public interface CustomerService {
    void purchaseCoupon(int couponId);
    List<Coupon1> getAllCustomerCoupons(int customerId);
    List<Coupon1> getAllCustomerCouponsByCategory(int customerId, Category category);
    List<Coupon1> getAllCustomerCouponsByPrice(int customerId, double price);
    Customer getCustomerDetails(int customerId);
    void setCustomerId(int companyId);
}
