package com.example.demo.service;

import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon1;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.exceptions.ErrMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyServiceImp extends ClientService implements CompanyService{
    int companyId;

    @Override
    public boolean login(String email, String password) {
        return companyRepository.existsByEmailAndPassword(email, password);
    }

    @Override
    public int getIdByLoginDetails(String email, String password) throws CouponSystemException {
        return companyRepository.findByEmailAndPassword(email, password).getId();
    }

    @Override
    public void setCompanyId(int companyId) { this.companyId = companyId; }

    @Override
    public void addCoupon(Coupon1 coupon) throws CouponSystemException {
       if(couponRepository.existsByTitleAndCompanyId(coupon.getTitle(),coupon.getCompany().getId())){
           throw new CouponSystemException(ErrMsg.COUPON_COMPANY_TITLE_EXISTS);
       }
       couponRepository.save(coupon);
    }

    @Override
    public void updateCoupon(Coupon1 coupon) throws CouponSystemException {
        couponRepository.findById(coupon.getId()).orElseThrow(()-> new CouponSystemException(ErrMsg.COUPON_ID_NOT_EXIST));
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(Coupon1 coupon) throws CouponSystemException {
        couponRepository.findById(coupon.getId()).orElseThrow(()-> new CouponSystemException(ErrMsg.COUPON_ID_NOT_EXIST));
        couponRepository.delete(coupon);
    }

    @Override
    public List<Coupon1> getCompanyCoupons() { return couponRepository.findAll(); }

    @Override
    public List<Coupon1> getCompanyCoupons(Category category) {
        return couponRepository.findByCompanyIdAndCategory(companyId, category);
    }

    @Override
    public List<Coupon1> getCompanyCoupons(double price) {
        return couponRepository.findByCompanyIdAndPriceLessThan(companyId, price);
    }
    @Override
    public Company getCompanyDetails() throws CouponSystemException {
        return companyRepository.findById(companyId).orElseThrow(()-> new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST));
    }

}
