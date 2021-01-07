package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Rate;

public interface RateService {
    void AjouterRate(Rate r);
    void SupprimerRate(Rate r);
    void ModifierRate(Rate r);
/*    Rate RecupererRate(Rate r);
    double getMoyRates(Book b);*/
}
