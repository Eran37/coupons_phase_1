//package com.example.phase1.test;
//
//import com.example.phase1.beans.Category;
//import com.example.phase1.beans.Company;
//import com.example.phase1.beans.Coupon;
//import com.example.phase1.beans.Customer;
//import com.example.phase1.exceptions.*;
//import com.example.phase1.facade.AdminFacade;
//import com.example.phase1.facade.Client;
//import com.example.phase1.facade.CompanyFacade;
//import com.example.phase1.facade.CustomerFacade;
//import com.example.phase1.login.ClientType;
//import com.example.phase1.login.LoginManager;
//import com.example.phase1.threads.Job;
//
//import java.sql.Date;
//import java.sql.SQLException;
//
//public class Test {
//    public static void testAll() throws SQLException, EmailOrPasswordIsIncorrectException,
//            CouponIdIsIncorrectException, CouponsCompanyIdIsIncorrectException {
//
////        activating daily job;
//        Job job = new Job();
//        job.start();
//
//        try {
//            adminTest();
////            companyTest();
////            customerTest();
//        } catch (SQLException | NameOrEmailAlreadyExistsException | CannotUpdateNameOrIdException |
//                NoCompanyWithThisIdOnDataBase | NoCompanyWithThisIdToDeleteException | EmailOrPasswordIsIncorrectException e) {
//            e.printStackTrace();
//        }
//
//        job.StopThread();
//    }
////********************************************************TESTING AdminFacade************************************************************************
//
//    private static void adminTest() throws SQLException, NameOrEmailAlreadyExistsException,
//            CannotUpdateNameOrIdException, NoCompanyWithThisIdOnDataBase,
//            NoCompanyWithThisIdToDeleteException, EmailOrPasswordIsIncorrectException {
//        //LoginManager.getInstance();
//        LoginManager loginManager = LoginManager.getInstance();
//        //get the AdminFacade
//        AdminFacade adminFacade = (AdminFacade) loginManager.Login(
//                "admin@admin.com","admin", ClientType.Administrator);
//
////********************************************************TESTING AdminFacade METHODS************************************************************************
//        //1.addCompany;
//        adminFacade.addCompany(new Company("company1","company1@gmail.com","123"));
//        adminFacade.addCompany(new Company("company2","company2@gmail.com","123"));
//        adminFacade.addCompany(new Company("company3","company3@gmail.com","123"));
//        adminFacade.addCompany(new Company("company4","company4@gmail.com","123"));
//        adminFacade.addCompany(new Company("company5","company5@gmail.com","123"));
////        2.updateCompany;
//        Company company1 = adminFacade.getCompanyById(11);
//        company1.setEmail("updatedEmail1");
//        adminFacade.updateCompany(company1);
//        Company company2 = adminFacade.getCompanyById(12);
//        company2.setEmail("updatedEmail2");
//        adminFacade.updateCompany(company2);
////        3.deleteCompany;
//        adminFacade.deleteCompany(12);
////        4.getOneCompany;
//        System.out.println(adminFacade.getCompanyById(11));
////        5. getAllCompanies;
//        for (Company company : adminFacade.getAllCompanies()
//             ) {
//            System.out.println(company);
//        }
////        6.addCustomer;
//        adminFacade.addCustomer(new Customer("customer","1","customer1@gmail.com","123"));
//        adminFacade.addCustomer(new Customer("customer","2","customer2@gmail.com","123"));
//        adminFacade.addCustomer(new Customer("customer","3","customer3@gmail.com","123"));
//        adminFacade.addCustomer(new Customer("customer","4","customer4@gmail.com","123"));
//        adminFacade.addCustomer(new Customer("customer","5","customer5@gmail.com","123"));
////        7.updateCustomer;
//        Customer customer1 = adminFacade.getCustomerById(11);
//        customer1.setEmail("updatedEmail1");
//        adminFacade.updateCustomer(customer1);
//        Customer customer2 = adminFacade.getCustomerById(12);
//        customer2.setEmail("updatedEmail2");
//        adminFacade.updateCustomer(customer2);
////        8.deleteCustomer;
//        adminFacade.deleteCustomer(12);
////        9.getCustomerById;
//        System.out.println(adminFacade.getCustomerById(11));
////        10.getAllCustomers;
//        for (Customer customer : adminFacade.getAllCustomers()
//             ) {
//            System.out.println(customer);
//        }
//    }
//
//    //********************************************************TESTING CompanyFacade METHODS************************************************************************
//
//    private static void companyTest() throws SQLException, EmailOrPasswordIsIncorrectException,
//            CouponIdIsIncorrectException, CouponsCompanyIdIsIncorrectException, CouponIsOutOfStockException,
//            ThisCouponIsExpiredException, CannotBuyThisCouponAgainException {
//        //LoginManager.getInstance();
//        LoginManager loginManager = LoginManager.getInstance();
//        //get the CompanyFacade
//        CompanyFacade companyFacade = (CompanyFacade) loginManager.Login(
//                "updatedEmail1", "123", ClientType.Company);
//
//        //********************************************************TESTING CompanyFacade METHODS************************************************************************
//        System.out.println("CompanyDetails: " + companyFacade.getCompanyDetails());
//        //1.addCoupon();
//        companyFacade.addCoupon(new Coupon(11, Category.SPORT, "SOCCER-GAME2", "In England", Date.valueOf("2020-08-18")
//                , Date.valueOf("2020-08-29"), 15000, 250.00, "Picture of Euroleague"));
//        companyFacade.addCoupon(new Coupon(11, Category.RESTAURANT, "GORME-SHMAGORME2", "Eyal Shani Hafaltsan", Date.valueOf("2020-08-18")
//                , Date.valueOf("2020-10-29"), 40, 400.00, "Picture of Eyal Shani"));
//        companyFacade.addCoupon(new Coupon(11, Category.CINEMA, "MARVEL-NEW MOVIE2", "Spiderman is a grandpa", Date.valueOf("2020-08-18")
//                , Date.valueOf("2021-04-15"), 130, 70.00, "Picture of Spiderman with grand-childrens"));
//        companyFacade.addCoupon(new Coupon(11, Category.LIFESTYLE, "THE-NEW-LIVING-ROOM2", "Natuzi", Date.valueOf("2020-08-18")
//                , Date.valueOf("2022-04-25"), 500, 16000.00, "Picture of a sofa"));
//        //2.updateCoupon();
//        companyFacade.updateCoupon(new Coupon(19, 11, Category.SPORT, "UPDATED", "In England", Date.valueOf("2020-08-18")
//                , Date.valueOf("2020-08-29"), 15000, 250.00, "Picture of Euroleague"));
//        companyFacade.updateCoupon(new Coupon(20, 11, Category.RESTAURANT, "UPDATED", "Eyal Shani Hafaltsan", Date.valueOf("2020-08-18")
//                , Date.valueOf("2020-10-29"), 40, 400.00, "Picture of Eyal Shani"));
//        companyFacade.updateCoupon(new Coupon(21, 11, Category.CINEMA, "UPDATED", "Spiderman is a grandpa", Date.valueOf("2020-08-18")
//                , Date.valueOf("2021-04-15"), 130, 70.00, "Picture of Spiderman with grand-childrens"));
//        companyFacade.updateCoupon(new Coupon(22, 11, Category.LIFESTYLE, "UPDATED", "Natuzi", Date.valueOf("2020-08-18")
//                , Date.valueOf("2022-04-25"), 500, 16000.00, "Picture of a sofa"));
//        //3.deleteCoupon();
//        companyFacade.deleteCoupon(22);
//        //4.getOneCoupon();
//        for (Coupon coupon : companyFacade.getCouponsByCategory(Category.SPORT)
//        ) {
//            System.out.println(coupon);
//        }
//        //5.getCouponsUnderMaxPrice();
//        for (Coupon coupon : companyFacade.getCouponUnderMaxPrice(300)
//        ) {
//            System.out.println(coupon);
//        }
//        //6.getAllCoupons();
//        for (Coupon coupon : companyFacade.getAllCoupons()
//        ) {
//            System.out.println(coupon);
//        }
//        //7.getCompanyDetails();
//        System.out.println(companyFacade.getCompanyDetails());
//
////    }
//
//        //********************************************************TESTING CustomerFacade METHODS************************************************************************
//
//        private static void customerTest () throws SQLException, EmailOrPasswordIsIncorrectException,
//                CouponIsOutOfStockException, ThisCouponIsExpiredException, CannotBuyThisCouponAgainException {
//            //LoginManager.getInstance();
////            LoginManager loginManager = LoginManager.getInstance();
//            //get the CustomerFacade
//            CustomerFacade customerFacade = (CustomerFacade) loginManager.Login("customer1@gmail.com", "123", ClientType.Customer);
//
//            //********************************************************TESTING CustomerFacade METHODS************************************************************************
//
//            //1.buyCoupon();
//            customerFacade.buyCoupon(18);
//            //2.customerCoupons();
//            for (Coupon coupon : customerFacade.customerCoupons()
//            ) {
//                System.out.println(coupon);
//            }
//            //3.customerCouponsByCategory();
//            for (Coupon coupon : customerFacade.customerCouponsByCategory(Category.SPORT)
//            ) {
//                System.out.println(coupon);
//            }
//            //4.customerCouponsUnderMaxPrice();
//            for (Coupon coupon : customerFacade.customerCouponsUnderMaxPrice(400)
//            ) {
//                System.out.println(coupon);
//            }
//            //5.getDetails();
//            System.out.println(customerFacade.getDetails());
//
//        }
//
//
//    }
//}
