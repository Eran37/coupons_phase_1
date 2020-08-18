package com.example.phase1.dbdao;

import com.example.phase1.beans.Customer;
import com.example.phase1.dao.CustomersDAO;
import com.example.phase1.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBDAO implements CustomersDAO {

    private ConnectionPool pool = ConnectionPool.getInstance();

    public boolean isCustomerExists(String email, String password) throws SQLException {
        String sql = "SELECT EMAIL, PASSWORD FROM CUSTOMERS";
        Connection con = pool.getConnection();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (email.toLowerCase().equals(rs.getString("EMAIL").toLowerCase())
                        && password.toLowerCase().equals(rs.getString("PASSWORD").toLowerCase())) ;
                return true;
            }
            return false;
        } finally {
            pool.returnConnection(con);
        }
    }

    public void addCustomer(Customer customer) throws SQLException {
    String sql = "INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES (?,?,?,?)";
    Connection con = pool.getConnection();
    try(PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, customer.getFirstName());
        stmt.setString(2, customer.getLastName());
        stmt.setString(3, customer.getEmail());
        stmt.setString(4, customer.getPassword());
        stmt.executeUpdate();
        } finally {
        pool.returnConnection(con);
    }
    }

    public Customer updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE CUSTOMERS SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PASSWORD = ? WHERE ID = ?";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPassword());
            stmt.setInt(5, customer.getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                customer.setId(rs.getInt(1));
        } finally {
            pool.returnConnection(con);
        }return customer;

    }

    public void deleteCustomer(int customerID) throws SQLException {
        Connection con = pool.getConnection();
        String sql1 = "DELETE FROM CUSTOMERS_VS_COUPONS WHERE CUSTOMER_ID = ?";
        String sql2 = "DELETE FROM CUSTOMERS WHERE ID = ?";

        try(PreparedStatement stmt = con.prepareStatement(sql1)) {
            stmt.setInt(1, customerID);
            stmt.executeUpdate();
        }
        try(PreparedStatement stmt = con.prepareStatement(sql2)) {
            stmt.setInt(1, customerID);
            stmt.executeUpdate();
        } finally {
            pool.returnConnection(con);
        }
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> allCustomers = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMERS";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                allCustomers.add(new Customer(id,firstName,lastName,email,password));
            }
        } finally {
            pool.returnConnection(con);
        }
        return allCustomers;
    }

    public Customer getOneCustomer(int customerID) throws SQLException {
        Customer customer = null;
        String sql = "SELECT * FROM CUSTOMERS WHERE ID = ?";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, customerID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String firatName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                customer = new Customer(id,firatName,lastName,email,password);
            }
        } finally {
            pool.returnConnection(con);
        }
        return customer;
    }


    //***********************************EXTRA-METHODS*********************************
    //For AdminFacade.addCustomer();
    public boolean isEmailExists(String email) throws SQLException {
        String sql = "SELECT EMAIL FROM CUSTOMERS";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
               if (email.toLowerCase().equals(rs.getString(1).toLowerCase()))
                   return true;
            }
        }
        return false;
    }

    //for updateCustomer;
    public boolean isExistsById(int customerId) throws SQLException {
        String sql = "SELECT ID FROM CUSTOMERS";
        Connection con = pool.getConnection();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                if (customerId == rs.getInt(1))
                    return true;
            }
            return false;
        } finally {
            pool.returnConnection(con);
        }
    }

    //for companyLogin;
    public Customer getCustomerByEmailAndPassword(String customerEmail, String customerPassword) throws SQLException {
        Customer customer = null;
        String sql = "SELECT * FROM CUSTOMERS WHERE EMAIL = ? AND PASSWORD = ?";
        Connection con = pool.getConnection();
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, customerEmail);
            stmt.setString(2, customerPassword);
            ResultSet rs =stmt.executeQuery();
            if (rs.next()){
                int id = rs.getInt("ID");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                customer = new Customer(id,firstName,lastName,email,password);
            }
        } finally {
            pool.returnConnection(con);
        }
        return customer;
    }


}

