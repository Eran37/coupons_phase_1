package com.example.phase1.facadeTest;

import com.example.phase1.beans.Category;
import com.example.phase1.beans.Coupon;
import com.example.phase1.beans.Customer;
import com.example.phase1.dbdao.CustomerDBDAO;
import com.example.phase1.exceptions.CannotBuyThisCouponAgainException;
import com.example.phase1.exceptions.CouponIsOutOfStockException;
import com.example.phase1.exceptions.ThisCouponIsExpiredException;
import com.example.phase1.facade.Client;
import com.example.phase1.facade.CustomerFacade;

import java.sql.Date;
import java.sql.SQLException;

public class CustomerFacadeTest {
    public static void main(String[] args) {

        CustomerDBDAO customerDAO = new CustomerDBDAO();
        CustomerFacade facade = new CustomerFacade();


        //login TEST*************************************************************************


        //buyCoupon TEST*********************************************************************
//        facade.buyCoupon(7);
//        try {
//            facade.buyCoupon(7);
//        } catch (SQLException | CannotBuyThisCouponAgainException |
//                CouponIsOutOfStockException | ThisCouponIsExpiredException e) {
//            e.printStackTrace();
//        }

        //customerCoupons TEST***************************************************************
//        for (Coupon coupon : facade.customerCoupons(2)
//             ) {
//            System.out.println(coupon);
//        }

        //customerCouponsByCategory TEST*****************************************************
//        for (Coupon coupon : facade.customerCouponsByCategory(Category.CINEMA)
//             ) {
//            System.out.println(coupon);
//        }

        //customerCouponsUnderMAX_PRICE TEST*************************************************
//        for (Coupon coupon : facade.customerCouponsUnderMaxPrice(100)
//             ) {
//            System.out.println(coupon);
//        }

        //getDetails TEST********************************************************************
//        System.out.println(facade.getDetails());


    }
}
