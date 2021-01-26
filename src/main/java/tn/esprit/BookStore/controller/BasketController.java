package tn.esprit.BookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Basket;
import tn.esprit.BookStore.service.BasketServiceImpl;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/baskets")
public class BasketController {

    @Autowired
    private BasketServiceImpl basketServiceImpl;

    @PostMapping("/findAll")
    public List<Basket> findAll(){
        return basketServiceImpl.findAll();
    }

    @GetMapping("/")
    Basket findById(Long id){
        return  basketServiceImpl.findById(id);
    }

    @PostMapping("/create")
    Basket  create( Basket basket){
        return basketServiceImpl.create(basket);
    }

    @PutMapping("/")
    Basket  update(Basket basket, int quantity){
        return basketServiceImpl.update(basket,quantity);
    }

    @PostMapping("/saveBook")
    HashMap<String, String> saveBookToBasket(long bookId, long basketId) {
        HashMap map = new HashMap();
        try {
            basketServiceImpl.saveBookToBasket(bookId, basketId);
            map.put("state", "Ajout avec succés");
        } catch (Exception e) {
            map.put("state", "Erreur d'ajout");

        }
        return map;
    }

    @DeleteMapping("/")
    HashMap <String, String> deleteBookFromBasket(long bookId){
        HashMap map = new HashMap();
        try{
            basketServiceImpl.deleteBookFromBasket(bookId);
            map.put("state", "Supprimé avec succés");
        } catch (Exception e) {
            map.put("state", "Erreur de suprission");

        }
        return map;
    }

    HashMap <String, String> returnBasketByUserId (long userId){
        HashMap map = new HashMap();

        try{
            basketServiceImpl.returnBasketByUserId(userId);
            map.put("state", "Succées");
        } catch (Exception e) {
            map.put("state", "Erreur");

        }
        return map;
    }

}

