package com.example.demo.service;

import com.example.demo.repos.CompanyRepository;
import com.example.demo.repos.CouponRepository;
import com.example.demo.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {
    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected CompanyRepository companyRepository;

    public ClientService(){

    }
    public abstract boolean login(String email, String password);
    public abstract int getIdByLoginDetails(String email, String password);


    public abstract void setCompanyId(int companyId);
}
