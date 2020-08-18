package com.example.phase1.threads;

import com.example.phase1.beans.Coupon;
import com.example.phase1.dbdao.CouponDBDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import static java.lang.Thread.sleep;

public class Job extends Thread{

    CouponDBDAO couponDB = new CouponDBDAO();
    private Boolean quit = false;

    @Override
    public void run() {
        while (!quit) try {
            ArrayList<Coupon> coupons = (ArrayList<Coupon>) couponDB.getAllCoupons();
            Calendar calendar = Calendar.getInstance();

            synchronized (coupons) {
                for (Coupon coupon : coupons
                ) {
                    if (calendar.getTimeInMillis() > coupon.getEndDate().getTime()) {
                        couponDB.deletePurchasesByCouponId(coupon.getId());
                        couponDB.deleteCoupon(coupon.getId());
                    }
                }
            }
            try {
                sleep(1000*60*60*24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void StopThread() {
        quit = true;
        interrupt();
    }
}
