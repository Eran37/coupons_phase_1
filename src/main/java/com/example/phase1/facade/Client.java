package com.example.phase1.facade;

import com.example.phase1.dbdao.CompanyDBDAO;
import com.example.phase1.dbdao.CouponDBDAO;
import com.example.phase1.dbdao.CustomerDBDAO;

import java.sql.SQLException;

public abstract class Client {

    CompanyDBDAO companyDAO = new CompanyDBDAO();
    CustomerDBDAO customerDAO = new CustomerDBDAO();
    CouponDBDAO couponDAO = new CouponDBDAO();

    public abstract boolean login(String email, String password) throws SQLException;

}
