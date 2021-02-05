package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.entities.Answer;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Answer WHERE id= :id")
    void deleteAnswer(@Param("id") int id);

    @Query("Select DISTINCT a from Answer a join Question q on a.id= q.answer.id join Quiz q2 on q2.id = q.quiz.id where q2.id = :quiz_id")
    Set<Answer> findAnswerByQuizId(@Param("quiz_id") int quizId);

}
