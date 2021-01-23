package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.FidelityCard;

import java.util.List;

public interface FidelityCardService {
    FidelityCard addCard (FidelityCard card);
    FidelityCard updateCard (FidelityCard card);
    void deleteCard (long cardId);
    FidelityCard getCard (long cardId);
    FidelityCard getUserCard (long userId);
    List<FidelityCard> getAllCards ();
}
