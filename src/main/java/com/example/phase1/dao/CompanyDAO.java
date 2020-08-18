package com.example.phase1.dao;
import com.example.phase1.beans.Company;

import java.sql.SQLException;
import java.util.List;

public interface CompanyDAO {

    boolean isCompanyExists(String email, String password) throws SQLException;
    Company addCompany(Company company) throws SQLException;
    Company updateCompany(Company company) throws SQLException;
    Company deleteCompany(int companyID) throws SQLException;
    List<Company> getAllCompanies() throws SQLException;
    Company getOneCompany(int companyID) throws SQLException;

}
