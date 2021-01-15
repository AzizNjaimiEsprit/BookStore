package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Book;

import java.util.ArrayList;

public interface BookService {
    Book AjouterLivre(Book b);
    void SupprimerLivre(Book b);
    void ModifierLivre(Book b);
    ArrayList<Book> RecupererListLivre();
    Book RecupererLivre(Book b);
    Book RecupererLivreByID(int id);


}
