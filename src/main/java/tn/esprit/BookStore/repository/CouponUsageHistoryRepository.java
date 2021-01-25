package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.BookStore.model.CouponUsageHistory;

import java.util.List;

public interface CouponUsageHistoryRepository extends JpaRepository<CouponUsageHistory, Integer> {


    List<CouponUsageHistory> getCouponUsageHistoryByCouponCode(@Param("code") String code);


    @Query(value = "select cuh from CouponUsageHistory cuh " +
            "where cuh.coupon.code = :code AND cuh.order.id = :oid AND cuh.usageType = :ut")
    CouponUsageHistory checkIfExist(@Param("code") String code, @Param("oid") int oid, @Param("ut") String ut);

}
