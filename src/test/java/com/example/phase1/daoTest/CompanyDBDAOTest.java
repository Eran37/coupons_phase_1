package com.example.phase1.daoTest;

import com.example.phase1.beans.Company;
import com.example.phase1.dao.CompanyDAO;
import com.example.phase1.dbdao.CompanyDBDAO;

import java.sql.SQLException;

public class CompanyDBDAOTest {

    public static void main(String[] args) {

        CompanyDAO dao = new CompanyDBDAO();

        //isCompanyExists TEST*************************************************
//        try {
//            if(dao.isCompanyExists("sdfg","sdfg")){
//                System.out.println("yes");
//            }else System.out.println();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //addCompany TEST*******************************************************
        Company company1 = new Company("company2","comp2@gmail.com","comp2");
        try {
            dao.addCompany(company1);
            System.out.println("Company added; " + company1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //updateCompany TEST*******************************************************

//        Company updateForCompany1 = null;
//        try {
//            dao.updateCompany(updateForCompany1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //getOneCompany TEST*******************************************************
//        try {
//            System.out.println(dao.getOneCompany(3));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //getAllCompanies TEST*******************************************************
//        try {
//            System.out.println(dao.getAllCompanies());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //deleteCompanies TEST*******************************************************
//        try {
//            System.out.println(dao.deleteCompany(3));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }

}
