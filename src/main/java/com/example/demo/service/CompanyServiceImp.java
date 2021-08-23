package com.example.demo.service;

import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon1;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.exceptions.ErrMsg;

import java.util.List;

public class CompanyServiceImp extends ClientService implements CompanyService{
    int companyId;

    @Override
    public boolean login(String email, String password) {
        return companyRepository.existsFindByEmailAndPassword(email, password);
    }

    @Override
    public int getIdByLoginDetails(String email, String password) throws CouponSystemException {
        if(companyRepository.existsFindByEmailAndPassword(email, password)){
            throw new CouponSystemException(ErrMsg.COMPANY_DOES_NOT_EXIST);
        }

        return companyRepository.findByEmailAndPassword(email, password).getId();
    }

    @Override
    public void setCompanyId(int companyId) { this.companyId = companyId; }

    @Override
    public void addCoupon(Coupon1 coupon) throws CouponSystemException {
       if(couponRepository.existsByTitleAndCompanyId(coupon.getTitle(),coupon.getId())){
           throw new CouponSystemException(ErrMsg.COUPON_COMPANY_TITLE_EXISTS);

       }
       Company company = companyRepository.findById(companyId).orElseThrow(()-> new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST));
       coupon.setCompany(company);
       couponRepository.save(coupon);

    }

    @Override
    public void updateCoupon(Coupon1 coupon) throws CouponSystemException {
        Company company = companyRepository.findById(companyId).orElseThrow(()-> new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST));

    }

    @Override
    public void deleteCoupon(Coupon1 coupon) {

    }

    @Override
    public List<Coupon1> getAllCoupons() {
        return null;
    }

    @Override
    public List<Coupon1> getAllCouponsByCategory(Category category) {
        return null;
    }

    @Override
    public List<Coupon1> getAllCouponsByMaxPrice(double price) {
        return null;
    }

    @Override
    public Company getCompanyDetails(int companyId) throws CouponSystemException {
        return companyRepository.findById(companyId).orElseThrow(()-> new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST));
    }



}
