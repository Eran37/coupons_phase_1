package com.example.phase1.dbdao;

import com.example.phase1.beans.Company;
import com.example.phase1.dao.CompanyDAO;
import com.example.phase1.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDBDAO implements CompanyDAO {

    private ConnectionPool pool = ConnectionPool.getInstance();


    public boolean isCompanyExists(String email, String password) throws SQLException{
        String sql = "SELECT EMAIL, PASSWORD FROM COMPANIES";
        Connection con = pool.getConnection();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("PASSWORD").equals(password)
                        &&
                        rs.getString("EMAIL").toLowerCase().equals(email.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }finally {
            pool.returnConnection(con);
        }
    }

    public Company addCompany(Company company) throws SQLException {
        String sql = "INSERT INTO COMPANIES (NAME, EMAIL, PASSWORD) VALUES (?,?,?)";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, company.getName());
            stmt.setString(2, company.getEmail());
            stmt.setString(3, company.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                company.setId(rs.getInt(1));
        } finally {
            pool.returnConnection(con);
        }
        return company;
    }

    public Company updateCompany(Company company) throws SQLException {
        if (company == null)
            return null;
        String sql = "UPDATE COMPANIES SET EMAIL=?, PASSWORD=? WHERE ID=?";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, company.getEmail());
            stmt.setString(2, company.getPassword());
            stmt.setInt(3, company.getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                company.setId(rs.getInt(1));
        } finally {
            pool.returnConnection(con);
        }
        return company;
    }

    public Company deleteCompany(int companyID) throws SQLException {
        Company company = getOneCompany(companyID);
        if (company == null)
            return null;
        String sql = "DELETE FROM COMPANIES WHERE ID = ?";
        Connection con = pool.getConnection();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setInt(1,companyID);
        stmt.executeUpdate();
        } finally {
            pool.returnConnection(con);
        }
        return company;

    }

    public List<Company> getAllCompanies() throws SQLException {
        List<Company> allCompanies = new ArrayList<>();
        String sql = "SELECT * FROM COMPANIES";
        Connection con = pool.getConnection();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                Company company = new Company(id, name, email, password);
                allCompanies.add(company);
            }
            return allCompanies;
        } finally {
            pool.returnConnection(con);
        }
    }

    public Company getOneCompany(int companyID) throws SQLException {
        Company company = null;
        String sql = "SELECT * FROM COMPANIES WHERE ID = ?";
        Connection con = pool.getConnection();
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, companyID);
            ResultSet rs =stmt.executeQuery();
            if (rs.next()){
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                company = new Company(id,name,email,password);
            }
        } finally {
            pool.returnConnection(con);
        }
        return company;
    }

    //******************************EXTRA-METHODS*******************************
    //TODO - add exception;
    public boolean nameOrEmailAlreadyExists(String name, String email) {
        String sql = "SELECT NAME, EMAIL FROM COMPANIES";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql)){
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            if (name.toLowerCase().equals(rs.getString("NAME")) ||
                    email.toLowerCase().equals(rs.getString("EMAIL"))) {
                return true;
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.returnConnection(con);
        }
        return false;
    }

    public boolean nameAndIdOK(String name, int companyId) {
        String sql = "SELECT NAME, ID FROM COMPANIES";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (name.toLowerCase().equals(rs.getString("NAME")) &&
                        companyId == rs.getInt("ID")) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.returnConnection(con);
        }
        return false;
    }

    //for companyLogin;
    public Company getCompanyByEmailAndPassword(String companyEmail, String companyPassword) throws SQLException {
        Company company = null;
        String sql = "SELECT * FROM COMPANIES WHERE EMAIL = ? AND PASSWORD = ?";
        Connection con = pool.getConnection();
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, companyEmail);
            stmt.setString(2, companyPassword);
            ResultSet rs =stmt.executeQuery();
            if (rs.next()){
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                company = new Company(id,name,email,password);
            }
        } finally {
            pool.returnConnection(con);
        }
        return company;
    }


}
