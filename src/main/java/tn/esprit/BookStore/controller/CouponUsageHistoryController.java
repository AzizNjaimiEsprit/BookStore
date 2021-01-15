package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.BookStore.model.CouponUsageHistory;
import tn.esprit.BookStore.model.Response;
import tn.esprit.BookStore.service.CouponUsageHistoryService;

import java.util.List;

@RestController
@RequestMapping("api/cuh")
public class CouponUsageHistoryController {
    @Autowired
    CouponUsageHistoryService cuhService;

    @GetMapping("/getCouponHistory/{code}")
    public ResponseEntity getCouponHistory(@PathVariable String code) {
        try {
            List<CouponUsageHistory> cuh = cuhService.getHistoryForCoupon(code);
            if (cuh == null)
                throw new Exception();
            return Response.getResponseEntity("true", cuh);
        } catch (Exception ex) {
            return Response.getResponseEntity("false");
        }
    }
}
