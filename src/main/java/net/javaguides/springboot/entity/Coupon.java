package net.javaguides.springboot.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    @Column(nullable = false, unique = true)
    private String couponCode;

    @Column(nullable = false)
    private String discountType;

    @Column(nullable = false)
    private double discount;  // ✅ Changed from Double to primitive double

    @Column(nullable = false)
    private Date expiryDate;

    @Column(nullable = false)
    private int usageLimit;  // ✅ Changed Integer to primitive int

    // No-argument constructor
    public Coupon() {
    }

    // All-argument constructor
    public Coupon(Long couponId, String couponCode, String discountType, double discount, Date expiryDate, int usageLimit) {
        this.couponId = couponId;
        this.couponCode = couponCode;
        this.discountType = discountType;
        this.discount = discount;
        this.expiryDate = expiryDate;
        this.usageLimit = usageLimit;
    }

    // Getters and setters
    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getUsageLimit() {
        return usageLimit;
    }

    public void setUsageLimit(int usageLimit) {
        this.usageLimit = usageLimit;
    }
}