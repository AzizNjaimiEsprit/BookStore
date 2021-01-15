package tn.esprit.BookStore.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Answer;
import tn.esprit.BookStore.model.Response;
import tn.esprit.BookStore.service.AnswerService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
public class AnswerControl {

    @Autowired
    AnswerService<Answer> answerService;

    private static final Gson gson=new Gson();

    @PostMapping("/answer")
    public ResponseEntity<String> addAnswer(@RequestBody Answer answer){
        try{
             Answer newAnswer =answerService.save(answer);
            return ResponseEntity.status(201).body(gson.toJson(Response.getInstance("Answer has been added successfully",newAnswer)));
        }
        catch(Exception e){
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    }

    @PutMapping("/answer/{id}")
    public ResponseEntity<String> editAnswer(@PathVariable int id,@RequestBody Answer answer){
        try{
            Optional<Answer> oldAnswer=answerService.findAnswerById(id);
            if(oldAnswer.isPresent()) {
                oldAnswer.get().setFirstAnswer(answer.getFirstAnswer());
                oldAnswer.get().setSecondAnswer(answer.getSecondAnswer());
                oldAnswer.get().setThirdAnswer(answer.getThirdAnswer());
                oldAnswer.get().setCorrectAnswer(answer.getCorrectAnswer());
                answerService.edit(oldAnswer.get());
                return ResponseEntity.status(200).body(gson.toJson(Response.getInstance("Answer has been updated successfully", null)));
            }
            else{
                throw new EntityNotFoundException();
            }
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(404).body(gson.toJson(Response.getInstance("Answer not found!",null)));
        }
        catch(Exception e){
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    }


    @GetMapping("/answer/{id}")
    public ResponseEntity<String> getAnswerById(@PathVariable int id){
        try{
            Optional<Answer> answer= answerService.findAnswerById(id);
            return ResponseEntity.status(200).body(gson.toJson(Response.getInstance(null,answer)));
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(404).body(gson.toJson(Response.getInstance("Answer not found!",null)));
        }
        catch(Exception e){
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    }


}
