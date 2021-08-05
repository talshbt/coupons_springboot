package com.example.demo.service;

import com.example.demo.repos.CompanyRepository;
import com.example.demo.repos.CouponRepository;
import com.example.demo.repos.CustomerRepository;

public abstract class ClientService {
    protected CouponRepository couponRepository;
    protected CustomerRepository customerRepository;
    protected CompanyRepository companyRepository;

    public abstract boolean login(String email, String password);

}
