package com.example.demo.clr;

import com.example.demo.beans.Company;
import com.example.demo.repos.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@RequiredArgsConstructor
public class UseCaseCompany  implements CommandLineRunner {
    private final CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {
        Company comp1 = Company.builder()
                .name("Cola")
                .email("cola@gmail.com")
                .password("1234")
                .build();

        companyRepository.save(comp1);
        System.out.println(companyRepository.findByEmailAndPassword("cola@gmail.com", "1234"));


    }
}
