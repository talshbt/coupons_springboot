package com.example.demo.repos;

import com.example.demo.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    boolean existsFindByName(String name);
    boolean existsFindByEmail(String email);
    boolean existsFindByEmailAndPassword(String email, String name);

}
