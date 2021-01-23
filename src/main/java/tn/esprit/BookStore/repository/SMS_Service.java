package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Coupon;
import tn.esprit.BookStore.model.User;

public interface SMS_Service {
    public boolean SendDeclineSMS(User user);
    public boolean sendCouponSMS(User user, Coupon coupon);
}
