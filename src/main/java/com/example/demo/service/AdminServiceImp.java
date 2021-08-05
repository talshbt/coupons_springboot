package com.example.demo.service;

import com.example.demo.beans.Company;
import com.example.demo.beans.Customer;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.exceptions.ErrMsg;

import java.util.List;

public class AdminServiceImp extends ClientService implements AdminService{

    @Override
    public void addCompany(Company company) {
        boolean isComanyExists = this.companyRepository.existsFindByName(company.getName());
        if(isComanyExists){
//            throw new CouponSystemException(ErrMsg.COMPANY_NAME_EXIST);

        }
        this.companyRepository.save(company);

    }

    @Override
    public void updateCompany(int companyId, Company company) {

    }

    @Override
    public void deleteCompany(int companyId, Company company) {

    }

    @Override
    public List<Company> getAllCompanies() {
        return null;
    }

    @Override
    public Company getSingleCompany(int companyId) {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(int customerId, Customer customer) {

    }

    @Override
    public void deleteCustomer(int customerId, Customer customer) {

    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Customer getSingleCustomer(int customerId) {
        return null;
    }

    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@admin.com")&&password.equals("admin");
    }
}
