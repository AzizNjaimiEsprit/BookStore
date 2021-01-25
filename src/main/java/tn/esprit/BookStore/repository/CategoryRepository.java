package tn.esprit.BookStore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(@Param("name") String name);
}
