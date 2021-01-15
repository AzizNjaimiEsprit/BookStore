package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Answer;

import javax.transaction.Transactional;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Answer WHERE id= :id")
    void deleteAnswer(@Param("id") int id);
}
