package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Question;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {

    @Modifying
    @Transactional
    @Query("delete from Question where id =:id")
    void deleteQuiz(@Param("id") int id);

    @Query("select answer.id from Question where id= :id")
    int  getAnswerById(@Param("id") int id);
}
