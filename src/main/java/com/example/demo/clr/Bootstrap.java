package com.example.demo.clr;

import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon;
import com.example.demo.beans.Customer;
import com.example.demo.repos.CompanyRepository;
import com.example.demo.repos.CouponRepository;
import com.example.demo.repos.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1)
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----clr is running-----");

        Company comp1 = Company.builder()
                .name("Cola")
                .email("cola@gmail.com")
                .password("1234")
                .build();

        Company comp2 = Company.builder()
                .name("Elit")
                .email("elit@gmail.com")
                .password("1234")
                .build();

        companyRepository.saveAll(Arrays.asList(
                comp1,
                comp2
        ));


        Customer cust1 = Customer.builder()
                .email("talshbt1@gmail.com")
                .password("1234")
                .firstName("tal1")
                .lastName("peled1")
                .build();

        Customer cust2 = Customer.builder()
                .email("talshbt2@gmail.com")
                .password("1234")
                .firstName("tal2")
                .lastName("peled2")
                .build();

        Customer cust3 = Customer.builder()
                .email("talshbt3@gmail.com")
                .password("1234")
                .firstName("tal3")
                .lastName("peled3")
                .build();


        customerRepository.saveAll(Arrays.asList(cust1, cust2, cust3));
        customerRepository.findAll().forEach(u -> {
            System.out.println("user :" + u.getEmail());
        });
    }
}
