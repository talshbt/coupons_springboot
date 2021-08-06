package com.example.demo.service;

import com.example.demo.beans.Company;
import com.example.demo.beans.Customer;
import com.example.demo.exceptions.CouponSystemException;

import java.util.List;

public interface AdminService {
    void addCompany(Company company) throws CouponSystemException;
    void updateCompany(int companyId, Company company);
    void deleteCompany(int companyId, Company company);
    List<Company> getAllCompanies();
    Company getSingleCompany(int companyId);

    void addCustomer(Customer customer);
    void updateCustomer(int customerId, Customer customer);
    void deleteCustomer(int customerId, Customer customer);
    List<Customer> getAllCustomers();
    Customer getSingleCustomer(int customerId);

}
