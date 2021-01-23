package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Offer;
import tn.esprit.BookStore.service.OfferService;

import java.util.List;

@RestController
@RequestMapping("api/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping("/add")
    public Offer addOffer (@RequestBody Offer offer) {return offerService.addOffer(offer);}

    @PutMapping("/update")
    public Offer updateOffer (@RequestBody Offer offer) {return offerService.updateOffer(offer);}

    @DeleteMapping("delete/{id}")
    public void deleteOffer (@PathVariable long offerId) {offerService.deleteOffer(offerId);}

    @GetMapping("/get/{id}")
    public Offer getOffer (@PathVariable long offerId) {return offerService.getOffer(offerId);}

    @GetMapping("/getAll")
    public List<Offer> getAllOffers () {return offerService.getAllOffers();}

    @GetMapping("/getAll/{userId}")
    public List<Offer> getAllOffersByUserId (@PathVariable long userId) {return offerService.getAllOffersByUserId(userId);}
}
