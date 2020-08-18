package com.example.phase1.daoTest;

import com.example.phase1.beans.Customer;
import com.example.phase1.dbdao.CustomerDBDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDBDAOTest {
    public static void main(String[] args) {
        CustomerDBDAO dao = new CustomerDBDAO();



        //addCustomer TEST***********************************************
//        try {
//            dao.addCustomer(new Customer("customer5","customer","customer5@gmail.com","123"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        //IsCustomerExists TEST******************************************
//        try {
//            System.out.println(dao.isCustomerExists("comp1@gmail.com","123"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //updateCustomer TEST******************************************
//        Customer customer = new Customer(2,"customer1.5","1.5customer",
//                "customer1.5@gmail.com","123");
//        try {
//            System.out.println(dao.updateCustomer(customer));
//            System.out.println("customer updated successfully");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //deleteCustomer TEST******************************************
//        try {
//            dao.deleteCustomer(4);
//            System.out.println("customer with the ID you were insert deleted, check in DB");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //getAllCustomers TEST********************************************
//        try {
//            for (Customer customer : dao.getAllCustomers()) {
//                System.out.println(customer);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //getOneCustomer TEST**********************************************
//        try {
//            System.out.println(dao.getOneCustomer(1));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }






}
