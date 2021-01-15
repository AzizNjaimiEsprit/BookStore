package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Question;
import tn.esprit.BookStore.repository.QuestionRepo;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class QuestionServiceImp implements QuestionService<Question> {

    @Autowired
    QuestionRepo questionRepo;

    public Question save(Question question){
        return questionRepo.save(question);
    }

    @Override
    public Optional<Question> findQuestionById(int id) throws EntityNotFoundException {
        Optional<Question> question=questionRepo.findById(id);
        if(question.isPresent()){
            return question;
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void edit(Question question) {
        questionRepo.save(question);
    }

}
