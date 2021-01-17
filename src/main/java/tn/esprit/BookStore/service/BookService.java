package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Book;

import java.util.ArrayList;

public interface BookService {
    Book addBook(Book b);

    void deleteBook(Book b);

    void updateBook(Book b);

    ArrayList<Book> getBookList();

    Book getBook(Book b);

    Book getBookByID(int id);

    int getQuantity(int id);

    void setQuantity(int id, int newQ);

}
