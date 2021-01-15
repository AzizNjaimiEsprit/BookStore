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
    public Book AjouterLivre(Book b) {
     return (Book) bookRepository.save(b);

    }

    @Override
    public void SupprimerLivre(Book b) {
       bookRepository.delete(b);
    }

    @Override
    public void ModifierLivre(Book b) {
     bookRepository.save(b);
    }

    @Override
    public ArrayList<Book> RecupererListLivre() {
        return (ArrayList<Book>) bookRepository.findAll();
    }

    @Override
    public Book RecupererLivre(Book b) {
        return (Book) bookRepository.findById(b.getId()).get();
    }

    @Override
    public Book RecupererLivreByID(int id) {
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
