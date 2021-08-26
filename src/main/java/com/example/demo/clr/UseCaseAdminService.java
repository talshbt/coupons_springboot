package com.example.demo.clr;

import com.example.demo.auth.ClientType;
import com.example.demo.auth.LoginManager;
import com.example.demo.beans.Category;
import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon1;
import com.example.demo.beans.Customer;
import com.example.demo.repos.CompanyRepository;
import com.example.demo.service.AdminService;
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
public class UseCaseAdminService implements CommandLineRunner {
    private final LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {
        AdminService adminService = (AdminService) loginManager.login("admin@admin.com","admin", ClientType.ADMIN);
        AdminService adminService2 = (AdminService) loginManager.login("admin1@admin.com","admin1", ClientType.ADMIN);

        if(adminService != null && adminService2 == null){
            System.out.println("login test succeeded");
        }

        System.out.println("adminService " + adminService);

        System.out.println("--------------COMPANY TEST---------------");
        System.out.println("before add company");
        adminService.getAllCompanies().forEach(System.out::println);
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
        try {
            System.out.println("insert exist");
            adminService.addCompany(comp1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("after add company");
        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println(Art.UPDATE);
        comp1 =  adminService.getSingleCompany(1);
        comp1.setName("Coca-Cola");
        adminService.updateCompany(comp1);
        adminService.getAllCompanies().forEach(System.out::println);

        try {
            comp1.setId(101);
            adminService.updateCompany(comp1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println(Art.DELETE);
        comp2 =  adminService.getSingleCompany(2);
        adminService.deleteCompany(comp2);
        adminService.getAllCompanies().forEach(System.out::println);


        System.out.println("--------------CUSTOMER TEST---------------");
        System.out.println(adminService.getAllCustomers());


        Coupon1 coupon1 = Coupon1.builder().
                amount(100).
                company(comp1).
                category(Category.FOOD).
                description("couponDesc1").
                title("couponTitle1").
                image("couponImage1").
                startDate(Date.valueOf(LocalDate.now().minusDays(6))).
                endDate(Date.valueOf(LocalDate.now().minusDays(5))).
                build();


        System.out.println(Art.INSERT);
        Customer cus1 = Customer.builder().password("321").firstName("firstName1").lastName("lastName1").email("cus1@gmail.com").build();
        Customer cus2 = Customer.builder().password("321").firstName("firstName2").lastName("lastName2").email("cus2@gmail.com").build();
        adminService.addCustomer(cus1);
        adminService.addCustomer(cus2);
//        System.out.println(adminService.getAllCustomers());
        adminService.getAllCustomers().forEach(System.out::println);

        System.out.println("mail exist");
        Customer cus3 = Customer.builder().password("321").firstName("firstName3").lastName("lastName3").email("cus2@gmail.com").build();

        try {
            adminService.addCustomer(cus3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Art.UPDATE);
        cus1 = adminService.getSingleCustomer(1);
        cus1.setFirstName("f1");
        adminService.updateCustomer(cus1);
        System.out.println(adminService.getSingleCustomer(1));
        adminService.getAllCustomers().forEach(System.out::println);

        System.out.println(Art.DELETE);
        cus2 = adminService.getSingleCustomer(2);
        adminService.deleteCustomer(cus2);
        adminService.getAllCustomers().forEach(System.out::println);

    }
}
