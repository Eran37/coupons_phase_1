package com.example.phase1.dao;
import com.example.phase1.beans.Coupon;

import java.sql.SQLException;
import java.util.List;

public interface CouponDAO {

    Coupon addCoupon(Coupon coupon) throws SQLException;
    Coupon updateCoupon(Coupon coupon) throws SQLException;
    void deleteCoupon(int couponID) throws SQLException;
    Coupon getOneCoupon(int couponID) throws SQLException;
    List<Coupon> getAllCoupons() throws SQLException;
    void addCouponPurchase(int customerID, int couponID) throws SQLException;
    void deleteCouponPurchase(int customerID, int couponID) throws SQLException;

}
