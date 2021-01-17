package tn.esprit.BookStore.service;

import java.util.Optional;


public interface AnswerService<T> {

    T save(T t);

    void edit(T t);

    Optional<T> findAnswerById(int id);

}
