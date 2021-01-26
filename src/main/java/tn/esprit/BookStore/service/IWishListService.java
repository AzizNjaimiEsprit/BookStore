package tn.esprit.BookStore.service;


import tn.esprit.BookStore.model.WishList;

import java.util.List;

public interface IWishListService <T>{

    List<WishList> findAll();

    T findById(Long id);

    T create(T wishList);

    T update(T WishList);

    void saveBookToWishList(T wishList);
    void deleteBookFromWishList(long bookId);
    void returnWishListByUserId (long userId);
}
