package tn.esprit.BookStore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.WishList;

import javax.transaction.Transactional;

import tn.esprit.BookStore.model.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
//
//    @Query("select b from Basket b where b.user.id=:user_id")
//    WishList getWishListByUserId(@Param("user_id") long userId);


}
