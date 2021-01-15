package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

/*    @Query("SELECT c.* , full_name from t_comment c join t_user U on U.id = c.user_id WHERE id_book=:id")
    List<Comment> getAllComment(@Param("id") int id);*/
}
