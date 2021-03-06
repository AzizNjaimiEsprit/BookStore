package tn.esprit.BookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.*;
import tn.esprit.BookStore.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wishLists")
public class WishListController {

    @Autowired
    private WishListServiceImpl wishListService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private IOnLineWishList iOnLineWishList;

    @GetMapping("/findAllWishList")
    public List <WishList> findAll() {
      return  wishListService.findAll();
    }

    @GetMapping("/findWishList")
    WishList findById(int id) {
        return wishListService.findById(id);
    }


    @PostMapping("/create")
    WishList addWishList(@RequestBody WishList wishList) {
        return wishListService.addWishList(wishList);
    }

    @PostMapping("/")
    public WishList addBookToWishList(int idBook, int idwishList) {
        return wishListService.addBookToWishList(idBook, idwishList);
    }

    @DeleteMapping("/")
    public void deleteBookFromBasket(int idwishList, int idBook) {
        wishListService.deleteBookFromWishList(idwishList, idBook);

    }

    @GetMapping("/best")
    public int countBestBookInWishList() {
        return wishListService.countBestBookInWishList(orderItemService.getBestBook());
    }

    @GetMapping("/allwishlist")
    public Map<String, List<Object>> getWishLis(int user_id) {
        Map<String, List<Object>> map = new HashMap<>();

        List<Object> wishListArrayList = new ArrayList<>();

        List<WishList> wishLists = wishListService.findAll();

        List<OnLineWishList> onlinewishList = iOnLineWishList.findAll();

        for (OnLineWishList onLineWishList : onlinewishList) {

            if (onLineWishList.getUser().getId() == user_id)

                wishListArrayList.add(onLineWishList);
        }
        for (WishList wishList : wishLists) {

            if (wishList.getUser().getId() == user_id)
                wishListArrayList.add(wishList);
        }
        map.put("list", wishListArrayList);
        return map;
    }

}