package tn.esprit.BookStore.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Question;
import tn.esprit.BookStore.model.Response;
import tn.esprit.BookStore.service.QuestionService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
public class QuestionControl {

    @Autowired
    QuestionService<Question> questionService;

    private static final Gson gson=new Gson();

    @PostMapping("/question")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        try{
            Question newQuestion=questionService.save(question);
            return  ResponseEntity.status(201).body(gson.toJson(Response.getInstance("Questino has been added successfully",newQuestion)));
        }catch(Exception e){
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    };

    @GetMapping("/question/{id}")
    public ResponseEntity getQuestionById(@PathVariable int id){
        try{
            Optional<Question>  question= questionService.findQuestionById(id);
            return ResponseEntity.status(200).body(gson.toJson(Response.getInstance(null,question)));
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(404).body(gson.toJson(Response.getInstance("Question not found!",null)));
        }
        catch(Exception e){
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    };

    @PutMapping("/question/{id}")
    public ResponseEntity<String> editQuestion(@RequestBody Question question,@PathVariable int id){
        try{
            Optional<Question>  oldQuestion= questionService.findQuestionById(id);
            if(oldQuestion.isPresent()) {
                oldQuestion.get().setQuestion(question.getQuestion());
                questionService.edit(oldQuestion.get());
                return ResponseEntity.status(200).body(gson.toJson(Response.getInstance("Question has been updated successfully", null)));
            }
            else{
                throw new EntityNotFoundException();
            }
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(404).body(gson.toJson(Response.getInstance("Question not found!",null)));
        }
        catch(Exception e){
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    };

}
