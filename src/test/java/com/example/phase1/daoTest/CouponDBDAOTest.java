package com.example.phase1.daoTest;

import com.example.phase1.beans.Category;
import com.example.phase1.beans.Coupon;
import com.example.phase1.dbdao.CouponDBDAO;

import java.sql.Date;
import java.sql.SQLException;

public class CouponDBDAOTest {
    public static void main(String[] args) {
        CouponDBDAO dao = new CouponDBDAO();

        //addCoupon TEST****************************************************8
//        try {
//            System.out.println(dao.addCoupon(
//                    new Coupon(1, Category.NIGHTLIGHT, "good nightlife",
//                            "Best Laptop ever", Date.valueOf("2019-03-11"),
//                            Date.valueOf("2020-03-11"),50,100.00,
//                            "picture of chess pub")));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //ANOTHER addCoupon;
//        try {
//            System.out.println(dao.addCoupon(
//                    new Coupon(5, Category.CINEMA, "fourth",
//                            " ", Date.valueOf("2020-02-10"),
//                            Date.valueOf("2020-07-15"), 50, 100.00,
//                            " ")));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //updateCoupon TEST****************************************************
//        try {
//            System.out.println(dao.updateCoupon(
//                    new Coupon(7,7, Category.ELECTRICITY,
//                            "Mahshev Al-Hakefak",
//                            "Best Laptop ever", Date.valueOf("2019-03-11"),
//                            Date.valueOf("2020-11-11"),50,100.00,
//                            "picture of a MacBook")
//            ));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //deleteCoupon TEST****************************************************
//        try {
//            dao.deleteCoupon(1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //getOneCoupon TEST****************************************************
//        try {
//            System.out.println(dao.getOneCoupon(3));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //getAllCoupons TEST**************************************************
//        try {
//            for (Coupon coupon: dao.getAllCoupons()
//                 ) {
//                System.out.println(coupon);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //addCouponPurchase TEST*********************************************
        try {
            dao.addCouponPurchase(2,12);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //deleteCouponPurchase TEST*********************************************
//        try {
//            dao.deleteCouponPurchase(1,1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }


    }





