package com.example.demo.clr;

import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon1;
import com.example.demo.repos.CompanyRepository;
import com.example.demo.repos.CouponRepository;
import com.example.demo.repos.CustomerRepository;
import com.example.demo.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

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

        Company comp1 = Company.builder()
                .name("Cola")
                .email("cola@gmail.com")
                .password("1234")
                .build();

        companyRepository.save(comp1);
        System.out.println(Art.INSERT);
        couponRepository.findAll().forEach(System.out::println);
        companyRepository.findAll().forEach(System.out::println);

        Coupon1 coupon1 = Coupon1.builder().
                                amount(100).
                                company(companyRepository.getById(1)).
                                category(Category.FOOD).
                description("couponDesc1").
                                title("couponTitle1").
                                image("couponImage1").
                                startDate(Date.valueOf(LocalDate.now())).
                                endDate(Date.valueOf(LocalDate.now().plusDays(5))).
                                build();

        couponRepository.save(coupon1);
        couponRepository.findAll().forEach(System.out::println);

        System.out.println(Art.DELETE);
        System.out.println("count before delete" + couponRepository.count());
        couponRepository.deleteById(1);
        System.out.println("count after delete" + couponRepository.count());

        companyRepository.findAll().forEach(System.out::println);
        couponRepository.findAll().forEach(System.out::println);


    }
}
