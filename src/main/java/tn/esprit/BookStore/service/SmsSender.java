package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Library;

public interface SmsSender {
    void sendSms(Library library);
}
