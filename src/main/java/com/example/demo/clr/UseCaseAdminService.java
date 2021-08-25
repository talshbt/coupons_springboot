package com.example.demo.clr;

import com.example.demo.beans.Company;
import com.example.demo.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@RequiredArgsConstructor
public class UseCaseAdminService implements CommandLineRunner {
    private final AdminService adminService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello");
        Company comp1 = Company.builder()
                .name("Cola")
                .email("cola@gmail.com")
                .password("1234")
                .build();


        adminService.addCompany(comp1);



    }
}
