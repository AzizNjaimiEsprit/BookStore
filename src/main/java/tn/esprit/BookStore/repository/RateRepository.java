package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {

    Rate getRateByBookIdAndUserId (@Param("book_id") int book_id, @Param("user_id") int user_id);


    @Query(value = "SELECT AVG(r.rate) FROM Rate r  WHERE r.book.id=:id")
    double getmoyrate(@Param("id") int id);
}
