package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Packet;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT v from Book v where v.pkt=:pkt")
    List<Book> selectAllBookid(@Param("pkt") Optional<Packet> optional);
}


