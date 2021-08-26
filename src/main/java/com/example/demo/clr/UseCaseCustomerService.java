package com.example.demo.clr;

import com.example.demo.auth.ClientType;
import com.example.demo.auth.LoginManager;
import com.example.demo.beans.Category;
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
        customerService.purchaseCoupon(1);
        customerService.purchaseCoupon(6);
        customerService.purchaseCoupon(7);

        customerService.getCustomerCoupons().forEach(System.out::println);

        CustomerService customerService2 = (CustomerService) loginManager.login("cus2@gmail.com", "321", ClientType.CUSTOMER);

        try {
            System.out.println("try more then once");
            customerService2.purchaseCoupon(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("try expired");
            customerService.purchaseCoupon(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("amount 0");
            customerService.purchaseCoupon(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        customerService.getCustomerCoupons().forEach(System.out::println);

        System.out.println("customer coupons by category food");
        customerService.getCustomerCoupons(Category.FOOD).forEach(System.out::println);
        System.out.println("customer coupons by category drink");
        customerService.getCustomerCoupons(Category.DRINK).forEach(System.out::println);
        System.out.println("customer coupons with price less then 9");
        customerService.getCustomerCoupons(9).forEach(System.out::println);
    }


}
