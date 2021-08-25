package com.example.demo.service;

import com.example.demo.beans.Category;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.exceptions.ErrMsg;

import java.sql.Date;
import java.time.LocalDate;
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
        return customerRepository.findByEmailAndPassword(email, password).getId();
    }

    @Override
    public void purchaseCoupon(int couponId) throws CouponSystemException {
        Coupon1 coupon = couponRepository.findById(couponId).orElseThrow(()-> new CouponSystemException(ErrMsg.COUPON_ID_NOT_EXIST));
        int couponAmount = coupon.getAmount();
        if (customerRepository.existsPurchaseByCustomerAndCoupon(customerId, couponId)) {
            throw new CouponSystemException(ErrMsg.COUPON_ALREADY_PURCHASED);
        }
        if (couponAmount == 0){
            throw new CouponSystemException(ErrMsg.COUPON_OUT_OF_STOCK);
        }

        if(coupon.getEndDate().before(Date.valueOf(LocalDate.now()))){
            throw new CouponSystemException(ErrMsg.COUPON_EXPIRED);
        }

        coupon.setAmount(couponAmount - 1);
        couponRepository.saveAndFlush(coupon);
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new CouponSystemException(ErrMsg.CUSTOMER_ID_NOT_EXIST));
        customerRepository.addCoupon(customerId, couponId);
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public List<Coupon1> getCustomerCoupons(int customerId) throws CouponSystemException {
        customerRepository.findById(customerId).orElseThrow(()-> new CouponSystemException(ErrMsg.CUSTOMER_ID_NOT_EXIST));
        return couponRepository.findCustomerCoupons(customerId);
    }

    @Override
    public List<Coupon1> getCustomerCoupons(int customerId, Category category) {
        return couponRepository.findCustomerCouponsByCategory(customerId, category.ordinal());
    }

    @Override
    public List<Coupon1> getCustomerCoupons(int customerId, double price) {
        return couponRepository.findCustomerCouponsByMaxPrice(customerId, price);
    }

    @Override
    public Customer getCustomerDetails(int customerId) throws CouponSystemException {
        return customerRepository.findById(customerId).orElseThrow(() -> new CouponSystemException(ErrMsg.CUSTOMER_ID_NOT_EXIST));
    }
}
