package com.example.demo.repos;

import com.example.demo.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    boolean existsFindByName(String name);
//    boolean existsFindByEmail(String email);
//    boolean existsByEmailAndPassword(String email, String name);
}
