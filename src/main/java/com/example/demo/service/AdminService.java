package com.example.demo.service;

import com.example.demo.beans.Company;
import com.example.demo.beans.Customer;
import com.example.demo.exceptions.CouponSystemException;

import java.util.List;

public interface AdminService {
    void addCompany(Company company) throws CouponSystemException;
    void updateCompany(Company company) throws CouponSystemException;
    void deleteCompany(Company company) throws CouponSystemException;
    List<Company> getAllCompanies();
    Company getSingleCompany(int companyId) throws CouponSystemException;

    void addCustomer(Customer customer) throws CouponSystemException;
    void updateCustomer(Customer customer) throws CouponSystemException;
    void deleteCustomer(Customer customer) throws CouponSystemException;
    List<Customer> getAllCustomers();
    Customer getSingleCustomer(int customerId) throws CouponSystemException;
    void setCustomerId(int companyId);
}
