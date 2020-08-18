package com.example.phase1.facade;

import com.example.phase1.beans.Company;
import com.example.phase1.beans.Coupon;
import com.example.phase1.beans.Customer;
import com.example.phase1.exceptions.*;
import com.example.phase1.pool.ConnectionPool;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminFacade extends Client {
    ConnectionPool pool = ConnectionPool.getInstance();
    //**************************ADMIN-LOGIN****************************

    public boolean login(String email, String password) {
        return email.equals("admin@admin.com") && password.equals("admin");
    }

    //**************************ADMIN-FACADE*****************************
    public Company addCompany(Company company) throws SQLException, NameOrEmailAlreadyExistsException {
        if (!companyDAO.nameOrEmailAlreadyExists(company.getName(),company.getEmail()))
        companyDAO.addCompany(company);
        else
            throw new NameOrEmailAlreadyExistsException();
        return company;
    }

    public Company updateCompany(Company company) throws SQLException, CannotUpdateNameOrIdException {
        if (companyDAO.nameAndIdOK(company.getName(),company.getId()))
            companyDAO.updateCompany(company);
        else throw new CannotUpdateNameOrIdException();
        return company;
    }

    public void deleteCompany(int companyId) throws SQLException, NoCompanyWithThisIdToDeleteException {
        //Check if company exists;
        if (companyDAO.getOneCompany(companyId) == null)
            throw new NoCompanyWithThisIdToDeleteException();
        //Delete company coupons and coupons purchases first;
        ArrayList<Coupon> allCoupons = (ArrayList<Coupon>) couponDAO.getAllCoupons();
        for (Coupon coupon: allCoupons
             ) {
            if (coupon.getCompanyId() == companyId) {
                couponDAO.deletePurchasesByCouponId(coupon.getId());
                couponDAO.deleteCoupon(coupon.getId());
            }
        }
        companyDAO.deleteCompany(companyId);
    }

    public List<Company> getAllCompanies(){
        List<Company>allCompanies = new ArrayList<>();
        try {
            allCompanies = companyDAO.getAllCompanies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCompanies;
    }

    public Company getCompanyById(int companyId) throws NoCompanyWithThisIdOnDataBase {
        Company company = null;
        try {
            company = companyDAO.getOneCompany(companyId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (company == null)
            throw new NoCompanyWithThisIdOnDataBase();
        return company;
    }

    public Customer addCustomer(Customer customer) {
        try {
            if (customerDAO.isEmailExists(customer.getEmail()))
                throw new EmailAlreadyExistsException();
                else {
                customerDAO.addCustomer(customer);
            }
        } catch (SQLException | EmailAlreadyExistsException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public Customer updateCustomer(Customer customer) {
        try {
            if (customerDAO.isExistsById(customer.getId())) {
                customerDAO.updateCustomer(customer);
                return customer;
            } else
                throw new CannotUpdateIdOfCustomer();
        } catch (SQLException | CannotUpdateIdOfCustomer e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void deleteCustomer(int customerId) {
        try {
            if (customerDAO.isExistsById(customerId)) {
                couponDAO.deletePurchasesByCustomerId(customerId);
                customerDAO.deleteCustomer(customerId);
            } else
                throw new CustomerNotExistsException();
        } catch (SQLException | CustomerNotExistsException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers () {
        List<Customer> allCustomers = null;
        try {
            allCustomers = customerDAO.getAllCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }

    public Customer getCustomerById(int customerId) {
        Customer customer = null;
        try {
            customer = customerDAO.getOneCustomer(customerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

}



