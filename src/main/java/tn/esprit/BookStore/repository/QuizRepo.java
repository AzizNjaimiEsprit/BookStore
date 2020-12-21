package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Quiz;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {

    @Modifying
    @Transactional(rollbackOn = EntityNotFoundException.class)
    @Query("delete from Quiz q where q.book in (select ob from OnlineBook ob where ob.id= :book_id)")
    void deleteQuiz(@Param("book_id") int bookId);

    @Query("select question.id from Quiz where book.id = :book_id ")
    ArrayList<Integer> getQuestionById(@Param("book_id") int bookId);

    @Query("from Quiz q where q.book.id= :book_id")
    ArrayList<Quiz> findQuizByBookId (@Param("book_id") int bookId);

}
