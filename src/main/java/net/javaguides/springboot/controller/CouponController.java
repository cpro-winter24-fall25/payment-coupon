package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.Coupon;
import net.javaguides.springboot.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coupons")  // Base URL: http://localhost:8080/api/coupons
public class CouponController {

    private final CouponService couponService;

    // Constructor for dependency injection
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    // Create a new Coupon
    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon){
        Coupon savedCoupon = couponService.createCoupon(coupon);
        return new ResponseEntity<>(savedCoupon, HttpStatus.CREATED);
    }

    // Get Coupon by ID
    // Example: http://localhost:8080/api/coupons/1
    @GetMapping("{id}")
    public ResponseEntity<Coupon> getCouponById(@PathVariable("id") Long couponId){
        Coupon coupon = couponService.getCouponById(couponId);
        return new ResponseEntity<>(coupon, HttpStatus.OK);
    }

    // Get All Coupons
    @GetMapping
    public ResponseEntity<List<Coupon>> getAllCoupons(){
        List<Coupon> coupons = couponService.getAllCoupons();
        return new ResponseEntity<>(coupons, HttpStatus.OK);
    }

    // Update Coupon by ID
    // Example: http://localhost:8080/api/coupons/1
    @PutMapping("{id}")
    public ResponseEntity<Coupon> updateCoupon(@PathVariable("id") Long couponId,
                                               @RequestBody Coupon coupon){
        coupon.setCouponId(couponId);
        Coupon updatedCoupon = couponService.updateCoupon(coupon);
        return new ResponseEntity<>(updatedCoupon, HttpStatus.OK);
    }

    // Delete Coupon by ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCoupon(@PathVariable("id") Long couponId){
        couponService.deleteCoupon(couponId);
        return new ResponseEntity<>("Coupon successfully deleted!", HttpStatus.OK);
    }
}