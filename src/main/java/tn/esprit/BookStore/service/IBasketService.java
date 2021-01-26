package tn.esprit.BookStore.service;

import java.util.List;

public interface IBasketService<T>{

    List<T> findAll();

    T findById(Long id);

    T create(T basket);

    T update(T basket, int quantity);

    void saveBookToBasket(long bookId, long basketId);
    void deleteBookFromBasket(long bookId);
    void returnBasketByUserId (long userId);




}
