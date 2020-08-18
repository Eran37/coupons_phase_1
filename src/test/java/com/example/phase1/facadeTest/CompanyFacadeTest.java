package com.example.phase1.facadeTest;

import com.example.phase1.beans.Category;
import com.example.phase1.beans.Coupon;
import com.example.phase1.exceptions.CouponIdIsIncorrectException;
import com.example.phase1.exceptions.CouponsCompanyIdIsIncorrectException;
import com.example.phase1.facade.CompanyFacade;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyFacadeTest {

    public static void main(String[] args) {

        CompanyFacade facade = new CompanyFacade();

        //CompanyLogin TEST******************************************************
//        try {
//            System.out.println(facade.login("comp2","123"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //addCoupon TEST**************************************************************
//        facade.addCoupon(new Coupon(6, Category.SPORT, "Olimpiadi",
//                "Get the first tickets to the Olimpiadi", Date.valueOf("2020-01-01"),
//                Date.valueOf("2020-07-01"), 50, 100.00,
//                "a picture of crowd"));

        //updateCoupon TEST***********************************************************
//        try {
//            System.out.println(facade.updateCoupon(new Coupon(6,5, Category.CINEMA, "Long Hair",
//                    "Get the first tickets to the Olimpiadi", Date.valueOf("2020-01-01"),
//                    Date.valueOf("2020-07-01"), 50, 100.00,
//                    "a picture of crowd")));
//        } catch (SQLException | CouponIdIsIncorrectException | CouponsCompanyIdIsIncorrectException e) {
//            e.printStackTrace();
//        }

        //deleteCoupon TEST************************************************************
//        facade.deleteCoupon(6);

        //getAllCoupons TEST***********************************************************
//        for (Coupon coupon: facade.getAllCoupons()
//             ) {
//            System.out.println(coupon);
//        }

        //getCouponsByCategory TEST*****************************************************
//        for (Coupon coupon : facade.getCouponsByCategory(Category.NIGHTLIGHT)
//        ) {
//            System.out.println(coupon);
//        }

        //getCouponsUnderMaxPrice TEST**************************************************
//        for (Coupon coupon : facade.getCouponUnderMaxPrice()
//             ) {
//            System.out.println(coupon);
//        }

        //getCompanyDetails TEST********************************************************
//        System.out.println(facade.getCompanyDetails());
    }
}






