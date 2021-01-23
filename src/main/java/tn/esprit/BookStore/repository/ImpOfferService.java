package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Offer;
import tn.esprit.BookStore.repository.OfferRepository;

import java.util.List;

@Service
public class ImpOfferService implements OfferService{

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(long offerId) {
        offerRepository.delete(offerRepository.getOne(offerId));
    }

    @Override
    public Offer getOffer(long offerId) {
        return offerRepository.getOne(offerId);
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public List<Offer> getAllOffersByUserId(long userId) {
        return offerRepository.findAllByUserId(userId);
    }
}
