package com.example.demo.clr;

import com.example.demo.beans.Company;
import com.example.demo.repos.CompanyRepository;
import com.example.demo.repos.CouponRepository;
import com.example.demo.repos.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Order(1)
public class UseCaseLogin implements CommandLineRunner {

    private final CouponRepository couponRepository;
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello");


        Company comp1 = Company.builder()
                .name("Cola")
                .email("cola@gmail.com")
                .password("1234")
                .build();

        companyRepository.save(comp1);

        System.out.println("check Cola Login "+ companyRepository.existsFindByEmailAndPassword("cola@gmail.com", "12"));

    }
}
