package com.example.demo.service;

import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;
import com.example.demo.exceptions.CouponSystemException;

import java.sql.SQLException;
import java.util.List;

public interface CompanyService {

    void addCoupon(Coupon1 coupon) throws CouponSystemException, SQLException;
    void updateCoupon(Coupon1 coupon) throws CouponSystemException, SQLException;
    void deleteCoupon(Coupon1 coupon) throws CouponSystemException, SQLException;
    List<Coupon1> getCompanyCoupons() throws SQLException;
    List<Coupon1> getCompanyCoupons(Category category) throws SQLException;
    List<Coupon1> getCompanyCoupons(double price)  throws SQLException;
    Company getCompanyDetails() throws CouponSystemException, SQLException;
    void setCompanyId(int companyId);
    int getIdByLoginDetails(String email, String password) throws CouponSystemException, SQLException;
}
