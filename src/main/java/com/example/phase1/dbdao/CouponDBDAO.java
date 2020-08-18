package com.example.phase1.dbdao;

import com.example.phase1.beans.Category;
import com.example.phase1.beans.Coupon;
import com.example.phase1.beans.Purchase;
import com.example.phase1.dao.CouponDAO;
import com.example.phase1.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CouponDBDAO implements CouponDAO {

        ConnectionPool pool = ConnectionPool.getInstance();

    public Coupon addCoupon(Coupon coupon) throws SQLException {
        String sql = "INSERT INTO COUPONS " +
                "(COMPANY_ID, CATEGORY, TITLE, DESCRIPTION, START_DATE, END_DATE, AMOUNT, PRICE, IMAGE)" +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, coupon.getCompanyId());
            stmt.setString(2, String.valueOf(coupon.getCategory()));
            stmt.setString(3, coupon.getTitle());
            stmt.setString(4, coupon.getDescription());
            stmt.setDate(5, coupon.getStartDate());
            stmt.setDate(6, coupon.getEndDate());
            stmt.setInt(7, coupon.getAmount());
            stmt.setDouble(8, coupon.getPrice());
            stmt.setString(9, coupon.getImage());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                coupon.setId(rs.getInt(1));
            // Or rs.getString("ID")
        }
        return coupon;
    }

    public Coupon updateCoupon(Coupon coupon) throws SQLException {
    String sql = "UPDATE COUPONS SET COMPANY_ID=?, CATEGORY=?, TITLE=?, " +
            "DESCRIPTION=?, START_DATE=?, END_DATE=?, AMOUNT=?, PRICE=?, IMAGE=?" +
            "WHERE ID=?";
    Connection con = pool.getConnection();
    try(PreparedStatement stmt = con.prepareStatement(sql)){
        stmt.setInt(1, coupon.getCompanyId());
        stmt.setString(2, String.valueOf(coupon.getCategory()));
        stmt.setString(3, coupon.getTitle());
        stmt.setString(4, coupon.getDescription());
        stmt.setDate(5, coupon.getStartDate());
        stmt.setDate(6, coupon.getEndDate());
        stmt.setInt(7, coupon.getAmount());
        stmt.setDouble(8, coupon.getPrice());
        stmt.setString(9, coupon.getImage());
        stmt.setInt(10, coupon.getId());
        stmt.executeUpdate();
    } finally {
        pool.returnConnection(con);
        } return
                coupon;
    }

    public void deleteCoupon(int couponID) throws SQLException {
        Connection con = pool.getConnection();
        String sql1 = "DELETE FROM CUSTOMERS_VS_COUPONS WHERE COUPON_ID = ?";
        String sql2 = "DELETE FROM COUPONS WHERE ID = ?";

        try(PreparedStatement stmt = con.prepareStatement(sql1)){
            stmt.setInt(1, couponID);
            stmt.executeUpdate();
        }
        try(PreparedStatement stmt = con.prepareStatement(sql2)){
            stmt.setInt(1, couponID);
            stmt.executeUpdate();
        } finally {
            pool.returnConnection(con);
            }
    }

    public Coupon getOneCoupon(int couponID) throws SQLException {
        Coupon coupon = null;
        String sql = "SELECT * FROM COUPONS WHERE ID = ?";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, couponID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                int id = rs.getInt(1);
                int companyId = rs.getInt(2);
                Category category = Category.valueOf(rs.getString(3));
                String title = rs.getString(4);
                String description = rs.getString(5);
                Date startDate = rs.getDate(6);
                Date endDate = rs.getDate(7);
                int amount = rs.getInt(8);
                Double price = rs.getDouble(9);
                String image = rs.getString(10);
                coupon = new Coupon(id,companyId,category,
                        title,description,startDate,endDate
                        ,amount,price,image);
            }
        }
        return coupon;
    }

    public List<Coupon> getAllCoupons() throws SQLException {
        List<Coupon> allCoupons = new ArrayList<>();
        String sql = "SELECT * FROM COUPONS";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                int companyId = rs.getInt(2);
                Category category = Category.valueOf(rs.getString(3));
                String title = rs.getString(4);
                String description = rs.getString(5);
                Date startDate = rs.getDate(6);
                Date endDate = rs.getDate(7);
                int amount = rs.getInt(8);
                Double price = rs.getDouble(9);
                String image = rs.getString(10);
                allCoupons.add(new Coupon(id,companyId,category,
                        title,description,startDate,endDate
                        ,amount,price,image));
            }
        } finally {
            pool.returnConnection(con);
        }

        return allCoupons;
    }

    public void addCouponPurchase(int customerID, int couponID) throws SQLException {
            String sql = "INSERT INTO CUSTOMERS_VS_COUPONS (CUSTOMER_ID, COUPON_ID) VALUES (?,?)";
            Connection con = pool.getConnection();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, customerID);
                stmt.setInt(2, couponID);
                stmt.executeUpdate();
            } finally {
                pool.returnConnection(con);
            }
        }

    public void deleteCouponPurchase(int customerID, int couponID) throws SQLException {
    String sql = "DELETE FROM CUSTOMERS_VS_COUPONS WHERE CUSTOMER_ID = ? AND COUPON_ID = ?";
    Connection con = pool.getConnection();
    try(PreparedStatement stmt = con.prepareStatement(sql)){
        stmt.setInt(1, customerID);
        stmt.setInt(2, couponID);
        stmt.executeUpdate();
    } finally {
        pool.returnConnection(con);
        }
    }

    //*************************************EXTRA-METHODS****************************************
    //A subMethod for adminFacade.deleteCompany;
    public void deletePurchasesByCouponId(int couponId) throws SQLException{
        String sql = "DELETE FROM CUSTOMERS_VS_COUPONS WHERE COUPON_ID = ?";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, couponId);
            stmt.executeUpdate();
        } finally {
            pool.returnConnection(con);
        }
    }

    //A subMethod for adminFacade.deleteCustomer;
    public void deletePurchasesByCustomerId(int customerID) throws SQLException {
        String sql = "DELETE FROM CUSTOMERS_VS_COUPONS WHERE CUSTOMER_ID = ?";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, customerID);
            stmt.executeUpdate();
        } finally {
            pool.returnConnection(con);
        }
    }

    //A subMethod for CustomerFacade.buyCoupon;
    public ArrayList<Purchase> getPurchasesByCustomerId(int customerId) throws SQLException {
        ArrayList<Purchase> customerPurchases = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMERS_VS_COUPONS WHERE CUSTOMER_ID = ? ";
        Connection con = pool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int couponId = rs.getInt(2);
                customerPurchases.add(new Purchase(customerId,couponId));
            }
        } finally {
            pool.returnConnection(con);
        }
        return customerPurchases;
    }

}

