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
import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {

    @Modifying
    @Transactional(rollbackOn = EntityNotFoundException.class)
    @Query("delete from Quiz q where q.book.id= :book_id ")
    void deleteQuiz(@Param("book_id") int bookId);

    @Query("select question.id from Quiz where book.id = :book_id ")
    ArrayList<Integer> getQuestionById(@Param("book_id") int bookId);

    @Query(value = "select * from Quiz q join online_book ob on ob.book_id = q.book_id where ob.book_id=:book_id",nativeQuery = true)
    List<Quiz> findQuizByBookId (@Param("book_id") int bookId);

}
