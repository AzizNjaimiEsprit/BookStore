package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Coupon;
import tn.esprit.BookStore.model.CouponCodeGenerator;
import tn.esprit.BookStore.repository.CouponRepository;

import java.util.List;

@Service
public class ImpCouponService implements CouponService{
    private static CouponCodeGenerator couponCodeGenerator;

    @Autowired
    private SMS_Service sms;

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public Coupon addCoupon(Coupon coupon) {
        while (true) {
            String code = couponCodeGenerator.generateCode();
            if (!couponRepository.existsById(code)) {
                coupon.setCode(code);
                Coupon generatedCoupon = couponRepository.save(coupon);
                if (generatedCoupon != null) {
                    sms.sendCouponSMS(generatedCoupon.getUser(), generatedCoupon);
                    return generatedCoupon;
                }
            }
        }
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public void deleteCoupon(String code) {
        couponRepository.delete(couponRepository.getOne(code));
    }

    @Override
    public Coupon getCoupon(String code) {
        return couponRepository.getOne(code);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public List<Coupon> getAllCouponsByUserId(long userId) {
        return couponRepository.findAllByUserId(userId);
    }
}
