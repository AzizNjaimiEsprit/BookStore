package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select b.quantity from Book b where b.id = :id")
    int getQuantity(@Param("id") int id);

    @Modifying
    @Query(value = "update Book b set b.quantity = :newQ where b.id = :id")
    void setQuantity(@Param("id") int id, @Param("newQ") int newQ);
}


