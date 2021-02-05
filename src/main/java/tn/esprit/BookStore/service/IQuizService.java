package tn.esprit.BookStore.service;
import tn.esprit.BookStore.model.*;

import java.util.Set;

public interface IQuizService {

    public Answer addAnswer(Answer answer);
    public Question addQuestion(Question question);
    public void addAnswerToQuestion(Question question);
    public Quiz addQuiz(Quiz quiz);
    public void addQuestionQuiz(Question question);
    public void addOnlineBookToQuiz(Quiz quiz);
    public void addUserToQuiz(Quiz quiz);

    public Question updateQuestion(Question question);
    public Answer updateAnswer(Answer answer);
    public Quiz updateQuizScore(Quiz quiz);

    public Set<Answer> getAnswerByQuiz(Quiz quiz);
    public Set<Question> getQuestionByQuiz(Quiz quiz);
    public Quiz getQuizByOnlineBook(OnlineBook onlineBook);
    public void deleteQuiz(OnlineBook onlineBook);
}
