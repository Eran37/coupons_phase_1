package com.example.phase1.facade;

import com.example.phase1.beans.Category;
import com.example.phase1.beans.Company;
import com.example.phase1.beans.Coupon;
import com.example.phase1.exceptions.CouponIdIsIncorrectException;
import com.example.phase1.exceptions.CouponsCompanyIdIsIncorrectException;
import com.example.phase1.exceptions.TheCompanyAlreadyHaveACouponWithThisTitleException;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyFacade extends Client {

    private int companyId;

    public boolean login(String email, String password) throws SQLException {
        if (companyDAO.isCompanyExists(email,password)) {
            companyId = companyDAO.getCompanyByEmailAndPassword(email, password).getId();
            return true;
        }
        return false;
    }

    public Coupon addCoupon(Coupon coupon) {
        try {
            ArrayList<Coupon> allCoupons = (ArrayList<Coupon>) couponDAO.getAllCoupons();
            for (Coupon coup : allCoupons
                 ) {
                if (coupon.getCompanyId() == coup.getCompanyId() &&
                        coupon.getTitle().toLowerCase().equals
                                (coup.getTitle().toLowerCase()))
                    throw new TheCompanyAlreadyHaveACouponWithThisTitleException();
                }
            if (coupon.getCompanyId() == companyId)
                couponDAO.addCoupon(coupon);
        } catch (SQLException | TheCompanyAlreadyHaveACouponWithThisTitleException e) {
            e.printStackTrace();
        }
        return coupon;
    }

    public void updateCoupon(Coupon coupon) throws SQLException, CouponIdIsIncorrectException, CouponsCompanyIdIsIncorrectException {
        if (coupon.getCompanyId() == companyId) {
            if (couponDAO.getOneCoupon(coupon.getId()).getId() == coupon.getId()) {
                couponDAO.updateCoupon(coupon);
            } else
                throw new CouponIdIsIncorrectException();
        } else
            throw new CouponsCompanyIdIsIncorrectException();
    }

    public Coupon deleteCoupon(int couponId) {
        Coupon coupon = null;
        try {
            coupon = couponDAO.getOneCoupon(couponId);
            couponDAO.deletePurchasesByCouponId(couponId);
            couponDAO.deleteCoupon(couponId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coupon;
    }

    public ArrayList<Coupon> getAllCoupons () {
        ArrayList<Coupon>allCoupons = new ArrayList<>();
        try {
            for (Coupon coupon : couponDAO.getAllCoupons()
                 ) {
                if (coupon.getCompanyId() == companyId)
                    allCoupons.add(coupon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCoupons;
    }

    public ArrayList<Coupon>getCouponsByCategory(Category category) {
        ArrayList<Coupon>couponsByCategory = new ArrayList<>();
        try {
            for (Coupon coupon : couponDAO.getAllCoupons()
            ) {
                if (coupon.getCategory().equals(category) && coupon.getCompanyId() == companyId)
                    couponsByCategory.add(coupon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return couponsByCategory;
    }

    public ArrayList<Coupon> getCouponUnderMaxPrice (int maxPrice) {
        ArrayList<Coupon>couponsUnderMaxPrice = new ArrayList<>();
        try {
            for (Coupon coupon : couponDAO.getAllCoupons()
            ) {
                if (coupon.getPrice() < maxPrice)
                    couponsUnderMaxPrice.add(coupon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return couponsUnderMaxPrice;
    }

    public Company getCompanyDetails() {
        Company company = null;
        try {
            company = companyDAO.getOneCompany(companyId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }
}
