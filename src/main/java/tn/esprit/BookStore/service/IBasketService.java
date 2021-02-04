package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Basket;
import tn.esprit.BookStore.model.BasketBook;
import tn.esprit.BookStore.model.User;

import java.util.List;

public interface IBasketService<T>{

    List<T> findAll();

    void deleteBasket (int idBasket);
    void deleteBasketFromBook (int idBook, int idBasket);
    BasketBook addBookToBasket(BasketBook basketBook);
    void updateQuantityBook (BasketBook basketBook);
     Basket ajouterBasket(Basket basket);

    void returnBasketByUserId (long userId);

//    public int getNombreBooks(Basket basket);

    public List<String> getAllBooksName(Basket basket);


    public void deleteAllBooks(Basket basket);
    public float getPriceByBookId(int bookId);




}
