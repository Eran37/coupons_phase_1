package com.example.phase1.facade;

import com.example.phase1.beans.Category;
import com.example.phase1.beans.Coupon;
import com.example.phase1.beans.Customer;
import com.example.phase1.beans.Purchase;
import com.example.phase1.exceptions.CannotBuyThisCouponAgainException;
import com.example.phase1.exceptions.CouponIsOutOfStockException;
import com.example.phase1.exceptions.ThisCouponIsExpiredException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class
CustomerFacade extends Client {

    private int customerId;

    public boolean login(String email, String password) throws SQLException {
        if (customerDAO.isCustomerExists(email, password)) {
            customerId = customerDAO.getCustomerByEmailAndPassword(email, password).getId();
            return true;
        }
            return false;
    }

    public void buyCoupon(int couponId) throws CannotBuyThisCouponAgainException,
            CouponIsOutOfStockException, ThisCouponIsExpiredException, SQLException {
    //Variables for method;
            Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            Coupon coupon = couponDAO.getOneCoupon(couponId);
            ArrayList<Purchase> myPurchases = couponDAO.getPurchasesByCustomerId(customerId);
    //Check if purchase is possible;
            for (Purchase purchase : myPurchases) {
                if (purchase.getCouponId() == coupon.getId()) {
                    throw new CannotBuyThisCouponAgainException();  }
                if (coupon.getAmount() == 0) {
                    throw new CouponIsOutOfStockException();    }
                if (coupon.getEndDate().before(now)) {
                    throw new ThisCouponIsExpiredException();   }   }
    //Adding the purchase && Updating coupon's amount in DB;
            couponDAO.addCouponPurchase(customerId,couponId);
            coupon.setAmount(coupon.getAmount() -1);
            couponDAO.updateCoupon(coupon);
        }

    public ArrayList<Coupon> customerCoupons() {
        ArrayList<Coupon> customerCoupons = new ArrayList<>();
        try {
            for (Purchase purchase : couponDAO.getPurchasesByCustomerId(customerId)
                 ) {
                if (purchase.getCustomerId() == customerId)
                    customerCoupons.add(couponDAO.getOneCoupon(purchase.getCouponId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerCoupons;
    }

    public ArrayList<Coupon> customerCouponsByCategory(Category category) {
        ArrayList<Coupon> CouponsByCategory = new ArrayList<>();
        try {
            for (Purchase purchase : couponDAO.getPurchasesByCustomerId(customerId)
                 ) {
                if (couponDAO.getOneCoupon(purchase.getCouponId()).getCategory() == category)
                CouponsByCategory.add(couponDAO.getOneCoupon(purchase.getCouponId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CouponsByCategory;
    }

    public ArrayList<Coupon> customerCouponsUnderMaxPrice(int maxPrice) {
        ArrayList<Coupon> CouponsByCategory = new ArrayList<>();
        try {
            for (Purchase purchase : couponDAO.getPurchasesByCustomerId(customerId)
                 ) {
                if (couponDAO.getOneCoupon(purchase.getCouponId()).getPrice() <= maxPrice)
                CouponsByCategory.add(couponDAO.getOneCoupon(purchase.getCouponId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CouponsByCategory;
    }

    public Customer getDetails () {
        Customer customer = null;
        try {
            customer = customerDAO.getOneCustomer(customerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }








}




