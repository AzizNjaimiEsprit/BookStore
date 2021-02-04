package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Coupon;
import tn.esprit.BookStore.model.Offer;
import tn.esprit.BookStore.service.CouponService;

import java.util.List;

@RestController
@RequestMapping("api/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @PostMapping("/add")
    public Coupon addCoupon (@RequestBody Coupon coupon) {return couponService.addCoupon(coupon);}

    @PutMapping("/update")
    public Coupon updateCoupon (@RequestBody Coupon coupon) {return couponService.updateCoupon(coupon);}

    @DeleteMapping("/delete/{code}")
    public void deleteCoupon (@PathVariable String code ) {couponService.deleteCoupon(code);}

    @GetMapping("/get/{code}")
    public Coupon getCoupon (@PathVariable String code) {return couponService.getCoupon(code);}

    @GetMapping("/getAll")
    public List<Coupon> getAllCoupon () {return couponService.getAllCoupons();}

    @GetMapping("/getAll/{userId}")
    public List<Coupon> getAllUserCoupons (@PathVariable long userId) {return couponService.getAllCouponsByUserId(userId);}
}
