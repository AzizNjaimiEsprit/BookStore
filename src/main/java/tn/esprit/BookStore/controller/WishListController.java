package tn.esprit.BookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Basket;
import tn.esprit.BookStore.model.BasketBook;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.WishList;
import tn.esprit.BookStore.service.BookServiceImp;
import tn.esprit.BookStore.service.ImpUserService;
import tn.esprit.BookStore.service.WishListServiceImpl;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/wishLists")
public class WishListController {

    @Autowired
    private WishListServiceImpl wishListService;

    @Autowired
    private ImpUserService impUserService;

    @Autowired
    private BookServiceImp bookServiceImp;

    @GetMapping("/findAllWishList")
    public String findAll(){
        System.out.println(wishListService.findAll().toString());
        return "allWishList";
    }

    @GetMapping("/findWishList")
    WishList findById(int id){
        return  wishListService.findById(id);
    }


    @PostMapping("/create")
     WishList addWishList(@RequestBody WishList wishList) {
       return  wishListService.addWishList(wishList);
    }

    @PostMapping ("/")
    public WishList addBookToWishList(int idBook, int idwishList) {
        return wishListService.addBookToWishList(idBook,idwishList);
    }

    @DeleteMapping("/")
    public void deleteBookFromBasket(int idwishList, int idBook) {
         wishListService.deleteBookFromWishList(idwishList, idBook);


    }

}
