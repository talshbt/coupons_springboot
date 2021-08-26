package com.example.demo.clr;

import com.example.demo.beans.Company;
import com.example.demo.repos.CompanyRepository;
import com.example.demo.service.AdminService;
import com.example.demo.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@RequiredArgsConstructor
public class UseCaseAdminService implements CommandLineRunner {
    private final AdminService adminService;
    private final CompanyRepository companyRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("before add company");
        System.out.println(adminService.getAllCompanies());
        Company comp1 = Company.builder()
                .name("Cola")
                .email("cola@gmail.com")
                .password("1234")
                .build();

        Company comp2 = Company.builder()
                .name("COMP2")
                .email("comp2@gmail.com")
                .password("1234")
                .build();

        Company comp3 = Company.builder()
                .name("COMP3")
                .email("comp3@gmail.com")
                .password("1234")
                .build();

        System.out.println(Art.INSERT);
        adminService.addCompany(comp1);
        adminService.addCompany(comp2);
        adminService.addCompany(comp3);

        System.out.println("after add company");
        System.out.println(adminService.getAllCompanies());

        System.out.println(Art.UPDATE);
        comp1 =  adminService.getSingleCompany(1);
        comp1.setName("Coca-Cola");
        adminService.updateCompany(comp1);
        System.out.println(adminService.getAllCompanies());

        System.out.println(Art.DELETE);
        comp2 =  adminService.getSingleCompany(2);
        adminService.deleteCompany(comp2);
        System.out.println(adminService.getAllCompanies());

    }
}
