package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.OnLineWishList;

@Repository
public interface OnLineWishListRepo extends JpaRepository<OnLineWishList, Integer> {
}
