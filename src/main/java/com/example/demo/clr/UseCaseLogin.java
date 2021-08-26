package com.example.demo.clr;

import com.example.demo.beans.Company;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.exceptions.ErrMsg;
import com.example.demo.repos.CompanyRepository;
import com.example.demo.repos.CouponRepository;
import com.example.demo.repos.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;


//@Component
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
        Company company = companyRepository.findById(1).orElseThrow(()-> new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST));
        System.out.println("check Cola Login "+ companyRepository.existsByEmailAndPassword("cola@gmail.com", "12"));
        System.out.println("company"+ company);


    }
}
