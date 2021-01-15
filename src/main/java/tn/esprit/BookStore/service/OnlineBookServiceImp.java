package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.OnlineBook;
import tn.esprit.BookStore.repository.OnlineBookRepository;

import java.util.ArrayList;

@Service
public class OnlineBookServiceImp implements OnlineBookService {
    @Autowired
    OnlineBookRepository onlineBookRepository;

    @Override
    public OnlineBook AjouterLivre(OnlineBook b) {
        return (OnlineBook) onlineBookRepository.save(b);
    }

    @Override
    public void SupprimerLivre(OnlineBook b) {
      onlineBookRepository.delete(b);
    }

    @Override
    public void ModifierLivre(OnlineBook b) {
       onlineBookRepository.save(b);
    }

    @Override
    public ArrayList<OnlineBook> RecupererListLivre() {
        return (ArrayList<OnlineBook>) onlineBookRepository.findAll();
    }

    @Override
    public OnlineBook RecupererLivre(OnlineBook b) {
        return (OnlineBook) onlineBookRepository.findById(b.getId()).get();
    }

    @Override
    public OnlineBook RecupererLivreByID(int id) {
        return (OnlineBook) onlineBookRepository.findById(id).get();
    }
}
