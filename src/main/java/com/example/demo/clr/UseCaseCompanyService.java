package com.example.demo.clr;

import com.example.demo.auth.ClientType;
import com.example.demo.auth.LoginManager;
import com.example.demo.beans.Company;
import com.example.demo.repos.CompanyRepository;
import com.example.demo.service.CompanyService;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@RequiredArgsConstructor
public class UseCaseCompanyService implements CommandLineRunner {
    private final LoginManager loginManager;
    private final CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------------CompanyService Test---------------------------------------");
        System.out.println(companyRepository.findAll());
        System.out.println( companyRepository.existsByEmailAndPassword("cola@gmail.com", "1234"));
       ;

        System.out.println( companyRepository.findByEmailAndPassword("cola@gmail.com", "1234").getId());

        CompanyService companyService = (CompanyService) loginManager.login("cola@gmail.com", "1234", ClientType.COMPANY);
//        System.out.println(companyRepository.existsByEmailAndPassword("cola@gmail.com", "1234"));

//        try {
//            CompanyService companyService2 = (CompanyService) loginManager.login("comp4@gmail.com", "1234", ClientType.COMPANY);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        if(companyService != null && companyService2 == null){
//            System.out.println("login test succeeded");
//        }

//        System.out.println(companyService);
//
    }
}
