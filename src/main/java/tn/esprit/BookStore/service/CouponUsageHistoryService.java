package tn.esprit.BookStore.service;

import org.springframework.http.ResponseEntity;
import tn.esprit.BookStore.model.CouponUsageHistory;

import java.util.List;

public interface CouponUsageHistoryService {
    boolean add(CouponUsageHistory cuh);

    List<CouponUsageHistory> getHistoryForCoupon(String code);
}
