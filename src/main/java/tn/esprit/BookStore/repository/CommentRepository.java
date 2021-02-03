package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {


    List<Comment> getAllByBookId(@Param("id") int id);


    @Query(value = "select COUNT(c.user.id) as nbP , u.full_name as name from Comment c" +
            " JOIN User u on c.user.id = u.id " +
            "group by c.user.id \n" +
            "order by nbP DESC")
    List<Object[]> getTopFan() ;
}
