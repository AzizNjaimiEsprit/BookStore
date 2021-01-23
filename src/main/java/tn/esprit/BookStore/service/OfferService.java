package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Offer;

import java.util.List;

public interface OfferService {
    Offer addOffer (Offer offer);
    Offer updateOffer (Offer offer);
    void deleteOffer (long offerId);
    Offer getOffer (long offerId);
    List<Offer> getAllOffers ();
    List<Offer> getAllOffersByUserId (long userId);
}
