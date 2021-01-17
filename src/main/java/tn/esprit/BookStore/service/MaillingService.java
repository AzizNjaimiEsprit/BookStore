package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Order;
import tn.esprit.BookStore.model.User;

public interface MaillingService {
    void sendReceiptEmail(Order order);

    void sendReptureStockEmail(Book B);

    void sendConfirmationEmail(String to, String msg);

    void sendGiftEmail(User user,double amount);

}
