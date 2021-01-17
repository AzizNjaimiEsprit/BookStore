package tn.esprit.BookStore.service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface QuizService<T> {

    T save(T t);

    void removeQuiz(int id) throws EntityNotFoundException;

    List<T> findQuizByBook(int bookId);

}
