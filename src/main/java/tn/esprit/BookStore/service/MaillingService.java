package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Order;

public interface MaillingService {
    public void sendReceiptEmail(Order order);
    public void sendReptureStockEmail(Book B) ;
    public void sendConfirmationEmail(String to, String msg);

}
