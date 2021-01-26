package tn.esprit.BookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Basket;
import tn.esprit.BookStore.model.WishList;
import tn.esprit.BookStore.service.BasketServiceImpl;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/WishLists")
public class WishListController {

    @Autowired
    private WishListController wishListController;

    @PostMapping("/findAllWishList")
    public List<WishList> findAll(){
        return wishListController.findAll();
    }

    @GetMapping("/findWishList")
    Basket findById(Long id){
        return  wishListController.findById(id);
    }

    @PostMapping("/createWishList")
    Basket  create( WishList wishList){
        return wishListController.create(wishList);
    }

    @PutMapping("/updateWishList")
    Basket  update(WishList wishList){
        return wishListController.update(wishList);
    }

    @PostMapping("/saveToWishList")
    HashMap<String, String> saveBookToWishList(long bookId, long wishListID) {
        HashMap map = new HashMap();
        try {
            wishListController.saveBookToWishList(bookId,wishListID);
            map.put("state", "Ajout avec succés");
        } catch (Exception e) {
            map.put("state", "Erreur d'ajout");

        }
        return map;
    }

    @DeleteMapping("/deleteFromWishList")
    HashMap <String, String> deleteBookFromWishList(long bookId){
        HashMap map = new HashMap();
        try{
            wishListController.deleteBookFromWishList(bookId);
            map.put("state", "Supprimé avec succés");
        } catch (Exception e) {
            map.put("state", "Erreur de suprission");

        }
        return map;
    }

    HashMap <String, String> returnWishListByUserId (long userId){
        HashMap map = new HashMap();

        try{
            wishListController.returnWishListByUserId(userId);
            map.put("state", "Succées");
        } catch (Exception e) {
            map.put("state", "Erreur");

        }
        return map;
    }



}
