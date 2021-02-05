package tn.esprit.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.entities.*;
import tn.esprit.BookStore.service.IQuizService;
import java.util.Set;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    IQuizService quizService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/addAnswer", produces = { "application/json"})
    public Answer saveAnswer(@RequestBody Answer answer)
    {
        return quizService.addAnswer(answer);
    }

    @PostMapping(value ="/addQuestion", produces = { "application/json"})
    public Question saveQuestion(@RequestBody Question question)
    {
        return quizService.addQuestion(question);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value ="/addQuestionAnswer")
    public void affectQuestionAnswer(@RequestBody Question question){
        quizService.addAnswerToQuestion(question);
    }

    @PostMapping(value ="/addQuiz", produces = { "application/json"})
    public Quiz saveQuiz(@RequestBody Quiz quiz)
    {
        return quizService.addQuiz(quiz);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/addQuizQuestions")
    public void affectQuizQuestion(@RequestBody Question question){
        quizService.addQuestionQuiz(question);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/addBookQuiz")
    public void affectBookQuiz(@RequestBody Quiz quiz){
        quizService.addOnlineBookToQuiz(quiz);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/passQuiz")
    public void passQuiz(@RequestBody Quiz quiz){
        quizService.addUserToQuiz(quiz);
    }

    @PutMapping(value = "/updateAnswer", produces = { "application/json"})
    public Answer editAnswer(@RequestBody Answer answer){
        return quizService.updateAnswer(answer);
    }

    @PutMapping(value = "/udpateQuestion", produces = { "application/json"})
    public Question editQuestion(@RequestBody Question question){
        return quizService.updateQuestion(question);
    }

    @PutMapping(value = "/updateScore", produces = { "application/json"})
    public Quiz editQuizScore(@RequestBody Quiz quiz){
        return quizService.updateQuizScore(quiz);
    }

    @GetMapping(value = "getAnswerByQuiz", produces = { "application/json"})
    public Set<Answer> getAnswerByQuiz(@RequestBody Quiz quiz) {
        return quizService.getAnswerByQuiz(quiz);
    }
    @GetMapping(value = "getQuestionByQuiz", produces = { "application/json"})
    public Set<Question> getQuestionByQuiz(@RequestBody Quiz quiz){
        return quizService.getQuestionByQuiz(quiz);
    }

    @GetMapping(value = "getQuizByOnlineBook", produces = { "application/json"})
    public Quiz getQuizByOnlineBook(@RequestBody OnlineBook onlineBook){
        return quizService.getQuizByOnlineBook(onlineBook);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("deleteQuiz")
    public void removeQuiz(@RequestBody OnlineBook onlineBook){
       quizService.deleteQuiz(onlineBook);
    }

}
