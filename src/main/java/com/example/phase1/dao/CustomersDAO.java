package com.example.phase1.dao;
import com.example.phase1.beans.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomersDAO {

    boolean isCustomerExists(String email, String password) throws SQLException;
    void addCustomer(Customer customer) throws SQLException;
    Customer updateCustomer(Customer customer) throws SQLException;
    void deleteCustomer(int customerID) throws SQLException;
    List<Customer> getAllCustomers() throws SQLException;
    Customer getOneCustomer(int customerID) throws SQLException;

}
