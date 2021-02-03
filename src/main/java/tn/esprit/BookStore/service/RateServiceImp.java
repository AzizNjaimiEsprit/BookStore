package tn.esprit.BookStore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Rate;
import tn.esprit.BookStore.repository.RateRepository;

import java.util.List;

@Service
public class RateServiceImp implements RateService {
    @Autowired
    RateRepository rateRepository;

    @Override
    public void addRate(Rate r) {
        rateRepository.save(r);
    }

    @Override
    public void deleteRate(Rate r) {
        rateRepository.delete(r);
    }

    @Override
    public void updateRate(Rate r) {
        rateRepository.save(r);
    }

    @Override
    public Rate getRate(int id_book , int id_user) {
        return  rateRepository.getRateByBookIdAndUserId(id_book,id_user);
    }

    @Override
    public double getMoyRates(Book b) {
        return rateRepository.getmoyrate(b.getId());
    }
}
