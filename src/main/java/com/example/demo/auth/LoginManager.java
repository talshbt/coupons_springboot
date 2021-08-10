package com.example.demo.auth;
import com.example.demo.service.ClientService;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class LoginManager {

    @Autowired
    private ApplicationContext ctx;
    ClientService clientService = null;

    public ClientService login(String email, String password, ClientType type){
        switch (type){
            case COMPANY:
                CompanyService companyService = ctx.getBean(CompanyService.class);
                clientService = (ClientService)companyService;
                if(clientService.login(email, password)){
                    int companyId = companyService.getCompanyDetails(email, password);
                }

        }
        return  null;
    }

}
