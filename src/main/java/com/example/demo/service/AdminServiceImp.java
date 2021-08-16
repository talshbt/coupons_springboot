package com.example.demo.service;

import com.example.demo.beans.Company;
import com.example.demo.beans.Customer;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.exceptions.ErrMsg;

import java.util.List;

public class AdminServiceImp extends ClientService implements AdminService{
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    private int companyId;
    @Override
    public void addCompany(Company company) throws CouponSystemException {

        if(this.companyRepository.existsFindByName(company.getName())){
           throw new CouponSystemException(ErrMsg.COMPANY_NAME_EXIST);
        }

        if(this.companyRepository.existsFindByEmail(company.getEmail())){
            throw new CouponSystemException(ErrMsg.COMPANY_EMAIL_EXIST);
        }
        this.companyRepository.save(company);
    }

    @Override
    public void updateCompany(Company company) throws CouponSystemException {
        companyRepository.findById(company.getId()).orElseThrow(()-> new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST));
        companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(Company company) throws CouponSystemException {
        companyRepository.findById(company.getId()).orElseThrow(()-> new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST));
        companyRepository.delete(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(int companyId) throws CouponSystemException {
        companyRepository.findById(companyId).orElseThrow(()-> new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST));
        return companyRepository.findById(companyId).get();
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException {
        if(this.customerRepository.existsFindByEmail(customer.getEmail())){
            throw new CouponSystemException(ErrMsg.CUSTOMER_EMAIL_EXIST);
        }
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws CouponSystemException {
        customerRepository.findById(customer.getId()).orElseThrow(()-> new CouponSystemException(ErrMsg.CUSTOMER_ID_NOT_EXIST));
        customerRepository.saveAndFlush(customer);
    }


    @Override
    public void deleteCustomer(Customer customer) throws CouponSystemException {
        customerRepository.findById(customer.getId()).orElseThrow(()-> new CouponSystemException(ErrMsg.CUSTOMER_ID_NOT_EXIST));
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(int customerId) {
        return null;
    }

    @Override
    public void setCustomerId(int companyId) {

    }

    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@admin.com") && password.equals("admin");
    }




}
