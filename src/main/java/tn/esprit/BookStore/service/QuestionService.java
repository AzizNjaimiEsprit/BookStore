package tn.esprit.BookStore.service;

import java.util.Optional;

public interface QuestionService<T> {

    T save(T t);

    Optional<T> findQuestionById(int id);

    void edit(T t);
}
