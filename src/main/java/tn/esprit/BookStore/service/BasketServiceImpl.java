package tn.esprit.BookStore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Basket;
import tn.esprit.BookStore.repository.BasketRepository;

import java.util.List;

@Service
public class BasketServiceImpl implements IBasketService<Basket>{
    @Autowired
    BasketRepository basketRepository;

    @Override
    public List<Basket> findAll() {
        return basketRepository.findAll();
    }

    @Override
    public Basket findById(Long id) {
        return basketRepository.findById(id).get();
    }

    @Override
    public void deleteBookFromBasket(long bookId) {

        Basket basket =  basketRepository.findById(bookId).get();
        basketRepository.removeBookFromBasket(basket.getBook().getId());

    }

    @Override
    public void returnBasketByUserId(long userId) {
        Basket basket = basketRepository.findById(userId).get();
        basketRepository.getBasketByUserId(basket.getBook().getId());

    }

    @Override
    public Basket create(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public Basket update(Basket basket, int quantity) {
        Basket updateQuantity = basketRepository.findById((Long) basket.getId()).get();
        updateQuantity.setQuantity(quantity);
        return basketRepository.save(basket);

    }


    @Override
    public void saveBookToBasket(long bookId, long basketId) {

    }

}
