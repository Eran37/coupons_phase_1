package com.example.phase1.facadeTest;

import com.example.phase1.beans.Company;
import com.example.phase1.beans.Customer;
import com.example.phase1.dbdao.CompanyDBDAO;
import com.example.phase1.dbdao.CouponDBDAO;
import com.example.phase1.exceptions.CannotUpdateNameOrIdException;
import com.example.phase1.exceptions.NameOrEmailAlreadyExistsException;
import com.example.phase1.exceptions.NoCompanyWithThisIdToDeleteException;
import com.example.phase1.facade.AdminFacade;

import java.sql.SQLException;

public class AdminFacadeTest {
    public static void main(String[] args) {
        CompanyDBDAO companyDAO = new CompanyDBDAO();
        CouponDBDAO couponDAO = new CouponDBDAO();
        AdminFacade facade = new AdminFacade();

        //adminLogin TEST******************************************************
//        System.out.println(facade.login("admin@admin.com","admin"));

        //nameOrEmailAlreadyExists TEST****************************************
//        System.out.println(companyDAO.nameOrEmailAlreadyExists("company3", "comp3@gmail.com"));

        //addCompany TEST******************************************************
//        try {
//            facade.addCompany(new Company("company3","comp3@gmail.com","123"));
//        } catch (SQLException | AlreadyExistsException e) {
//            e.printStackTrace();
//        }

        //nameAndIdOK TEST*****************************************************
//        System.out.println(companyDAO.nameAndIdOK("company3", 6));

        //addCompany TEST******************************************************
//        Company company = new Company("company4", "company4@gmail.com","123");
//        try {
//            facade.addCompany(company);
//        } catch (SQLException | NameOrEmailAlreadyExistsException e) {
//            e.printStackTrace();
//        }

        //updateCompany TEST****************************************************
//        Company company = new Company(7,"company5", "updated@gmail.com","321");
//        try {
//            facade.updateCompany(company);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (CannotUpdateNameOrIdException e) {
//            e.printStackTrace();
//        }

        //deleteCompany TEST*******************************************************
//        try {
//            facade.deleteCompany(1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (NoCompanyWithThisIdToDeleteException e) {
//            e.printStackTrace();
//        }

        //getAllCompanies TEST******************************************************
//        for (Company company:facade.getAllCompanies()
//             ) {
//            System.out.println(company);
//        }

        //getCompanyById TEST*******************************************************
//        System.out.println(facade.getCompanyById(5));

        //addCustomer TEST**********************************************************
//        facade.addCustomer(new Customer("customer11","11customer","customer11@gmail.com","123"));

        //updateCustomer TEST******************************************************
//        facade.updateCustomer(new Customer(8,"customer13","13customer",
//                "customer@gmail.com","123"));

        //deleteCustomer TEST******************************************************
//        facade.deleteCustomer(7);

        //getAllCustomers TEST******************************************************
//        for (Customer customer: facade.getAllCustomers()
//             ) {
//            System.out.println(customer);
//        }

        //getCustomerById TEST******************************************************
//        System.out.println(facade.getCustomerById(1));



    }




}
