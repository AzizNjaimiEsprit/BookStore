package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Answer;
import tn.esprit.BookStore.repository.AnswerRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImp implements AnswerService<Answer> {

    @Autowired
    AnswerRepo answerRepo;

    @Override
    public void save(Answer answer) {
        answerRepo.save(answer);
    }

    @Override
    public void edit(Answer answer) {
        answerRepo.save(answer);
    }

    @Override
    public Optional<Answer> findAnswerById(int id) throws EntityNotFoundException  {
        Optional<Answer> answer= answerRepo.findById(id);
        if(answer.isPresent()){
            return answer;
        }
        else
            throw new EntityNotFoundException();
    }

}
