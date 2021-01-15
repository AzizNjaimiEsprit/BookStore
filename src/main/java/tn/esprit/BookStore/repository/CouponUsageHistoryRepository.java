package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.BookStore.model.CouponUsageHistory;

import java.util.List;

public interface CouponUsageHistoryRepository extends JpaRepository<CouponUsageHistory, Integer> {

    @Query(value = "Select * from coupon_usage_history where coupon_code= :code", nativeQuery = true)
    List<CouponUsageHistory> getHistoryForCoupon(@Param("code") String code);

    @Query(value = "select * from coupon_usage_history where coupon_code= :code AND order_id= :oid AND usage_type= :ut",nativeQuery = true)
    CouponUsageHistory checkIfExist(@Param("code") String code,@Param("oid") int oid,@Param("ut") String ut);

}
