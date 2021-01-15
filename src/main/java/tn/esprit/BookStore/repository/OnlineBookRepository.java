package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.OnlineBook;

@Repository
public interface OnlineBookRepository extends JpaRepository<OnlineBook,Integer> {
}
