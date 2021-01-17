package tn.esprit.BookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.service.BookServiceImp;

import java.util.ArrayList;

@RequestMapping("api/book")
@RestController
public class BookController {
    @Autowired
    BookServiceImp bookServiceImp;

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book b) {
        bookServiceImp.addBook(b);
    }

    @PostMapping("/deleteBook")
    public void deletBook(@RequestBody Book b) {
        bookServiceImp.deleteBook(b);
    }

    @PostMapping("/updateBook")
    public void updateBook(@RequestBody Book b) {
        bookServiceImp.updateBook(b);
    }

    @GetMapping("/getBookList")
    public ArrayList<Book> getBookList() {
        return bookServiceImp.getBookList();
    }

    @GetMapping("/getBook")
    public Book getBook(@RequestBody Book Book) {
        return bookServiceImp.getBook(Book);
    }

    @GetMapping("/getBookbyId")
    public Book getBookbyId(@RequestBody int id) {
        return bookServiceImp.getBookByID(id);
    }

    @GetMapping("/getQuantity")
    public int getQuantity(@RequestBody int id) {
        return bookServiceImp.getQuantity(id);
    }


}
