package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
}
