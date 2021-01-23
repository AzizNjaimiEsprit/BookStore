package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Coupon;

import java.util.List;

public interface CouponService {
    Coupon addCoupon (Coupon coupon);
    Coupon updateCoupon (Coupon coupon);
    void deleteCoupon (String code);
    Coupon getCoupon (String code);
    List<Coupon> getAllCoupons ();
    List<Coupon> getAllCouponsByUserId (long userId);
}
