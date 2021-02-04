package tn.esprit.BookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Basket;
import tn.esprit.BookStore.model.BasketBook;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/baskets")
public class BasketController {

    @Autowired
    private IBasketService basketService;

    @Autowired
    private ImpUserService impUserService;

    @Autowired
    private BookServiceImp bookServiceImp;





    @DeleteMapping("/")
    public String deleteBookFromBasket(int idBook, int idBasket) {
        basketService.deleteBasketFromBook(idBook,idBasket);
        return "Book deleted from basket";

    }

    @PostMapping ("/")
    public BasketBook addBookToBasket(@RequestBody BasketBook basketBook) {
        return basketService.addBookToBasket(basketBook);
    }

    @PutMapping("/")
    public void updateQuantityBook(@RequestBody BasketBook basketBook) {
        basketService.updateQuantityBook(basketBook);
    }

    @GetMapping ("/findAllBaskets")
    public List<Basket> findAll(){
        return basketService.findAll();
    }


    @PostMapping("/create")
    Basket  createBasket (int id_user){
        Basket basket = new Basket();
        basket.setUser(impUserService.GetUser(id_user));
        return basketService.ajouterBasket(basket);

    }

    @DeleteMapping("/basket")
    public String deleteBasket(int idBasket) {
        basketService.deleteBasket(idBasket);
         return "Basket deleted";
    }



    @GetMapping("/get")
    HashMap <String, String> returnBasketByUserId (long userId){
        HashMap map = new HashMap();

        try{
            basketService.returnBasketByUserId(userId);
            map.put("state", "Succées");
        } catch (Exception e) {
            map.put("state", "Erreur");

        }
        return map;
    }





}

