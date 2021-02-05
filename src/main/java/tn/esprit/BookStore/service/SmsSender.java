package tn.esprit.BookStore.service;

import tn.esprit.BookStore.entities.Library;

public interface SmsSender {
    void sendSms(Library library);
}
