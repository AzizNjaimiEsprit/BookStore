package tn.esprit.BookStore;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Category;
import tn.esprit.BookStore.model.OnlineBook;
import tn.esprit.BookStore.service.BookService;
import tn.esprit.BookStore.service.OnlineBookService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OnlineBookServiceTest {
/*    @Autowired
    OnlineBookService bookService;

    @Test
    void contextLoads() throws ParseException {
    Category c = new Category(1,"cat1");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date dateDebut = dateFormat.parse("30/09/2019");
    Book b1 = new Book(1,"book1",11,"hjhhjh","khhujhuh",dateDebut,8,"hiuhuh",c,"hhhhj",8,"hjhjh",false);
    Book b2 = new Book(2,"book1",11,"hjhhjh","khhujhuh",dateDebut,8,"hiuhuh",c,"hhhhj",8,"hjhjh",false);

    OnlineBook o1 = new OnlineBook(1,b1,"uuuuuuuu");
    OnlineBook o2 = new OnlineBook(2,b2,"uuuuuuuu");


        //****add book *****
        System.out.println(bookService.addBook(o1).toString());
        System.out.println(bookService.addBook(o2).toString());
        System.out.println("//****get book by id  *****");
        System.out.println(bookService.getBookByID(1));
        System.out.println("//****get all books  *****");
        for (OnlineBook i :bookService.getBookList()) System.out.println(i.toString());
        System.out.println("//**** delete book   *****");
        bookService.deleteBook(o1);
        for (OnlineBook i :bookService.getBookList()) System.out.println(i.toString());
        System.out.println("//****update book  *****");
        b1.setQuantity(8);
        bookService.updateBook(o1);
        System.out.println("//****get quantity   *****");
        System.out.println(bookService.getQuantity(1));
        System.out.println("//**** set quantity  *****");

        bookService.setOnlineQuantity(1,11);
        System.out.println(bookService.getBookByID(1));*/

}
