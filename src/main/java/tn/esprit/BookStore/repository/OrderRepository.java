package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Order;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT o from Order o  where o.user.id = :user_id")
    List<Order> findAllByUser(@Param("user_id") Integer user_id);

    @Query(value = "SELECT o FROM Order o where o.status = :status")
    List<Order> findAllByStatus(@Param("status") String status);

    @Modifying
    @Query(value = "UPDATE Order o set o.status = :status where o.id = :id")
    void updateStatus(@Param("status") String status, @Param("id") Integer id);

    //Stats
    @Query(value = "select CONCAT(z.governorate,':',SUM(o.total_price)) as sum " +
            "from orders o, zip_codestn z " +
            "where z.code like  CONCAT(SUBSTR(o.zip_code, 1, 2),'__')" +
            "GROUP BY z.governorate",nativeQuery = true)
    ArrayList<String> getInputsByGovernorate();

    @Query(value = "select QUARTER(order_date),SUM(total_price)" +
            " as sum from orders group by QUARTER(order_date)", nativeQuery = true)
    List<Object[]> getInputsByQuarter();

    @Query(value = "select MONTH(order_date),SUM(total_price)" +
            " as sum from orders group by MONTH(order_date)", nativeQuery = true)
    List<Object[]> getInputsByMonth();

    @Query(value = "select MAX(amount) ,full_name,user_id from (select SUM(total_price)  amount , user_id , full_name " +
            "from orders JOIN user u on orders.user_id = u.id " +
            "group by user_id order by amount DESC) tab", nativeQuery = true)
    List<Object[]> getBestCustomer();
}
