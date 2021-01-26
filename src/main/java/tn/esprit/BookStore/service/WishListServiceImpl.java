package tn.esprit.BookStore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.WishList;
import tn.esprit.BookStore.repository.WishListRepository;

import java.util.List;

@Service
public class WishListServiceImpl implements IWishListService<WishList>{
    @Autowired
    WishListRepository wishListRepository;


    @Override
    public List<WishList> findAll() {
        return wishListRepository.findAll();
    }

    @Override
    public WishList findById(Long id) {
        return wishListRepository.findById(id).get();
    }

    @Override
    public WishList create(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    @Override
    public WishList update(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    @Override
    public void saveBookToWishList(WishList wishList) {

    }

    @Override
    public void deleteBookFromWishList(long bookId) {

        WishList wishList =  wishListRepository.findById(bookId).get();
        wishListRepository.removeBookFromWishList(wishList.getBook().getId());

    }

    @Override
    public void returnWishListByUserId(long userId) {

    }
}