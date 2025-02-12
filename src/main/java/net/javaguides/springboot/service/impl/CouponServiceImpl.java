package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.entity.Coupon;
import net.javaguides.springboot.repository.CouponRepository;
import net.javaguides.springboot.service.CouponService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    // Constructor for dependency injection
    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon getCouponById(Long couponId) {
        Optional<Coupon> optionalCoupon = couponRepository.findById(couponId);
        return optionalCoupon.orElse(null); // Return null if coupon is not found
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        Optional<Coupon> existingCouponOptional = couponRepository.findById(coupon.getCouponId());
        if (existingCouponOptional.isPresent()) {
            Coupon existingCoupon = existingCouponOptional.get();
            existingCoupon.setCouponCode(coupon.getCouponCode());
            existingCoupon.setDiscountType(coupon.getDiscountType());
            existingCoupon.setDiscount(coupon.getDiscount());
            existingCoupon.setExpiryDate(coupon.getExpiryDate());
            existingCoupon.setUsageLimit(coupon.getUsageLimit());
            return couponRepository.save(existingCoupon);
        }
        return null; // Return null if coupon is not found
    }

    @Override
    public void deleteCoupon(Long couponId) {
        couponRepository.deleteById(couponId);
    }
}
