package tn.esprit.BookStore.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Quiz;
import tn.esprit.BookStore.model.Response;
import tn.esprit.BookStore.service.QuizService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;

@RestController
public class QuizControl {

    @Autowired
    QuizService<Quiz> quizService;

    private static final Gson gson=new Gson();

    @PostMapping("/quiz")
    public ResponseEntity<String> addQuiz(@RequestBody Quiz quiz){
        try{
            Quiz newQuiz = quizService.save(quiz);
            return ResponseEntity.status(201).body(gson.toJson(Response.getInstance("Quiz has been added successfully!",newQuiz)));
        }catch(Exception e){
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    }


    @DeleteMapping("/quiz/{book_id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable("book_id") int bookId){
        try{
            quizService.removeQuiz(bookId);
            return ResponseEntity.status(200).body(gson.toJson(Response.getInstance("Quiz has been deleted successfully!",null)));
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(404).body(gson.toJson(Response.getInstance("Quiz not found, Please add it or check for updates!",null)));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    }

    @GetMapping("/quiz/{book_id}")
    public ResponseEntity<String> getQuizByBookId(@PathVariable("book_id") int bookId){
        try{
            ArrayList<Quiz> quiz=quizService.findQuizByBook(bookId);
            if(quiz.isEmpty()){
                throw new EntityNotFoundException();
            }
            return ResponseEntity.status(200).body(gson.toJson(Response.getInstance(null,quiz)));
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(404).body(gson.toJson(Response.getInstance("Quiz not found, Please add it or check for updates!",null)));
        }
        catch(Exception e){
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    }
}
