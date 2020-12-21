package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.BookStore.model.CouponUsageHistory;

public interface CouponUsageHistoryRepository extends JpaRepository<CouponUsageHistory,Integer> {

    @Query(value = "Select * from COUPON_USAGE_HISTORY where coupon_code= :code",nativeQuery = true)
    CouponUsageHistory getHistoryForCoupon(@Param("code") String code);
}
