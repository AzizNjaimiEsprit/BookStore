package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Rate;

public interface RateService {
    void addRate(Rate r);

    void deleteRate(Rate r);

    void updateRate(Rate r);

    public Rate getRate(int id_book , int id_user);

    double getMoyRates(Book b);
}
