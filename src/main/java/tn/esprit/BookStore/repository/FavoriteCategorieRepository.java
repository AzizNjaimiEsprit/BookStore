package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.BookStore.model.FavoriteCategorie;

@Repository
public interface FavoriteCategorieRepository extends CrudRepository<FavoriteCategorie, Long>{

}
