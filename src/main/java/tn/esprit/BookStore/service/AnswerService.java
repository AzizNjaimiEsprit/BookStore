package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Answer;

import java.util.List;
import java.util.Optional;


public interface AnswerService<T> {

    T save(T t);

    void edit(T t);

    Optional<T> findAnswerById(int id);

}
