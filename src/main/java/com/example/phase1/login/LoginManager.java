package com.example.phase1.login;
import com.example.phase1.exceptions.EmailOrPasswordIsIncorrectException;
import com.example.phase1.facade.*;

import java.sql.SQLException;

public class LoginManager {

    private static LoginManager instance;

    //getInstance of LoginManager -> A must-have method for a singleton!!!
    public static LoginManager getInstance() {
        if (instance == null)
            instance = new LoginManager();
        return instance;
    }
    //The general login method();
    public Client Login(String email, String password, ClientType clientType) throws SQLException, EmailOrPasswordIsIncorrectException {
        if (clientType.equals(ClientType.Administrator)) {
            AdminFacade admin = new AdminFacade();
            if (admin.login(email,password))
                return admin;
        }else if (clientType.equals(ClientType.Company)) {
            CompanyFacade company = new CompanyFacade();
            if (company.login(email,password))
                return company;
        }else if (clientType.equals(ClientType.Customer)) {
            CustomerFacade customer = new CustomerFacade();
            if (customer.login(email,password))
                return customer;
        } else
        throw new EmailOrPasswordIsIncorrectException();
        return null;
        }
    }


