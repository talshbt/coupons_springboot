package com.example.demo.clr;

import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon;
import com.example.demo.beans.Customer;
import com.example.demo.repos.CompanyRepository;
import com.example.demo.repos.CouponRepository;
import com.example.demo.repos.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1)
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CouponRepository couponRepository;
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----clr is running-----");
        // 5 customers
//        Customer customer1 = Customer.builder()
//                .firstName("tal")
//                .lastName("peled")
//                .email("talshbt@gmail.com")
//                .password("0123456")
//                .build();

        // 3 company
//        Coupon coupon1 = Coupon.builder().amount(3).category(Category.Drink).build();

        Company company1 = Company.builder()
                .name("Cola")
                .email("cola@gmail.com")
                .password("1234")
//                .coupon(coupon1)
                .build();
//
//        Company company2 = Company.builder()
//                .name("Matrix")
//                .email("matrix@gmail.com")
//                .password("1234")
//                .build();
//
//

        companyRepository.saveAll(Arrays.asList(company1));

        companyRepository.findAll().forEach(System.out::println);

//        companyRepository.findAll().forEach(System.out::println);
        // 4 coupons
    }
}
