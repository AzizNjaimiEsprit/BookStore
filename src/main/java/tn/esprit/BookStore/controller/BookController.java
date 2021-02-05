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


    @GetMapping("/getBook/{id}")
    public Book getBookbyId(@PathVariable int id) {
        return bookServiceImp.getBookByID(id);
    }

    @GetMapping("/getQuantity/{id}")
    public int getQuantity(@PathVariable int id) {
        return bookServiceImp.getQuantity(id);
    }


}