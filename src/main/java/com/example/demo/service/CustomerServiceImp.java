package com.example.demo.service;

import com.example.demo.beans.Category;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.exceptions.ErrMsg;

import java.util.List;

public class CustomerServiceImp extends ClientService implements CustomerService{
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    int customerId;
    @Override
    public boolean login(String email, String password) {
        return customerRepository.existsFindByEmailAndPassword(email, password);
    }

    @Override
    public int getIdByLoginDetails(String email, String password) {
        return 0;
    }

    @Override
    public void purchaseCoupon(int couponId) throws CouponSystemException {
        Coupon1 coup = couponRepository.findById(couponId).orElseThrow(()-> new CouponSystemException(ErrMsg.COUPON_ID_NOT_EXIST));



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
