package com.example.demo.clr;

import com.example.demo.auth.ClientType;
import com.example.demo.auth.LoginManager;
import com.example.demo.service.CompanyService;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
@RequiredArgsConstructor
public class UseCaseCustomerService implements CommandLineRunner {

    private final LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("---------------------CustomerService Test---------------------------------------");
        CustomerService customerService = (CustomerService) loginManager.login("cus1@gmail.com", "321", ClientType.CUSTOMER);


    }
}
