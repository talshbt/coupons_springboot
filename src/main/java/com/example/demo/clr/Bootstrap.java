package com.example.demo.clr;

import com.example.demo.repos.CompanyRepository;
import com.example.demo.repos.CouponRepository;
import com.example.demo.repos.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CouponRepository;
    private final CompanyRepository;
    private final CustomerRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----clr is running-----");
        // 5 customers
        // 3 company
        // 4 coupons
    }
}
