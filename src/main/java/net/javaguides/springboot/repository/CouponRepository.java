package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}