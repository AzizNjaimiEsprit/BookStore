package tn.esprit.BookStore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.WishList;

import javax.transaction.Transactional;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

//    @Modifying
//    @Query(value = "Insert into Basket values (:book_id , :user_id, :quantity)", nativeQuery = true)
//    void addBookToWishList(@Param("book_id") long bookId, @Param("user_id") long userId, @Param("quantity") long quantity );
//
//    @Modifying
//    @Query("delete from Basket where book.id=:book_id")
//    void removeBookFromWishList(@Param("book_id") long bookId);


    @Query("select b from Basket b where b.user.id=:user_id")
    WishList getWishListByUserId(@Param("user_id") long userId);



}
