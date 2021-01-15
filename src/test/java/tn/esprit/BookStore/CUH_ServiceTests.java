package tn.esprit.BookStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.BookStore.model.Coupon;
import tn.esprit.BookStore.model.CouponUsageHistory;
import tn.esprit.BookStore.model.Order;
import tn.esprit.BookStore.service.CouponUsageHistoryService;
import tn.esprit.BookStore.service.OrderItemService;

@SpringBootTest
public class CUH_ServiceTests {
    @Autowired
    CouponUsageHistoryService cuhService;

    @Test
    void contextLoads() {
        System.out.println("****** Test Get History For Coupon *********");
        System.out.println(cuhService.getHistoryForCoupon("A1B2C3D4"));
        System.out.println(cuhService.getHistoryForCoupon("14785236"));
        System.out.println("****** Add  History For Coupon *************");
        Coupon coupon = new Coupon("14785236");
        Order order = new Order(2);
        CouponUsageHistory cuh = new CouponUsageHistory(0,coupon,order,"REFUND");
        System.out.println(cuhService.add(cuh));
    }
}
