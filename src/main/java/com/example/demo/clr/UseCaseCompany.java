package com.example.demo.clr;

import com.example.demo.beans.Company;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.exceptions.ErrMsg;
import com.example.demo.repos.CompanyRepository;
import com.example.demo.repos.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(1)
@RequiredArgsConstructor
public class UseCaseCompany  implements CommandLineRunner {
    private final CompanyRepository companyRepository;
    private final CouponRepository couponRepository;

    @Override
    public void run(String... args) throws Exception {
        Company comp1 = Company.builder()
                .name("Cola")
                .email("cola@gmail.com")
                .password("1234")
                .build();

        companyRepository.save(comp1);
        System.out.println(companyRepository.findByEmailAndPassword("cola@gmail.com", "1234"));
        Company company = companyRepository.findById(1).orElseThrow(()-> new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST));
        System.out.println("company"+ company);


    }
}
