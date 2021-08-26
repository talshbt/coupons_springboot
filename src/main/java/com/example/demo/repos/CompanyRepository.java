package com.example.demo.repos;

import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    boolean existsFindByName(String name);
    boolean existsFindByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);
    Company findByEmailAndPassword(String email, String password);

}
