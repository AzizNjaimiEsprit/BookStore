package tn.esprit.BookStore.controller;

import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.BookStore.model.Quiz;
import tn.esprit.BookStore.model.Response;
import tn.esprit.BookStore.service.QuizService;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Type;
import java.util.List;

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
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    }

    @GetMapping("/quiz/{book_id}")
    public ResponseEntity<String> getQuizByBookId(@PathVariable("book_id") int bookId){
        try{
            List<Quiz> quiz=quizService.findQuizByBook(bookId);
            Gson gson = new GsonBuilder().registerTypeAdapter(Quiz.class, new JsonSerializer<Quiz>() {
                @Override
                public JsonElement serialize(Quiz quiz, Type type, JsonSerializationContext jsonSerializationContext) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("question",quiz.getQuestion().getQuestion());
                    jsonObject.addProperty("firstAnswer",quiz.getQuestion().getAnswer().getFirstAnswer());
                    jsonObject.addProperty("secondAnswer",quiz.getQuestion().getAnswer().getSecondAnswer());
                    jsonObject.addProperty("thirdAnswer",quiz.getQuestion().getAnswer().getThirdAnswer());
                    jsonObject.addProperty("correctAnswer",quiz.getQuestion().getAnswer().getCorrectAnswer());

                    return jsonObject;
                }
            }).create();
            if(quiz.isEmpty()){
                throw new EntityNotFoundException();
            }
            return ResponseEntity.status(200).body(gson.toJson(Response.getInstance(null,quiz)));
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(404).body(gson.toJson(Response.getInstance("Quiz not found, Please add it or check for updates!",null)));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(gson.toJson(Response.getInstance("An error has been occurred!",null)));
        }
    }
}
