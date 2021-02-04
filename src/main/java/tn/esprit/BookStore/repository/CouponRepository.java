package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Coupon;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, String> {
    List<Coupon> findAllByUserId (long userId);
}
