package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.entities.Book;
import tn.esprit.BookStore.entities.Library;

import java.util.List;
import java.util.Set;


@Repository
public interface LibraryRepo extends JpaRepository<Library,Integer> {


   @Query("SELECT distinct b from Book b join OnlineBook ob on b.id = ob.book.id join Library l on ob.id = l.onlineBook.id where l.user.id = :user_id")
   public Set<Book> getPurchasedBooks(@Param("user_id") int userId);

   @Query("SELECT l from Library l where l.user.id=:user_id")
    public List<Library> findLibraryItems(@Param("user_id") int userId);

    @Query("SELECT l from Library l where l.user.id=:user_id and l.onlineBook.id= :book_id ")
    public Library findLibraryItem(@Param("user_id") int userId,@Param("book_id") int bookId);

    @Query("SELECT l.onlineBook.book.title from Library l join OnlineBook ob on ob.id = l.onlineBook.id join Book b on b.id = ob.book.id where l.user.id = :user_id and l.onlineBook.id = :book_id")
    public String getBookTitle(@Param("book_id") int bookId,@Param("user_id") int userId);

    @Query("SELECT distinct b FROM Book b WHERE b.category.id=:category_id")
    List<Book> findBookByCategoryId(@Param("category_id") int categoryId);
}
