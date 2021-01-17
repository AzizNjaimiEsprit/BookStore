package tn.esprit.BookStore.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    @Modifying
    @Query(value = "Insert into Basket values (:book_id , :user_id, :quantity)", nativeQuery = true)
    void addBookToBasket(@Param("book_id") long bookId, @Param("user_id") long userId, @Param("quantity") long quantity);

    @Modifying
    @Query("delete from Basket where book.id=:book_id")
    void removeBookFromBasket(@Param("book_id") long bookId);

    @Query("select b from Basket b where b.user.id=:user_id")
    Basket getBasketByUserId(@Param("user_id") long userId);
}
