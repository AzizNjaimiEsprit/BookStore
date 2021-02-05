package tn.esprit.BookStore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Basket;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;

import tn.esprit.BookStore.model.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

////    @Modifying
////    @Query(value = "Insert into Basket values (, :user_id, :quantity)", nativeQuery = true)
////    Basket addBookToBasket(@Param("book_id") long bookId, @Param("user_id") long userId, @Param("quantity") long quantity );
//
//    @Modifying
//    @Query("delete from Basket b where b.bookList.)
//    void removeBookFromBasket(@Param("book_id") long bookId);
////
////    @Query("select b from Basket b where b.user.id=:user_id")
////    Basket getBasketByUserId(@Param("user_id") long userId);
////
////
//    @Modifying
//    @Query(value = "update Basket b set b.quantity = :quantity where b.bookList.book.getI)
//    void setOnlineQuantity(@Param("id") int id, @Param("newQ") int newQ);



}
