package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT c.* , full_name from t_comment c join t_user U on U.id = c.user_id WHERE id_book=:id", nativeQuery = true)
    List<Comment> getAllComment(@Param("id") int id);

    @Query(value = "select MAX(nbP) ,name from (select COUNT(c.user_id) nbP , u.full_name as name\n" +
            "from comment c\n" +
            "JOIN user u on c.user_id = u.id\n" +
            "group by c.user_id\n" +
            "order by nbP DESC) tab",nativeQuery = true)
    List<Object[]> getTopFan() ;
}
