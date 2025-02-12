package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Coupon;
import java.util.List;

public interface CouponService {

    // Create a new coupon
    Coupon createCoupon(Coupon coupon);

    // Get a coupon by its ID
    Coupon getCouponById(Long couponId);

    // Get all coupons
    List<Coupon> getAllCoupons();

    // Update an existing coupon
    Coupon updateCoupon(Coupon coupon);

    // Delete a coupon by its ID
    void deleteCoupon(Long couponId);
}