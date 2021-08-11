package com.example.demo.auth;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LoginManager {

    @Autowired
    private ApplicationContext ctx;

    public ClientService login(String email, String password, ClientType type) throws SQLException, CouponSystemException {
        switch (type){
            case COMPANY:
                CompanyService companyService = ctx.getBean(CompanyService.class);
                if(((CompanyServiceImp)companyService).login(email, password)){
                    int companyId = ((CompanyServiceImp)companyService).getIdByLoginDetails(email, password);
                    ((CompanyServiceImp)companyService).setCompanyId(companyId);
                    return (ClientService)companyService;
                }
            break;

            case CUSTOMER:
                CustomerService customerService = ctx.getBean(CustomerService.class);
                if(((CustomerServiceImp)customerService).login(email, password)){
                    int customerId = ((CustomerServiceImp)customerService).getIdByLoginDetails(email, password);
                    ((CustomerServiceImp)customerService).setCustomerId(customerId);
                    return (ClientService)customerService;
                }

                break;
            case ADMIN:
                AdminService adminService = ctx.getBean(AdminService.class);
                if(((AdminServiceImp)adminService).login(email, password)){
                    int companyId = ((AdminServiceImp)adminService).getIdByLoginDetails(email, password);
                    ((AdminServiceImp)adminService).setCustomerId(companyId);
                    return (ClientService)adminService;
                }

                break;
        }
        return null;
    }

}
