package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.OnlineBook;

import java.util.ArrayList;

public interface OnlineBookService {
    OnlineBook AjouterLivre(OnlineBook b);
    void SupprimerLivre(OnlineBook b);
    void ModifierLivre(OnlineBook b);
    ArrayList<OnlineBook> RecupererListLivre();
    OnlineBook RecupererLivre(OnlineBook b);
    OnlineBook RecupererLivreByID(int id);
}
