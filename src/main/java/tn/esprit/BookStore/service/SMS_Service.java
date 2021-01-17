package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Coupon;
import tn.esprit.BookStore.model.User;

public interface SMS_Service {
    boolean SendDeclineSMS(User user);
    public boolean SendSMSCouponGenerated(Coupon coupon);
}
