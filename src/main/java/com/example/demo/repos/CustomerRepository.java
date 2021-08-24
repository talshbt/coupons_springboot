package com.example.demo.repos;

import com.example.demo.beans.Category;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    boolean existsFindByName(String name);
   boolean existsFindByEmail(String email);
   boolean existsFindByEmailAndPassword(String email, String name);

    @Query(value = "SELECT CASE WHEN (COUNT(*) > 0) THEN 'TRUE' ELSE 'FALSE' END\n" +
            " FROM customers_coupons WHERE customer_id = ?1 and coupons_id = ?2", nativeQuery = true)
    Boolean existsPurchaseByCustomerAndCoupon(int customerId, int couponId);



}
