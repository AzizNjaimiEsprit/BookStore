package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.repository.BookRepository;

import java.util.ArrayList;


@Service
public class BookServiceImp implements BookService{
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book b) {
     return (Book) bookRepository.save(b);
    }

    @Override
    public void deleteBook(Book b) {
       bookRepository.delete(b);
    }

    @Override
    public void updateBook(Book b) {
     bookRepository.save(b);
    }

    @Override
    public ArrayList<Book> getBookList() {
        return (ArrayList<Book>) bookRepository.findAll();
    }

    @Override
    public Book getBook(Book b) {
        return (Book) bookRepository.findById(b.getId()).get();
    }

    @Override
    public Book getBookByID(int id) {
        return (Book) bookRepository.findById(id).get();
    }

    @Override
    public int getQuantity(int id) {
        return bookRepository.getQuantity(id);
    }

    @Override
    public void setQuantity(int id, int newQ) {
        bookRepository.setQuantity(id, newQ);
    }
}
