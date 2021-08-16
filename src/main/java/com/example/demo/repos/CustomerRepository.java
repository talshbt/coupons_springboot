package com.example.demo.repos;

import com.example.demo.beans.Category;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    boolean existsFindByName(String name);
    boolean existsFindByEmail(String email);
//    boolean existsByEmailAndPassword(String email, String name);


}
