package tn.esprit.BookStore.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.WishList;

@Repository
public interface WishListRepository extends CrudRepository<WishList, Long> {


}
