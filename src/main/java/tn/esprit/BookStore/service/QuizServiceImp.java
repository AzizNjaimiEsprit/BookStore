package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Quiz;
import tn.esprit.BookStore.repository.AnswerRepo;
import tn.esprit.BookStore.repository.QuestionRepo;
import tn.esprit.BookStore.repository.QuizRepo;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImp implements QuizService<Quiz> {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    AnswerRepo answerRepo;

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepo.save(quiz);
    }


    @Override
    public void removeQuiz(int id) throws EntityNotFoundException {
        ArrayList<Integer> questionsId = quizRepo.getQuestionById(id);
        if (questionsId.isEmpty()) {
            throw new EntityNotFoundException();
        }
        quizRepo.deleteQuiz(id);
        ArrayList<Integer> answersId = new ArrayList<>();
        for (Integer i : questionsId) {
            answersId.add(questionRepo.getAnswerById(i));
            questionRepo.deleteQuiz(i);
        }
        if (answersId.isEmpty()) {
            throw new EntityNotFoundException();
        }
        for (Integer i : answersId) {
            answerRepo.deleteAnswer(i);
        }
    }

    @Override
    public List<Quiz> findQuizByBook(int bookId) {
        return quizRepo.findQuizByBookId(bookId);
    }

}
