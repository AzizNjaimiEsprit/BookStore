package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.OnlineBook;

import java.util.ArrayList;

public interface OnlineBookService {
    OnlineBook addBook(OnlineBook b);

    void deleteBook(OnlineBook b);

    void updateBook(OnlineBook b);

    ArrayList<OnlineBook> getBookList();

    OnlineBook getBook(OnlineBook b);

    OnlineBook getBookByID(int id);

    int getQuantity(int id);

    void setOnlineQuantity(int id, int newQ);
}
