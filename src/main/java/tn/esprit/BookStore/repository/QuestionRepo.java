package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.entities.Question;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {

    @Modifying
    @Transactional
    @Query("delete from Question q where q.quiz.id =:quiz_id")
    void deleteQuestion(@Param("quiz_id") int quizId);

    @Query("select answer.id from Question where id= :id")
    int getAnswerById(@Param("id") int id);

    @Query("select DISTINCT q from Question q where q.quiz.id = :quiz_id")
    Set<Question> findQuestionsByQuizId(@Param("quiz_id") int quizId);
}
