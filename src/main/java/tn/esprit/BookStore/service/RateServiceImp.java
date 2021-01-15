package tn.esprit.BookStore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Rate;
import tn.esprit.BookStore.repository.RateRepository;

@Service
public class RateServiceImp implements RateService {
    @Autowired
    RateRepository rateRepository;
    @Override
    public void AjouterRate(Rate r) {
        rateRepository.save(r);
    }

    @Override
    public void SupprimerRate(Rate r) {
        rateRepository.delete(r);
    }

    @Override
    public void ModifierRate(Rate r) {
        rateRepository.save(r);
    }

/*    @Override
    public Rate RecupererRate(Rate r) {
        return null;
    }

    @Override
    public double getMoyRates(Book b) {
        return 0;
    }*/
}
