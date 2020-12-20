package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Answer;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Integer> {
}
