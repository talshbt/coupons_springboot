package com.example.demo.service;

import com.example.demo.beans.Category;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;

import java.util.List;

public class CustomerServiceImp extends ClientService implements CustomerService{

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public void purchaseCoupon(int couponId) {

    }

    @Override
    public List<Coupon1> getAllCustomerCoupons(int customerId) {
        return null;
    }

    @Override
    public List<Coupon1> getAllCustomerCouponsByCategory(int customerId, Category category) {
        return null;
    }

    @Override
    public List<Coupon1> getAllCustomerCouponsByPrice(int customerId, double price) {
        return null;
    }

    @Override
    public Customer getCustomerDetails(int customerId) {
        return null;
    }
}
