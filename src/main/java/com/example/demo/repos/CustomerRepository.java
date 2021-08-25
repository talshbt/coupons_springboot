package com.example.demo.repos;

import com.example.demo.beans.Category;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    boolean existsFindByName(String name);

    Customer findByEmailAndPassword(String email, String password);

    boolean existsFindByEmail(String email);
   boolean existsFindByEmailAndPassword(String email, String name);

    @Query(value = "SELECT CASE WHEN (COUNT(*) > 0) THEN 'TRUE' ELSE 'FALSE' END\n" +
            " FROM customers_coupons WHERE customer_id = ?1 and coupons_id = ?2", nativeQuery = true)
    Boolean existsPurchaseByCustomerAndCoupon(int customerId, int couponId);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customers_coupons (customer_id, coupons_id) VALUES (?1, ?2)", nativeQuery = true)
    void addCoupon(int customerId, int couponId);

}
