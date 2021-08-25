package com.example.demo.repos;

import com.example.demo.beans.Category;
import com.example.demo.beans.Coupon1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon1, Integer> {
    List<Coupon1> findByCompanyId(int companyId);
//    List<Coupon1> findByCustomerIdAndCategory(int customerId, Category category);
    List<Coupon1> findByCompanyIdAndCategory(int companyId, Category category);
    List<Coupon1> findByCompanyIdAndPriceLessThan(int companyId, double maxPrice);
    List<Coupon1> findByEndDateBefore(Date expiryDate);
    boolean existsByTitleAndCompanyId(String title, int companyId);

    @Query(value = "SELECT * FROM coupons1 CO WHERE CO.id in (SELECT coupons_id FROM customers_coupons where customer_id = ?1)", nativeQuery = true)
    List<Coupon1> findCustomerCoupons(int customerId);

    @Query(value = "SELECT * FROM coupons1 where category = ?2 and id in (SELECT coupons_id FROM customers_coupons WHERE customer_id = ?1) ", nativeQuery = true)
    List<Coupon1>  findCustomerCouponsByCategory(int customerId, int categoryId);

    @Query(value = "SELECT * FROM coupons1 where price < ?2 and id in (SELECT coupons_id FROM customers_coupons WHERE customer_id = ?1) ", nativeQuery = true)
    List<Coupon1>  findCustomerCouponsByMaxPrice(int customerId, double maxPrice);
    @Transactional
    void deleteByEndDateBefore(Date expiryDate);

}
