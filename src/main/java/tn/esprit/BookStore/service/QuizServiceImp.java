package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.*;
import tn.esprit.BookStore.exception.ApiRequestException;
import tn.esprit.BookStore.repository.*;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Service
public class QuizServiceImp implements IQuizService {

    @Autowired
    AnswerRepo answerRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    OnlineBookRepository onlineBookRepo;

    @Autowired
    FidelityCardRepository fidelityCardRepo;

    @Override
    public Answer addAnswer(Answer answer) {
        try {
            return answerRepo.save(answer);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Question addQuestion(Question question) {
        try {
           return questionRepo.save(question);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void addAnswerToQuestion(Question question) {
        try {

            if(!answerRepo.findById(question.getAnswer().getId()).isPresent()){
                throw new EntityNotFoundException("No answer with that ID was found!");
            }
            Answer answer1 = answerRepo.findById(question.getAnswer().getId()).get();

            if(!questionRepo.findById(question.getId()).isPresent()){
                throw new EntityNotFoundException("No question with that ID was found!");
            }
            Question question1= questionRepo.findById(question.getId()).get();
            question1.setAnswer(answer1);
            questionRepo.save(question1);
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        try {
            return quizRepo.save(quiz);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void addQuestionQuiz(Question question) {
        try {
            if (!questionRepo.findById(question.getId()).isPresent()) {
                throw new EntityNotFoundException("No question with that ID was found!");
            }
            Question question1 = questionRepo.findById(question.getId()).get();
            if (!quizRepo.findById(question1.getQuiz().getId()).isPresent()) {
                throw new EntityNotFoundException("No quiz with that ID was found!");
            }
            Quiz quiz1 = quizRepo.findById(question1.getQuiz().getId()).get();
            question1.setQuiz(quiz1);
            questionRepo.save(question1);
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
      }

    @Override
    public void addOnlineBookToQuiz(Quiz quiz) {
        try {
            if (!quizRepo.findById(quiz.getId()).isPresent()) {
                throw new EntityNotFoundException("No quiz with that ID was found!");
            }
            Quiz quiz1 = quizRepo.findById(quiz.getId()).get();
            if (!onlineBookRepo.findById(quiz1.getOnlineBook().getId()).isPresent()) {
                throw new EntityNotFoundException("No online book with that ID was found!");
            }
            OnlineBook onlineBook1 = onlineBookRepo.findById(quiz1.getOnlineBook().getId()).get();
            quiz1.setOnlineBook(onlineBook1);
            quizRepo.save(quiz1);
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void addUserToQuiz(Quiz quiz) {
        try {
            if (!quizRepo.findById(quiz.getId()).isPresent()) {
                throw new EntityNotFoundException("No quiz with that ID was found!");
            }
            Quiz quiz1 = quizRepo.findById(quiz.getId()).get();
            if (userRepo.findById(quiz1.getUser().getId()) == null) {
                throw new EntityNotFoundException("No user with that ID was found!");
            }
            User user1 = userRepo.findById(quiz1.getUser().getId());
            quiz1.setUser(user1);
            quizRepo.save(quiz1);
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        try {
            if (!answerRepo.findById(answer.getId()).isPresent()) {
                throw new EntityNotFoundException("No answer with that ID was found!");
            }
                Answer answer1 = answerRepo.findById(answer.getId()).get();
                answer1.setFirstAnswer(answer.getFirstAnswer());
                answer1.setSecondAnswer(answer.getSecondAnswer());
                answer1.setThirdAnswer(answer.getThirdAnswer());
                answer1.setCorrectAnswer(answer.getCorrectAnswer());
           return answerRepo.save(answer1);
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public Question updateQuestion(Question question) {
        try {
            if (!questionRepo.findById(question.getId()).isPresent()) {
                throw new EntityNotFoundException("No question with that ID was found!");
            }
            Question question1 = questionRepo.findById(question.getId()).get();
            question1.setQuestion(question.getQuestion());
            return questionRepo.save(question1);
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Quiz updateQuizScore(Quiz quiz) {
        try {
            if (!quizRepo.findById(quiz.getId()).isPresent()) {
                throw new EntityNotFoundException("No quiz with that ID was found!");
            }
            Quiz quiz1 = quizRepo.findById(quiz.getId()).get();
            if (quiz.getQuizScore() != 0) {
                quiz1.setQuizScore(quiz.getQuizScore());
                return quizRepo.save(quiz1);
            }
            else{
                throw new RuntimeException("User already passed the quiz!");
            }
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch(RuntimeException runtimeException){
            throw new ApiRequestException(runtimeException.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
        }
        catch(Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Set<Answer> getAnswerByQuiz(Quiz quiz) {
        try {
            Set<Answer> answers = answerRepo.findAnswerByQuizId(quiz.getId());
            if(answers.size() == 0){
                throw new ApiRequestException("Quiz does not contain any answer", HttpStatus.NOT_FOUND);
            }
            return answers;
        }
        catch(EntityNotFoundException ex){
            throw new ApiRequestException(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Set<Question> getQuestionByQuiz(Quiz quiz) {
        try {
            if (!quizRepo.findById(quiz.getId()).isPresent()) {
                throw new ApiRequestException("No quiz with that ID was found!", HttpStatus.NOT_FOUND);
            }
            Quiz quiz1 = quizRepo.findById(quiz.getId()).get();
            Set<Question> questions = questionRepo.findQuestionsByQuizId(quiz1.getId());
            if(questions.size() == 0){
                throw new ApiRequestException("Quiz does not contain any question", HttpStatus.NOT_FOUND);
            }
            return questions;
        }
        catch (Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Quiz getQuizByOnlineBook(OnlineBook onlineBook) {
        try {
            if (!onlineBookRepo.findById(onlineBook.getId()).isPresent()) {
                throw new ApiRequestException("No online book with that ID was found!", HttpStatus.NOT_FOUND);
            }
            OnlineBook onlineBook1 = onlineBookRepo.findById(onlineBook.getId()).get();
            Quiz quiz= quizRepo.findQuizByBookId(onlineBook1.getId());
            if(quiz == null){
                throw new ApiRequestException("Online book does not have quiz", HttpStatus.NOT_FOUND);
            }
            return quiz;
        }
        catch (Exception e){
            throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void deleteQuiz(OnlineBook onlineBook) {
      try{
          if (!onlineBookRepo.findById(onlineBook.getId()).isPresent()) {
              throw new ApiRequestException("No online book with that ID was found!", HttpStatus.NOT_FOUND);
          }
          OnlineBook onlineBook1 = onlineBookRepo.findById(onlineBook.getId()).get();
        Quiz quizToDelete = quizRepo.findQuizByBookId(onlineBook1.getId());
        if(quizToDelete == null){
            throw new ApiRequestException("No quiz with that ID was found!", HttpStatus.NOT_FOUND);
        }
        Set<Answer> answers = answerRepo.findAnswerByQuizId(quizToDelete.getId());
        // Deleting questions
        questionRepo.deleteQuestion(quizToDelete.getId());
        // Deleting answers
        for(Answer answer: answers){
            answerRepo.deleteAnswer(answer.getId());
        }
        quizRepo.deleteQuiz(onlineBook1.getId());
      }
      catch(Exception e){
          throw new ApiRequestException("An error has been occurred!", HttpStatus.BAD_REQUEST);
      }
    }



}
