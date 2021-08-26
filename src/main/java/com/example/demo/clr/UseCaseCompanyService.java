package com.example.demo.clr;

import com.example.demo.auth.ClientType;
import com.example.demo.auth.LoginManager;
import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon1;
import com.example.demo.repos.CompanyRepository;
import com.example.demo.service.CompanyService;
import com.example.demo.service.CustomerService;
import com.example.demo.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(3)
@RequiredArgsConstructor
public class UseCaseCompanyService implements CommandLineRunner {
    private final LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------------CompanyService Test---------------------------------------");
        CompanyService companyService = (CompanyService) loginManager.login("cola@gmail.com", "1234", ClientType.COMPANY);
        CompanyService companyService3 = (CompanyService) loginManager.login("comp3@gmail.com", "1234", ClientType.COMPANY);

        try {
            CompanyService companyService2 = (CompanyService) loginManager.login("comp4@gmail.com", "1234", ClientType.COMPANY);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("*******add new coupon*****");

        Company comp = companyService.getCompanyDetails();
        Coupon1 coupon1 = Coupon1.builder()
                .company(comp)
                .category(Category.FOOD)
                .title("cou1")
                .description("cou1 sale")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(10)))
                .amount(10)
                .price(2)
                .image("x")
                .build();

        companyService.addCoupon(coupon1);
        Company comp3 = companyService3.getCompanyDetails();
        Coupon1 coupon2 = Coupon1.builder()
                .company(comp3)
                .category(Category.FOOD)
                .title("cou1")
                .description("cou1 sale")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(10)))
                .amount(10)
                .price(2)
                .image("x")
                .build();

        Coupon1 coupon3 = Coupon1.builder()
                .company(comp3)
                .category(Category.FOOD)
                .title("cou3")
                .description("cou1 sale")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(10)))
                .amount(10)
                .price(2)
                .image("x")
                .build();

        System.out.println(Art.INSERT);

        companyService3.addCoupon(coupon3);
        try {
            System.out.println("coupon title already exists");
            companyService3.addCoupon(coupon2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("*******update coupon*****");
        Coupon1 coup1  = companyService3.getCompanyDetails().getCoupons().get(1);
        System.out.println(coup1);
        coup1.setAmount(7);
        System.out.println(Art.UPDATE);

        companyService.updateCoupon(coup1);
        companyService.getCompanyCoupons().forEach(System.out::println);


        System.out.println(Art.DELETE);
        System.out.println("*******delete coupon*****");
        companyService.deleteCoupon(coup1);
        companyService.getCompanyCoupons().forEach(System.out::println);


        Coupon1 coupon4 = Coupon1.builder()
                .company(comp3)
                .category(Category.DRINK)
                .title("cou4")
                .description("cou4 sale")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(10)))
                .amount(10)
                .price(10)
                .image("x")
                .build();

        Coupon1 coupon5 = Coupon1.builder()
                .company(comp3)
                .category(Category.DRINK)
                .title("cou5")
                .description("cou5 sale")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(10)))
                .amount(10)
                .price(2)
                .image("x")
                .build();


        companyService3.addCoupon(coupon4);
        System.out.println("get by Category FOOD");
        companyService3.getCompanyCoupons(Category.FOOD).forEach(System.out::println);

        System.out.println("get by Category Drink");
        companyService3.getCompanyCoupons(Category.DRINK).forEach(System.out::println);

        System.out.println("get by price");
        companyService3.getCompanyCoupons(3).forEach(System.out::println);



    }
}
