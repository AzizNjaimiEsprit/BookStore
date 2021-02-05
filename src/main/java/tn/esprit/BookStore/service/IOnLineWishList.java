package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.OnLineWishList;
import tn.esprit.BookStore.model.OnlineBook;

import java.util.List;

public interface IOnLineWishList <T>{
    List<T> findAll();

    OnLineWishList findById(int id);

    OnLineWishList addWishList(OnLineWishList wishList);

    OnLineWishList addBookToWishList(int bookId, int wishlistId);


    void deleteBookFromWishList(int wishListId, int bookId);

    List <OnlineBook> countBooksInWishList(int idwishList);

}
