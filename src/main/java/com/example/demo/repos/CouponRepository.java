package com.example.demo.repos;

import com.example.demo.beans.Category;
import com.example.demo.beans.Coupon1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon1, Integer> {
    List<Coupon1> findByCompanyId(int companyId);
    List<Coupon1> findByCompanyIdAndCategory(int companyId, Category category);
    List<Coupon1> findByCompanyIdAndPriceLessThan(int companyId, double maxPrice);
    List<Coupon1> findByEndDateBefore(Date expiryDate);


    @Transactional
    void deleteByEndDateBefore(Date expiryDate);

}
