package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.FidelityCard;
import tn.esprit.BookStore.service.FidelityCardService;

import java.util.List;

@RestController
@RequestMapping("api/fidelityCard")
public class FidelityCardController {
    @Autowired
    private FidelityCardService fidelityCardService;

    @PostMapping("/add")
    public FidelityCard addCard (@RequestBody FidelityCard card) {return fidelityCardService.addCard(card);}

    @PutMapping("/update")
    public FidelityCard updateCard (@RequestBody FidelityCard card) {return fidelityCardService.updateCard(card);}

    @DeleteMapping("/delete/{cardId}")
    public void deleteCard (@PathVariable long cardId ) {fidelityCardService.deleteCard(cardId);}

    @GetMapping("/get/{cardId}")
    public FidelityCard getCard (@RequestBody long cardId) {return fidelityCardService.getCard(cardId);}

    @GetMapping("/get/{userId}")
    public FidelityCard getUserCard (@RequestBody long userId) {return fidelityCardService.getUserCard(userId);}

    @GetMapping("/getAll")
    public List<FidelityCard> getAllCards () {return fidelityCardService.getAllCards();}

}
