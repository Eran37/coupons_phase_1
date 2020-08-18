package com.example.phase1.beans;

public class Purchase {
    private int customerId;
    private int couponId;

    public Purchase(int customerId, int couponId) {
        this.customerId = customerId;
        this.couponId = couponId;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "customerId=" + customerId +
                ", couponId=" + couponId +
                '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }
}
