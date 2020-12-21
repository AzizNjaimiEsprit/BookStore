package tn.esprit.BookStore.service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

public interface QuizService<T> {

    T save(T t);

    void removeQuiz(int id) throws EntityNotFoundException;

    ArrayList<T> findQuizByBook(int bookId);
}
