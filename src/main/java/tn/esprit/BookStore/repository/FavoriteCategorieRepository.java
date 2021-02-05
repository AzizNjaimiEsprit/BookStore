package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.BookStore.model.Category;
import tn.esprit.BookStore.model.FavoriteCategorie;
import tn.esprit.BookStore.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteCategorieRepository extends CrudRepository<FavoriteCategorie, Long>{
    @Query("SELECT u.User FROM FavoriteCategorie u WHERE u.Category= :titre")
    @Transactional
    public List<User> getAllUserByCategory(@Param("titre") Optional<Category> c);
}
