package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.OrderItem;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    @Query(value = "SELECT * FROM order_item  where order_id = :id", nativeQuery = true)
    List<OrderItem> findAllByOrder(@Param("id") Integer id);

    @Query(value = "select MAX(nbP) ,name from (select SUM(oi.quantity)  nbP , oi.book_id , b.title as name " +
            "from order_item oi JOIN book b on oi.book_id = b.id " +
            "group by oi.book_id order by nbP DESC) tab",nativeQuery = true)
    List<Object[]> getBestBook ();
}
