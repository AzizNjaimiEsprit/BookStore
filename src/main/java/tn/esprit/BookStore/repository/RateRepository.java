package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {
    @Query(value = "SELECT r.* , full_name from t_rate r join t_user U on U.id = r.user_id WHERE r.id_book=:book_id AND r.user_id=:user_id", nativeQuery = true)
    Rate getrate(@Param("book_id") int book_id, @Param("user_id") int user_id);

    @Query(value = "SELECT AVG(rate) FROM t_rate  WHERE id_book=:id", nativeQuery = true)
    double getmoyrate(@Param("id") int id);
}
