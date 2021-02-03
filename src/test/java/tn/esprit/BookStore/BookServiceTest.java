package tn.esprit.BookStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Category;
import tn.esprit.BookStore.repository.BookRepository;
import tn.esprit.BookStore.service.BookService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    void contextLoads() throws ParseException {
     /*   Category c = new Category(1,"cat1");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateDebut = dateFormat.parse("30/09/2019");
        Book b1 = new Book(1,"book1",11,"hjhhjh","khhujhuh",dateDebut,8,"hiuhuh",c,"hhhhj",8,"hjhjh",false);
        Book b2 = new Book(2,"book1",11,"hjhhjh","khhujhuh",dateDebut,8,"hiuhuh",c,"hhhhj",8,"hjhjh",false);


        //****add book *****
        System.out.println(bookService.addBook(b1).toString());
        System.out.println(bookService.addBook(b2).toString());
        System.out.println("//****get book by id  *****");
        System.out.println(bookService.getBookByID(1));
        System.out.println("//****get all books  *****");
        for (Book i :bookService.getBookList()) System.out.println(i.toString());
        System.out.println("//**** delete book   *****");
        bookService.deleteBook(b1);
        for (Book i :bookService.getBookList()) System.out.println(i.toString());
        System.out.println("//****update book  *****");
        b1.setQuantity(8);
        bookService.updateBook(b1);
        System.out.println("//****get quantity   *****");
        System.out.println(bookService.getQuantity(1));
        System.out.println("//**** set quantity  *****");

        bookService.setQuantity(1,11);
        System.out.println(bookService.getBookByID(1));*/

    }
}
