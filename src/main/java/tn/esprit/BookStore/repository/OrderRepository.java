package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM orders  where user_id = :user_id", nativeQuery = true)
    List<Order> findAllByUser(@Param("user_id") Integer user_id);

    @Query(value = "SELECT * FROM orders  where status = :status", nativeQuery = true)
    List<Order> findAllByStatus(@Param("status") String status);

    @Modifying
    @Query(value = "UPDATE orders set status = :status where id = :id", nativeQuery = true)
    void updateStatus(@Param("status") String status, @Param("id") Integer id);
}
