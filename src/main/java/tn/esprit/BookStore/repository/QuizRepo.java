package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Quiz;
import javax.transaction.Transactional;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {

    @Modifying
    @Transactional
    @Query("delete from Quiz q where q.onlineBook.id= :book_id ")
    void deleteQuiz(@Param("book_id") int bookId);

    @Query("select q from Quiz q where q.onlineBook.id = :book_id ")
    Quiz findQuizByBookId (@Param("book_id") int bookId);

    @Query("select q.quizScore from Quiz q where q.user.id = :user_id  AND q.onlineBook.id = :book_id")
    int findQuizScoreOfUserByOnlineBook(@Param("user_id") int userId, @Param("book_id") int bookId);

}
