package tn.esprit.BookStore.service;


import tn.esprit.BookStore.model.BasketBook;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.WishList;

import java.util.List;

public interface IWishListService <T>{

    List<T> findAll();

    WishList findById(int id);

    WishList addWishList(WishList wishList);

    WishList addBookToWishList(int bookId, int wishlistId);


     void deleteBookFromWishList(int wishListId, int bookId);


    int countBestBookInWishList(Book bestBook);
}
