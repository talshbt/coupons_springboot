package com.example.demo.service;

import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;
import com.example.demo.exceptions.CouponSystemException;

import java.util.List;

public interface CompanyService {
    void addCoupon(Coupon1 coupon) throws CouponSystemException;
    void updateCoupon(int couponId, Coupon1 coupon);
    void deleteCoupon(int couponId, Coupon1 coupon);
    List<Coupon1> getAllCoupons();
    List<Coupon1> getAllCouponsByCategory(Category category);
    List<Coupon1> getAllCouponsByMaxPrice(double price);
    Company getCompanyDetails(int companyId);
    void setCompanyId(int companyId);
}
