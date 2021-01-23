package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.FidelityCard;

import java.util.List;

@Service
public class ImpFidelityCardService implements FidelityCardService {

    @Autowired
    private FidelityCardRepository fidelityCardRepository;

    @Override
    public FidelityCard addCard(FidelityCard card) {
        return fidelityCardRepository.save(card);
    }

    @Override
    public FidelityCard updateCard(FidelityCard card) {
        return fidelityCardRepository.save(card);
    }

    @Override
    public void deleteCard(long cardId) {
        fidelityCardRepository.delete(fidelityCardRepository.getOne(cardId));
    }

    @Override
    public FidelityCard getCard(long cardId) {
        return fidelityCardRepository.getOne(cardId);
    }

    @Override
    public FidelityCard getUserCard(long userId) {
         return fidelityCardRepository.findByUserId(userId);
    }

    @Override
    public List<FidelityCard> getAllCards() {
        return fidelityCardRepository.findAll();
    }
}
